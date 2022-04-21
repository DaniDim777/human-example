package ru.human.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * сущность хьюман
 */
@Entity
@Table(name = "human")
@Getter
@Setter
@NoArgsConstructor
public class Human {

    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * имя
     */
    @Column(name = "name")
    private String name;

    /**
     * фамилия
     */
    @Column(name = "surname")
    private String surname;

    /**
     * возраст
     */
    @Column(name = "age")
    private int age;

    /**
     * почта
     */
    @Column(name = "email")
    private String email;

    /**
     * телефон
     */
    @Column(name = "phone")
    private String phone;

    /**
     * город
     */
    @Column(name = "city")
    private String city;

    /**
     * удаление
     */
    @Column(name = "delete")
    private boolean deleted;

    public Human(String name, String surname, int age, String email, String phone, String city,
                 boolean deleted, List<Animal> animals) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.deleted = deleted;
    }
}
