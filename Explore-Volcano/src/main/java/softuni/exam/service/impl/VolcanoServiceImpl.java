package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanoSeedDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.CountryService;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

// TODO: Implement all methods
@Service
public class VolcanoServiceImpl implements VolcanoService {
    private static final String VOLCANOES_FILE_PATH = "src/main/resources/files/json/volcanoes.json";
    private final VolcanoRepository volcanoRepository;
    private final CountryService countryService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, CountryService countryService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.volcanoRepository = volcanoRepository;
        this.countryService = countryService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return volcanoRepository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {

        return Files.readString((Path.of(VOLCANOES_FILE_PATH)));
    }

    @Override
    public String importVolcanoes() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readVolcanoesFileContent(), VolcanoSeedDTO[].class))
                .filter(
                        volcanoSeedDTO -> {
                            boolean isValid = validationUtil.isValid(volcanoSeedDTO);

                            Optional<Volcano> volcanoWithName = volcanoRepository.findByName(volcanoSeedDTO.getName());
                            if (volcanoWithName.isPresent()) {
                                isValid = false;
                            }
                            sb.append(isValid
                                            ? String.format("Successfully imported volcano %s of type %s"
                                            , volcanoSeedDTO.getName()
                                            , volcanoSeedDTO.getVolcanoType())
                                            : "Invalid volcano")
                                    .append(System.lineSeparator());

                            return isValid;
                        })
                .map(volcanoSeedDTO -> {
                    Volcano volcano = modelMapper.map(volcanoSeedDTO, Volcano.class);

                    Country country = countryService.getCountryById(volcanoSeedDTO.getCountry()).orElse(null);

                    country.getVolcanoes().add(volcano);
                    countryService.saveAddedVolcanoInCountry(country);

                    volcano.setCountry(country);
                    return volcano;
                })

                .forEach(v -> volcanoRepository.save(v));

        return sb.toString().trim();
    }

    @Override
    public Volcano findVolcanoById(Long volcanoId) {
        return volcanoRepository.findById(volcanoId).orElse(null);
    }

    @Override
    public void addAndSaveAddedVolcano(Volcano volcano, Volcanologist volcanologist) {
        volcano.getVolcanologists().add(volcanologist);
        volcanoRepository.save(volcano);

    }

    @Override
    public String exportVolcanoes() {
        StringBuilder sb = new StringBuilder();


        Set<Volcano> allVolcanoesByType = volcanoRepository.findByElevationGreaterThanAndActiveIsTrueAndLastEruptionIsNotNullOrderByElevationDesc();

        allVolcanoesByType.forEach(v -> {
            sb.append(String.format("Volcano: %s\n" +
                                    "   *Located in: %s\n" +
                                    "   **Elevation: %d\n" +
                                    "   ***Last eruption on: %s",
                            v.getName(),
                            v.getCountry().getName(),
                            v.getElevation(),
                            v.getLastEruption()))
                    .append(System.lineSeparator());

        });



        return sb.toString();
    }
}