package ru.handh.lesson_3_shahin;

public class Profile {

    private String name;
    private String surname;
    private String email;
    private String login;
    private String region;
    private int numberCard;

    public Profile(String name, String surname, String email, String login, String region, int numberCard) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.region = region;
        this.numberCard = numberCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }
}
