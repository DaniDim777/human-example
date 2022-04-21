package ru.human.converter;

import ru.human.dto.AnimalDTO;
import ru.human.entity.Animal;

public class ConverterAnimalToAnimalDTO implements IHumanConverter<AnimalDTO, Animal> {

    public static final ConverterAnimalToAnimalDTO ANIMAL_TO_ANIMAL_DTO = new ConverterAnimalToAnimalDTO();

    private ConverterAnimalToAnimalDTO() {
    }

    @Override
    public AnimalDTO convert(Animal animal) {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setName(animal.getName());
        animalDTO.setHuman(animal.getHuman());
        return animalDTO;
    }
}
