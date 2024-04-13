package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanologistRootSeedDTO;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class VolcanologistServiceImpl implements VolcanologistService {
    private static final String VOLCANOLOGIST_FILE_PATH = "src/main/resources/files/xml/volcanologists.xml";
    private final VolcanologistRepository volcanologistRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.volcanologistRepository = volcanologistRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
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

        xmlParser.fromFile(VOLCANOLOGIST_FILE_PATH, VolcanologistRootSeedDTO.class)
                .getVolcanologistsDTOList().stream()
                .filter(volcanologistSeedDTO -> {
                    boolean isValid = validationUtil.isValid(volcanologistSeedDTO);

                    Optional<Volcanologist> volcanologist =volcanologistRepository
                            .findByFirstNameAndLastName(volcanologistSeedDTO.getFirstName()
                                    ,volcanologistSeedDTO.getLastName());
                    if(volcanologist.isPresent()){
                        isValid=false;
                    }






                })


        return sb.toString();
    }
}