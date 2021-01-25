package com.example.materiaui_assignment2;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.materiaui_assignment2.dao.PersonDao;
import com.example.materiaui_assignment2.db.AppDatabase;
import com.example.materiaui_assignment2.model.Person;

import java.util.List;

public class NextScreen extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        PersonDao personDao = db.personDao();
        List<Person> allPerson = personDao.getAll();

//
//        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.next_screen, R.id.textView, allPerson));
        System.out.println("Aisha: "+allPerson);
    }

    private void retrieveTask(){

    }


}
