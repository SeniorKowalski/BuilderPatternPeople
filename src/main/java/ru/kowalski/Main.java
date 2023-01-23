package ru.kowalski;

public class Main {

    public static void main(String[] args) {

        Person man = PersonBuilder.builder()
                .setName("John")
                .setSurname("Smith")
                .setAddress("New York")
                .setAge(35)
                .build();
        Person son = man.newChildBuilder().build();
        man.birthday();
        System.out.println(man.getAge());
        System.out.println(son.getSurname());
    }
}
