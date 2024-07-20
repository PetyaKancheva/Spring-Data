package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class CountrySeedDTO {
    @Expose
    @Size(min=7 , max=7)
    private String name;
    @Expose
    @Size(min=3 , max=30)
    private String capital;
}
