package ru.human.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.human.dto.AnimalDTO;
import ru.human.dto.EditAnimalDTO;
import ru.human.dto.EditHumanDTO;
import ru.human.dto.HumanDTO;
import ru.human.api.IHumanService;
import ru.human.validation.Phone;

import javax.validation.Valid;
import java.util.List;

/**
 * контроллер для взаимодействиями с хьюман
 */
@Validated
@RestController
@RequestMapping("/humans")
public class HumanController {

    /**
     * интерфейс для взаимодействия с хьюман
     */
    private final IHumanService humanService;

    @Autowired
    public HumanController(IHumanService humanService) {
        this.humanService = humanService;
    }

    /**
     * метод внесения нового хьюмана в базу данных
     *
     * @param phone телефон хьюмана
     * @param editHumanDTO сущность с набором полей для редактирования хьюмана
     * @return хьюман DTO
     */
    @PostMapping
    public HumanDTO create(@RequestParam @Valid @Phone String phone, @RequestBody EditHumanDTO editHumanDTO) {
        return humanService.create(phone, editHumanDTO);
    }

    /**
     * метод получения хьюмана по идентификатору
     *
     * @param id идентификатор
     * @return хьюман DTO
     */
    @GetMapping("/{id}")
    public HumanDTO get(@PathVariable Long id) {
        return humanService.get(id);
    }

    /**
     * метод изменения хьюмана
     *
     * @param editHumanDTO сущность с набором полей для редактирования хьюмана
     * @param id идентификатор
     * @return хьюман DTO
     */
    @PutMapping("/{id}")
    public HumanDTO update(@RequestBody EditHumanDTO editHumanDTO, @PathVariable Long id) {
        return humanService.update(editHumanDTO, id);
    }

    /**
     * метод удаления хьюмана по идентификатору
     *
     * @param id идентификатор
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        humanService.delete(id);
    }

    /**
     * метод получения хьюмана по имени
     *
     * @param name имя
     * @return хьюман DTO
     */
    @GetMapping("/{name}")
    public List<HumanDTO> find(@PathVariable String name) {
        return humanService.find(name);
    }

    /**
     * метод получения всех хьюманов
     *
     * @return список хьюман DTO
     */
    @GetMapping
    public List<HumanDTO> findAll() {
        return humanService.findAll();
    }

//    @PostMapping("/animals")
//    public AnimalDTO create(@RequestBody EditAnimalDTO editAnimalDTO) {
//        return humanService.create_animal(editAnimalDTO);
//    }
//
//    @GetMapping("/animals/{name}")
//    public List<AnimalDTO> find_animal(@PathVariable String name) {
//        return humanService.find_animal(name);
//    }
}
