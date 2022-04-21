package ru.human.converter;

import ru.human.dto.EditHumanDTO;
import ru.human.entity.Human;

/**
 * конвертер для перевода сущности EditHumanDTO в сущность Human
 */
public class ConverterEditHumanDTOToHuman implements IHumanConverter<Human, EditHumanDTO> {

    /**
     * синглтон
     */
    public static final ConverterEditHumanDTOToHuman EDIT_TO_ENTITY = new ConverterEditHumanDTOToHuman();

    private ConverterEditHumanDTOToHuman() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Human convert(EditHumanDTO editHumanDTO) {
        Human human = new Human();
        human.setName(editHumanDTO.getName());
        human.setSurname(editHumanDTO.getSurname());
        human.setAge(editHumanDTO.getAge());
        human.setEmail(editHumanDTO.getEmail());
//        human.setPhone(editHumanDTO.getPhone());
        human.setCity(editHumanDTO.getCity());
//        human.setAnimals(editHumanDTO.getAnimals());
        return human;
    }
}
