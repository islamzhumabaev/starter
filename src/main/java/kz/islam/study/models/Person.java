package kz.islam.study.models;

import javax.validation.constraints.*;

public class Person {
    @NotEmpty(message = "Please enter your IIN.")
    private String iin;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Surname should not be empty")
    private String surname;
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    @Pattern(
            regexp = "^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}$",
            message = "Invalid Kazakh phone number"
    )
    private String phone;
    @NotEmpty(message = "Gender should not be empty")
    private String gender;
    @NotEmpty(message = "Citizenship should not be empty")
    private String citizenship;
    private String email;
    private int accountNumber;
    private int salary;
    private double wallet;
    public Person() {}

    public Person(String iin, String name, String surname, int age, String phone, String gender, String citizenship) {
        this.iin = iin;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.citizenship = citizenship;
        this.email=" ";
        this.accountNumber=0;
        this.salary=0;
        this.wallet=0;
    }

    public String getIin() {
        return iin;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getWallet() {
        return wallet;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getEmail() {
        return email;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
