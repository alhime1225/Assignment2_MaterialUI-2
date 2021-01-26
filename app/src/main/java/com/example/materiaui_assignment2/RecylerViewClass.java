package com.example.materiaui_assignment2;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materiaui_assignment2.dao.PersonDao;
import com.example.materiaui_assignment2.db.AppDatabase;
import com.example.materiaui_assignment2.model.Person;

import java.util.List;

public class RecylerViewClass extends AppCompatActivity {
    public RecyclerView mRecyclerView;
    //TODO 1. Initialise Database


    private  PersonAdapter mPersonAdapter;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        //TODO 2. Initialize RecyclerView
        mRecyclerView = findViewById(R.id.recyclerViewID);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //TODO 3. Bind the custom adapter
        mPersonAdapter = new PersonAdapter(this);
        mRecyclerView.setAdapter(mPersonAdapter);

        //TODO 5. Call function
        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        PersonDao personDao = db.personDao();
        List<Person> allPerson = personDao.getAll();
        mPersonAdapter.setPersonDataInAdapter(allPerson);
//        this.setListAdapter(new ArrayAdapter<Person>(this, R.layout.next_screen, R.id.textView, allPerson));
    }

//    public void retrievePersonListFromDatabase(){
//        //TODO 4. Call worker thread to get the data and pass to adapter
//        AppDatabase db = AppDatabase.getDB(getApplicationContext());
//        PersonDao personDao = db.personDao();
//
//        List<Person> personList = personDao.getAll();
//        mPersonAdapter.setPersonDataInAdapter(personList);
//    }
}
