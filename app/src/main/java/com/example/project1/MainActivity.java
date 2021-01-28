package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.Calendar;

import com.example.project1.database.AppDatabase;
import com.example.project1.javaUtil.AppExecutors;
import com.example.project1.entities.Person;

public class MainActivity extends AppCompatActivity {
   Spinner AreaSpinner;
   Spinner StateSpinner;
   EditText BirthdayEdittext;
   ImageButton BirthdayPicker;
   int Days;
   int Months;
   int Years;
   EditText Name;
   EditText Phone;
   EditText Address;
   EditText City;
   EditText Zip;
   EditText Email;


  private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AreaSpinner = (Spinner) findViewById(R.id.areaspinner);
        ArrayAdapter<CharSequence> areaadapter = ArrayAdapter.createFromResource(this,
                R.array.Area_array, android.R.layout.simple_spinner_item);
        areaadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AreaSpinner.setAdapter(areaadapter);


        StateSpinner = (Spinner) findViewById(R.id.spinnerstate);
        ArrayAdapter<CharSequence> stateadapter = ArrayAdapter.createFromResource(this,
                R.array.State_array, android.R.layout.simple_spinner_item);
        stateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        StateSpinner.setAdapter(stateadapter);


        getBirthdayID();
        getDetialsUI();
    }

    public void getBirthdayID ()
    {
        BirthdayEdittext = findViewById(R.id.birthdaytext);
        BirthdayPicker = findViewById(R.id.birthdaypicker);
    }

    public void getBirthdayPicker (View view)
    {
        if (view == BirthdayPicker)
        {
            final  Calendar calendar = Calendar.getInstance();
           Days = calendar.get(Calendar.DAY_OF_MONTH);
           Months = calendar.get(Calendar.MONTH);
           Years = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                        {
                            BirthdayEdittext.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        }
                    }, Days, Months, Years);
            datePickerDialog.show();

        }
    }

    public void getDatabase ()
    {
        appDatabase = AppDatabase.getInstance(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        getDatabase();

    }

    public void getDetialsUI ()
    {
        Name = findViewById(R.id.name);
        Phone = findViewById(R.id.PhoneEditText);
        Email = findViewById(R.id.emailtext);
        Address = findViewById(R.id.addresstext);
        City = findViewById(R.id.citytext);
        Zip = findViewById(R.id.zipstate);

    }

    public void savePersonData(View view ){

        final Person person = new Person(
                Name.getText().toString(),
                Phone.getText().toString(),
                "value",
                Address.getText().toString(),
                City.getText().toString(),
                "StateSpinner.toString()",
                Zip.getText().toString(),
                Email.getText().toString(),
                BirthdayEdittext.getText().toString()
        );


        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    appDatabase.iPersonDAO().insertPerson(person);
                }
                catch (Exception e)
                {
                    Log.e("ErrorDatabase", e.getLocalizedMessage());
                }
            }
        });


        Intent intent = new Intent(MainActivity.this, DatabaseListView.class);
        startActivity(intent);

    }



}