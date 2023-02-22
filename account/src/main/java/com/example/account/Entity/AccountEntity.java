package com.example.account.Entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id")
    private Long id;

    @Column(name = "acc_name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "acc_id")
    private int age;

    @Column(name = "address")
    private String address;

        //constructor
    public AccountEntity() {
    }

    public AccountEntity(String name, String gender, int age, String address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
