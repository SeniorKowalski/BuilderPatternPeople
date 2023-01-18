package ru.kowalski;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Optional;

@ToString
@EqualsAndHashCode
@Builder(setterPrefix = "set", builderClassName = "PersonBuilder")
public class Person {

    protected final String name;
    protected final String surname;
    private Integer age;
    private String address;

    public String getName() {
        return name;
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

    public PersonBuilder newChildBuilder() {
        return Person.builder().setSurname(this.surname).setAge(0).setAddress(this.address);
    }

    public PersonBuilder Builder() {
        return new CustomPersonBuilder();
    }

    private class CustomPersonBuilder extends PersonBuilder {
        @Override
        public Person build() {
            Optional.ofNullable(surname).orElseThrow(() -> new IllegalArgumentException("Не хватает обязательных полей. Используйте .setSurname"));
            return super.build();
        }
    }

    public static class PersonBuilder {
        public PersonBuilder setAge(int age) {
            if (age >= 0) this.age = age;
            else throw new IllegalArgumentException("Введён недопустимый возраст ");
            return this;
        }
    }
}