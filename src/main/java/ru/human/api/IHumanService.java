package ru.human.api;

import ru.human.dto.EditHumanDTO;
import ru.human.dto.HumanDTO;
import ru.human.exception.NoSuchHumanException;

import java.util.List;

/**
 * интерфейс для взаимодействия с хьюман
 */
public interface IHumanService {

    /**
     * создает сущность хьюман
     *
     * @param phone номер телефона хьюмана
     * @param editHumanDTO сущность с набором полей для редактирования хьюмана
     * @return хьюман DTO
     *
     */
    HumanDTO create(String phone, EditHumanDTO editHumanDTO);

    /**
     * редактирует сущность хьюман
     *
     * @param editHumanDTO сущность с набором полей для редактирования хьюмана
     * @param id идентификатор для поиска необходимой для редактирования сущности хьюман
     * @return хьюман DTO
     */
    HumanDTO update(EditHumanDTO editHumanDTO, Long id);

    /**
     * удаляет сущность хьюман
     *
     * @param id идентификатор для поиска необходимой для удаления сущности хьюман
     */
    void delete(Long id);

    /**
     * получает сущность хьюман по идентификатору
     *
     * @param id идентификатор для поиска необходимой сущности хьюман
     * @return хьюман DTO
     * @throws NoSuchHumanException исключение если сущность хьюман не найдена
     */
    HumanDTO get(Long id) throws NoSuchHumanException;

    /**
     * получает сущность хьюман по имени
     *
     * @param name имя для поиска необходимой сущности хьюман
     * @return список хьюман DTO
     */
    List<HumanDTO> find(String name);

    /**
     * получает все сущности хьюман
     *
     * @return список хьюман DTO
     */
    List<HumanDTO> findAll();
}
