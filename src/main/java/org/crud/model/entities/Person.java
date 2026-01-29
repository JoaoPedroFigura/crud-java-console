package org.crud.model.entities;


public class Person {

    private String name;
    private Integer age;
    private String email;
    private final Integer id;

    public Person(String name, Integer age, String email, Integer id) {

        if (name == null) {
            throw new IllegalArgumentException("name is invalid");
        }
        if (age == null || age < 0) {
            throw new IllegalArgumentException("age is invalid");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("email is invalid");
        }
        if (id == null) {
            throw new IllegalArgumentException("id is invalid");
        }

        this.name = name;
        this.age = age;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is invalid");
        }
        this.name = name;
    }

    public void setAge(Integer age) {
        if (age == null || age < 0) {
            throw new IllegalArgumentException("age is invalid");
        }
        this.age = age;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("email is invalid");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age + ", email=" + email + ", id=" + id;
    }
}
