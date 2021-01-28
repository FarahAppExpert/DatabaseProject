package com.example.project1;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.project1.database.AppDatabase;
import com.example.project1.entities.Person;
import com.example.project1.javaUtil.AppExecutors;

import java.util.ArrayList;
import java.util.List;

public class DatabaseListView extends ListActivity {
    private AppDatabase appDatabase;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getPersonData();
        setTask();
    }

    public void getPersonData ()
    {
        appDatabase = AppDatabase.getInstance(getApplicationContext());
    }

    public void setTask ()
    {

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                personList = appDatabase.iPersonDAO().loadAllPerson();
                final List<String> list = new ArrayList<>();
                for(int i =0; i<personList.size(); i++)
                    list.add(personList.get(i).getName());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                                DatabaseListView.this,
                                R.layout.activity_database_list_view,
                                R.id.text_view,
                                list);
                        DatabaseListView.this.setListAdapter(arrayAdapter);
                    }
                });
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }



}