package ru.human.converter;

import ru.human.dto.HumanDTO;
import ru.human.entity.Human;

/**
 * конвертер для перевода сущности Human в сущность HumanDTO
 */
public class ConverterHumanToHumanDTO implements IHumanConverter<HumanDTO, Human> {

    /**
     * синглтон
     */
    public static final ConverterHumanToHumanDTO ENTITY_TO_DTO = new ConverterHumanToHumanDTO();

    private ConverterHumanToHumanDTO() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HumanDTO convert(Human human) {
        HumanDTO humanDTO = new HumanDTO();
        humanDTO.setId(human.getId());
        humanDTO.setName(human.getName());
        humanDTO.setSurname(human.getSurname());
        humanDTO.setAge(human.getAge());
        humanDTO.setEmail(human.getEmail());
        humanDTO.setPhone(human.getPhone());
        humanDTO.setCity(human.getCity());
//        humanDTO.setAnimals(human.getAnimals());
        return humanDTO;
    }
}
