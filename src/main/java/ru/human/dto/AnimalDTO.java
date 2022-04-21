package ru.human.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.human.entity.Human;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class AnimalDTO {

    private Long id;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("human_id")
    @NotNull
    private Human human;
}
