package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.VolcanoService;
import softuni.exam.service.VolcanologistService;

import java.io.IOException;

// TODO: Implement all methods
@Service
public class VolcanoServiceImpl implements VolcanoService {

    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return null;
    }

    @Override
    public String importVolcanoes() throws IOException {
        return null;
    }

    @Override
    public String exportVolcanoes() {
        return null;
    }
}