package ru.handh.lesson_1_shahin;

public class Student {

    private long id;
    private String name;
    private String surname;
    private String grade;
    private int birthdayYear;

    public Student(long id, String name, String surname, String grade, int birthdayYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.birthdayYear = birthdayYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGrade() {
        return grade;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }
}
