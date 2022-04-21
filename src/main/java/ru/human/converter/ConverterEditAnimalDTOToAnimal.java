package ru.human.converter;

import ru.human.dto.EditAnimalDTO;
import ru.human.entity.Animal;

public class ConverterEditAnimalDTOToAnimal implements IHumanConverter<Animal, EditAnimalDTO> {

    public static final ConverterEditAnimalDTOToAnimal EDIT_ANIMAL_DTO_TO_ANIMAL = new ConverterEditAnimalDTOToAnimal();

    private ConverterEditAnimalDTOToAnimal() {
    }

    @Override
    public Animal convert(EditAnimalDTO editAnimalDTO) {
        Animal animal = new Animal();
        animal.setName(editAnimalDTO.getName());
        animal.setHuman(editAnimalDTO.getHuman());
        return animal;
    }
}
