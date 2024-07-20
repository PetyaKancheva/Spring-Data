package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanologistRootSeedDTO;
import softuni.exam.models.dto.VolcanologistSeedDTO;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO: Implement all methods
@Service
public class VolcanologistServiceImpl implements VolcanologistService {
    private static final String VOLCANOLOGIST_FILE_PATH = "src/main/resources/files/xml/volcanologists.xml";
    private final VolcanologistRepository volcanologistRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final VolcanoService volcanoService;
    private final ModelMapper modelMapper;

    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, XmlParser xmlParser, ValidationUtil validationUtil, VolcanoService volcanoService, ModelMapper modelMapper) {
        this.volcanologistRepository = volcanologistRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.volcanoService = volcanoService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return Files.readString(Path.of(VOLCANOLOGIST_FILE_PATH));
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

            List<VolcanologistSeedDTO> volcanologistList = xmlParser.fromFile(VOLCANOLOGIST_FILE_PATH, VolcanologistRootSeedDTO.class)
                    .getVolcanologistsDTOList().stream().collect(Collectors.toList());

        volcanologistList.stream()
                .filter(volcanologistSeedDTO -> {
//                    boolean isValid = true;

                    boolean isValid = validationUtil.isValid(volcanologistSeedDTO);


                    Volcano volcano = volcanoService.findVolcanoById(volcanologistSeedDTO.getExploringVolcano());
                    if (volcano == null) {
                        isValid = false;
                    }

                    Volcanologist volcanologist = volcanologistRepository
                            .findByFirstNameAndLastName(volcanologistSeedDTO.getFirstName()
                                    , volcanologistSeedDTO.getLastName()).orElse(null);

                    if (volcanologist !=null) {
                        isValid = false;
                    }

                    sb.append(isValid
                                ? String.format("Successfully imported volcanologist %s %s", volcanologistSeedDTO.getFirstName(), volcanologistSeedDTO.getLastName())
                                    : "Invalid volcanologist")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(volcanologistSeedDTO -> {
                    Volcanologist volcanologist = modelMapper.map(volcanologistSeedDTO, Volcanologist.class);

                    Volcano volcano = volcanoService.findVolcanoById(volcanologistSeedDTO.getExploringVolcano());
                    volcanoService.addAndSaveAddedVolcano(volcano, volcanologist);
                    volcanologist.setExploringVolcano(volcano);
                    return volcanologist;
                }).forEach(person -> volcanologistRepository.save(person));

        return sb.toString();
    }
}