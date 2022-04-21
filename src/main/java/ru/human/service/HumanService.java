package ru.human.service;

import org.springframework.stereotype.Service;
import ru.human.api.IHumanService;
import ru.human.converter.ConverterAnimalToAnimalDTO;
import ru.human.converter.ConverterEditAnimalDTOToAnimal;
import ru.human.converter.ConverterEditHumanDTOToHuman;
import ru.human.converter.ConverterHumanToHumanDTO;
import ru.human.dto.AnimalDTO;
import ru.human.dto.EditAnimalDTO;
import ru.human.dto.EditHumanDTO;
import ru.human.dto.HumanDTO;
import ru.human.entity.Animal;
import ru.human.entity.Human;
import ru.human.exception.NoSuchHumanException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * сервис для бизнес-логики приложения
 */
@Service
public class HumanService implements IHumanService {

    @PersistenceContext
    private EntityManager entityManager;

    private final String QUERY_FIND_HUMANS = "from Human where name =:humanName and deleted = false";
//    private final String QUERY_FIND_ANIMALS = "from Animal where name =:animalName";

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public HumanDTO create(String phone, EditHumanDTO editHumanDTO) {
        Human human = ConverterEditHumanDTOToHuman.EDIT_TO_ENTITY.convert(editHumanDTO);
        human.setPhone(phone);
        entityManager.persist(human);
        HumanDTO humanDTO = ConverterHumanToHumanDTO.ENTITY_TO_DTO.convert(human);
        return humanDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public HumanDTO update(EditHumanDTO editHumanDTO, Long id) {
        Human human = entityManager.find(Human.class, id);
        if (human.isDeleted()) {
            throw new NoSuchHumanException("Human with ID = " + id + " not found");
        }
        human = ConverterEditHumanDTOToHuman.EDIT_TO_ENTITY.convert(editHumanDTO);
        human.setId(id);
        entityManager.merge(human);
        HumanDTO humanDTO = ConverterHumanToHumanDTO.ENTITY_TO_DTO.convert(human);
        return humanDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(Long id) {
        Human human = entityManager.find(Human.class, id);
        if (human.isDeleted()) {
            throw new NoSuchHumanException("Human with ID = " + id + " not found");
        }
        human.setDeleted(true);
        entityManager.persist(human);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public HumanDTO get(Long id) {
        Human human = entityManager.find(Human.class, id);
        if (human == null || human.isDeleted()) {
            throw new NoSuchHumanException("Human with ID = " + id + " not found");
        }
        HumanDTO humanDTO = ConverterHumanToHumanDTO.ENTITY_TO_DTO.convert(human);
        return humanDTO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<HumanDTO> find(String name) {
        List<Human> allHumans = entityManager
                .createQuery(QUERY_FIND_HUMANS).setParameter("humanName", name)
                .getResultList();
        return allHumans.stream()
                .map(ConverterHumanToHumanDTO.ENTITY_TO_DTO::convert)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<HumanDTO> findAll() {
        List<Human> allHumans = entityManager
                .createQuery("from Human", Human.class)
                .getResultList();
        return allHumans.stream().
                map(ConverterHumanToHumanDTO.ENTITY_TO_DTO::convert)
                .collect(Collectors.toList());
    }

//    @Override
//    @Transactional
//    public AnimalDTO create_animal(EditAnimalDTO editAnimalDTO) {
//        Animal animal = ConverterEditAnimalDTOToAnimal.EDIT_ANIMAL_DTO_TO_ANIMAL.convert(editAnimalDTO);
//        entityManager.merge(animal);
//        AnimalDTO animalDTO = ConverterAnimalToAnimalDTO.ANIMAL_TO_ANIMAL_DTO.convert(animal);
//        return animalDTO;
//    }
//
//    @Override
//    @Transactional
//    public List<AnimalDTO> find_animal(String name) {
//        List<Animal> allAnimals = entityManager
//                .createQuery(QUERY_FIND_ANIMALS).setParameter("animalName", name)
//                .getResultList();
//        return allAnimals.stream()
//                .map(ConverterAnimalToAnimalDTO.ANIMAL_TO_ANIMAL_DTO::convert)
//                .collect(Collectors.toList());
//    }
}