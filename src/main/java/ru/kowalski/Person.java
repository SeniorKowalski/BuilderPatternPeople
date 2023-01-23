package ru.kowalski;

import java.util.Optional;

public class Person {

    private final String name;
    private final String surname;
    private Integer age;
    private String address;

    public Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return Optional.ofNullable(this.name).orElseThrow(() -> new IllegalArgumentException("Имя не указано"));
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return Optional.ofNullable(this.age).orElseThrow(() -> new IllegalArgumentException("Возраст не указан"));
    }

    public String getAddress() {
        return Optional.ofNullable(this.address).orElseThrow(() -> new IllegalArgumentException("Адрес не указан"));
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void birthday() {
        if (hasAge()) this.age++;
    }

    public boolean hasAge() {
        return this.age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public PersonBuilder newChildBuilder() {
        return PersonBuilder.builder().setSurname(this.surname).setAge(0).setAddress(this.address);
    }
}