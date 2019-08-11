package com.example.labroomdatabaseapi28;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface PersonDAO
{
    // Method that returns a list containing all the people in the database
    @Query("SELECT * FROM person")
    List<Person> getAll();

    // Method that inserts a list containing all the p
    // id = primary key in person entity class
    @Insert
    void insertAll(Person... person);
}
