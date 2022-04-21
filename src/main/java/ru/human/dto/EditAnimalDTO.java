package ru.human.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.human.entity.Human;

@Getter
@Setter
@NoArgsConstructor
public class EditAnimalDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("human_id")
    private Human human;
}
