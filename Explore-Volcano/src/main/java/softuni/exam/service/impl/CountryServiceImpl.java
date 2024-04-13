package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;


@Service
public class CountryServiceImpl implements CountryService {
    private final Gson gson;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private static final String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";

    public CountryServiceImpl(Gson gson, CountryRepository countryRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gson = gson;
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count()>0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {

        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCountriesFromFile(), CountrySeedDTO[].class)).filter(
                        countrySeedDTO -> {
                            boolean isValid = validationUtil.isValid((countrySeedDTO));
                            Optional<Country> countryByName = countryRepository.findByName(countrySeedDTO.getName());

                            if (countryByName.isPresent()) {
                                isValid = false;
                            }
                            sb.append(isValid
                                    ? String.format("Successfully imported country %s - %s", countrySeedDTO.getName(), countrySeedDTO.getCapital())
                                    :"Invalid country").append(System.lineSeparator());
                            return isValid;

                        })

                .map(countrySeedDTO -> modelMapper.map(countrySeedDTO, Country.class)).forEach(country -> countryRepository.save(country));
        return  sb.toString().trim();
    }

    @Override
    public Optional<Country> getCountryById(Long countryId) {
        return countryRepository.findById(countryId);
    }

    @Override
    public void saveAddedVolcanoInCountry(Country country) {
        countryRepository.save(country);
    }
}
