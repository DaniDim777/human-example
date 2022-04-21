package ru.human.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.human.entity.Animal;
import java.util.List;

/**
 * сущность EditHumanDTO
 */
@Getter
@Setter
@NoArgsConstructor
public class EditHumanDTO {

    /**
     * имя
     */
    @JsonProperty("name")
    private String name;

    /**
     * фамилия
     */
    @JsonProperty("surname")
    private String surname;

    /**
     * возраст
     */
    @JsonProperty("age")
    private int age;

    /**
     * почта
     */
    @JsonProperty("email")
    private String email;

//    @JsonProperty("phone")
//    private String phone;

    /**
     * город
     */
    @JsonProperty("city")
    private String city;

//    @JsonProperty("animals")
//    private List<Animal> animals;
}
