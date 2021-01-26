package com.example.materiaui_assignment2.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.materiaui_assignment2.model.Person;

import java.util.List;

//Data access layer for Person entity
@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    List<Person> getAll();

//    @Query("SELECT * FROM person WHERE uid IN (:userIds)")
//    List<Person> loadAllByIds(int[] userIds);

//    @Query("SELECT * FROM person WHERE name LIKE :first " +   "LIKE :last LIMIT 1")
//    Person findByName(String first, String last);

    @Insert
    void insertAll(Person... persons);

//    @Delete
//    void delete(Person persons);
}
