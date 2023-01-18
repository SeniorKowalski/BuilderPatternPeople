package ru.kowalski;

public class Main {

    public static void main(String[] args) {

        Person man = Person.builder()
                .setName("John")
                .setSurname("Smith")
                .setAddress("New York")
                .build();
        Person son = man.newChildBuilder().build();
        System.out.println(man.getName());
        System.out.println(son.getSurname());
    }
}
