package com.example.materiaui_assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.materiaui_assignment2.dao.PersonDao;
import com.example.materiaui_assignment2.db.AppDatabase;
import com.example.materiaui_assignment2.model.Person;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextInputLayout bday;
    AutoCompleteTextView spin_area, spin_state;
    private String[] mArea = {"+53", "+61", "+43", "+973", "+32","+591", "+63", "+44"};
    private String[] mState = {"Argentina", "Australia", "Autria", "Bahrain", "Belgium", "London"};
//    private CustomAdapter recylerAdapter;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin_area = findViewById(R.id.txtArea1);
        //Ability to send the data to the view
        ArrayAdapter mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mArea);
        mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_area.setAdapter(mArrayAdapter);

        spin_state = findViewById(R.id.txtState1);
        ArrayAdapter mArrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mState);
        mArrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_state.setAdapter(mArrayAdapter1);

        bday = findViewById(R.id.bday);
        bday.setEndIconOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                datePicker(v);
            }
        });

//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recylerAdapter = new CustomAdapter(this);
//        recyclerView.setAdapter(recylerAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void datePicker(View view){
        TextInputEditText bday1 = findViewById(R.id.bday1);
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        bday1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void onSaveAction(View view){
        //Getting data from UI
        TextInputEditText txtName= findViewById(R.id.txtName1);
        String name= txtName.getText().toString();

        TextInputEditText txtPhone = findViewById(R.id.txtPhone1);
        String phone= txtPhone.getText().toString();

        AutoCompleteTextView txtArea = findViewById(R.id.txtArea1);
        String area= txtArea.getText().toString();

        TextInputEditText txtAddress = findViewById(R.id.txtAddress1);
        String address= txtAddress.getText().toString();

        TextInputEditText txtCity = findViewById(R.id.txtCity1);
        String city= txtCity.getText().toString();

        AutoCompleteTextView txtState = findViewById(R.id.txtState1);
        String state= txtState.getText().toString();

        TextInputEditText txtZip = findViewById(R.id.txtZip1);
        String zip= txtZip.getText().toString();

        TextInputEditText txtEmail = findViewById(R.id.txtEmail1);
        String email= txtEmail.getText().toString();

        TextInputEditText txtBday = findViewById(R.id.bday1);
        String birthday= txtBday.getText().toString();

        //Creating an entity object according to database
        Person person= new Person( name,  phone,  area,  address,  city,  state,  zip,  email,  birthday);

        //Getting db instance
        AppDatabase db = AppDatabase.getDB(getApplicationContext());
        //Getting a person dao
        PersonDao personDao = db.personDao();
        //Inserting entity in db
        personDao.insertAll(person);

        Toast.makeText(MainActivity.this, "Data Saved Successfully into DB" , Toast.LENGTH_LONG).show();

        Intent intent= new Intent(MainActivity.this, RecylerViewClass.class);
        startActivity(intent);

        AppDatabase.cleanUp();

    }

}