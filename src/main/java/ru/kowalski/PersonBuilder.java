package ru.kowalski;

import java.util.Optional;

public class PersonBuilder {

    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        if (age >= 0) this.age = age;
        else throw new IllegalArgumentException("Введён недопустимый возраст ");
        return this;
    }

    public Person build() {
        return new Person(name, surname, age, address);
    }

    public static PersonBuilder builder() {
        return new CustomPersonBuilder();
    }

    private static class CustomPersonBuilder extends PersonBuilder {
        @Override
        public Person build() {
            Optional.ofNullable(super.surname).orElseThrow(() -> new IllegalArgumentException("Не хватает обязательных полей. Используйте .setSurname"));
            return super.build();
        }
    }
}
