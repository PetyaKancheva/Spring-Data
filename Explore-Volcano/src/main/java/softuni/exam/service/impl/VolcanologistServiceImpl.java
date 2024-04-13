package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.VolcanologistService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

// TODO: Implement all methods
@Service
public class VolcanologistServiceImpl implements VolcanologistService {

    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return null;
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {
        return null;
    }
}