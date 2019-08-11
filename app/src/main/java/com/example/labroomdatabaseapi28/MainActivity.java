package com.example.labroomdatabaseapi28;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersonAdapter mAdapter;
    private PersonDatabase database;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting up Room DB Lab
        initializeDatabase();

        // Part 8 would just have to put this in button click method to insert
        // Cannot insert an object that has the same data, (will crash otherwise)
        // Saves after app is killed
        // Add a person to the database
        database.personDAO().insertAll(new Person(9, "Hello", "World"));

        initializePersonListData();
        initializeAttributes();
        setRecyclerView();

        mAdapter.notifyDataSetChanged();
    }

    private void initializeDatabase()
    {
        database = Room.databaseBuilder
                (getApplicationContext(),
                PersonDatabase.class, "PersonDatabase")
                .allowMainThreadQueries()
                .build();
    }

    private void initializePersonListData()
    {
        personList = database.personDAO().getAll();
    }


    private void initializeAttributes()
    {
        mAdapter = new PersonAdapter(personList);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
    }

    private void setRecyclerView()
    {
        recyclerView = findViewById(R.id.recyclerViewXML);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
