package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import softuni.exam.models.entity.Country;
import softuni.exam.models.enums.VolcanoType;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Getter
@Setter
public class VolcanoSeedDTO {
    @Expose
    @Size(min=2,max=30)
    private String name;
    @Expose
    @Positive
    private Integer elevation;
    @Expose

//    @Enumerated
    private VolcanoType volcanoType;
    @Expose
    private boolean isActive;
    @Expose
    private String lastEruption;
    @Expose
    private Long country;




}
