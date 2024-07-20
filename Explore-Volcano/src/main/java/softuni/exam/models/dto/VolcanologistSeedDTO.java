package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement(name="volcanologist")
@XmlAccessorType(XmlAccessType.FIELD)
public class VolcanologistSeedDTO {

    @XmlElement(name = "first_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @XmlElement(name = "salary")
    @Positive
    private Double salary;

    @XmlElement(name = "age")
    @Min(18)
    @Max(30)
    private int age;

    @XmlElement(name = "exploring_from")
    private String exploringFrom;

    @XmlElement(name = "exploring_volcano_id")
    private Long exploringVolcano;


}
