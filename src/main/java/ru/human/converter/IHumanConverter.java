package ru.human.converter;

/**
 * интерфейс конвертера
 *
 * @param <OUTPUT> объект конвертирования в сущность
 * @param <INPUT> объект конвертирования из сущности
 */
public interface IHumanConverter<OUTPUT, INPUT> {

   /**
    * метод конвертирования
    *
    * @param INPUT входящий объект
    * @return возвращаемый объект
    */
   OUTPUT convert(INPUT INPUT);
}
