package com.example.labroomdatabaseapi28;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1)
public abstract class PersonDatabase extends RoomDatabase
{
    // Return type PersonDAO, Method PersonDAO no parameters
    public abstract PersonDAO personDAO();
}

