package model;

import java.io.Serializable;

public class Member implements Serializable {
    private String rollNumber;
    private String name;
    private String phone;
    private String gender;
    private String skills;

    public Member(String rollNumber, String name, String phone, String gender, String skills) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.skills = skills;
    }

    public String getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getGender() { return gender; }
    public String getSkills() { return skills; }
}
