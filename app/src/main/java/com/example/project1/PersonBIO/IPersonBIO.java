package com.example.project1.PersonBIO;

import android.icu.text.Replaceable;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project1.entities.Person;
import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;
@Dao
public interface IPersonBIO
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insertPerson(Person person);

    @Query("SELECT * FROM PERSON ORDER BY ID")
    List<Person> loadAllPerson();

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson (Person person);
}





