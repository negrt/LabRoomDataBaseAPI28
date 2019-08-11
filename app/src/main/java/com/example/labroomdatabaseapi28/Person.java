package com.example.labroomdatabaseapi28;

import android.arch.persistence.room.*;

@Entity
public class Person
{
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "address")
    private String address;

    public Person(int id, String firstName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
