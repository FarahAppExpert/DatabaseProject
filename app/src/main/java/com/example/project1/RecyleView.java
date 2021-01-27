package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project1.database.AppDatabase;
import com.example.project1.entities.Person;
import com.example.project1.javaUtil.AppExecutors;

import java.util.List;

public class RecyleView extends AppCompatActivity
{

    private AppDatabase appDatabase;
    private PersonalAdaptor personalAdaptor;
    private RecyclerView recyleView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyle_view);

        appDatabase= AppDatabase.getInstance(getApplicationContext());
        recyleView =  findViewById(R.id.Recyle_View);
        recyleView.setLayoutManager(new LinearLayoutManager(this));

        personalAdaptor = new PersonalAdaptor(this);
        recyleView.setAdapter(personalAdaptor);

        retrievePersonListFromDatabase();

    }

    public void retrievePersonListFromDatabase(){
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Person> personList = appDatabase.iPersonDAO().loadAllPerson();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        personalAdaptor.setPersonDataInAdapter(personList);
                    }
                });

            }
        });
    }

}