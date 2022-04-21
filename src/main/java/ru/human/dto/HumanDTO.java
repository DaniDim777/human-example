package ru.human.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * сущность хьюман DTO
 */
@Validated
@Getter
@Setter
@NoArgsConstructor
public class HumanDTO {

    /**
     * идентификатор
     */
    private Long id;

    /**
     * имя
     */
    @JsonProperty("name")
    @NotNull
    private String name;

    /**
     * фамилия
     */
    @JsonProperty("surname")
    @NotNull
    private String surname;

    /**
     * возраст
     */
    @JsonProperty("age")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int age;

    /**
     * почта
     */
    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    /**
     * телефон
     */
    @JsonProperty("phone")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    /**
     * город
     */
    @JsonProperty("city")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String city;
}
