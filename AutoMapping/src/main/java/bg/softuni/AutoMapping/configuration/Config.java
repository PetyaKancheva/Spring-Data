package bg.softuni.AutoMapping.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper createModelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper;

    }
}
