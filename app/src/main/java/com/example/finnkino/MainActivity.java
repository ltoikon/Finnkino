package com.example.finnkino;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener {
    Spinner spinnerTheaters;
    TextView movieName;
    TextView testText;
    TextView dateText;
    String inputTextString;
    EditText startTimeField;
    EditText endTimeField;
    String startTime;
    String endTime;
    String theaterName;
    TextView movieList;
    Theater strand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Test for movie name change
        testText = (TextView) findViewById(R.id.testScreen);

        // Movie name
        movieName = (EditText) findViewById(R.id.editTextMovie);

        // Movie list
        movieList = (EditText) findViewById(R.id.editTextMovieList);

        // Dropdown for theater
        spinnerTheaters = (Spinner) findViewById(R.id.spinnerTheaters);
        spinnerTheaters.setOnItemSelectedListener(new ItemSelectedListener());
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.theater_dropdown_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTheaters.setAdapter(adapter);

        // Theaters
        strand = new Theater("Strand");
        Theater kinopalatsi = new Theater("Kinopalatsi");
        Theater kuopio = new Theater("Kuopio");

        // Date
        findViewById(R.id.buttonDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }});
        dateText = (EditText) findViewById(R.id.editTextDate);

        startTimeField = (EditText) findViewById(R.id.editTextStart);
        endTimeField = (EditText) findViewById(R.id.editTextEnd);


//        movieName.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                inputTextString = movieName.getText().toString();
//                testText.setText(inputTextString);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "." + month + "." + year;
        dateText.setText(date);
        System.out.println(date);
    }

/*    public void onTimeSet(TimePicker view, int hour, int minute){
        time = "jaahas " + hour + minute;
        testText.setText(time);
        System.out.println(time);
    }*/

    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {
       String firstChoice = String.valueOf(spinnerTheaters.getSelectedItem());


        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
          if (firstChoice.equals(String.valueOf(spinnerTheaters.getSelectedItem()))){
              movieList.setText("");

          } else {
                theaterName = parent.getItemAtPosition(pos).toString();
                Toast.makeText(parent.getContext(),
                        "You have selected : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
               // movieList.setText("Pirates of the caribean\nHölmöläiset\nBond");
              if (theaterName.equals("Strand")){
                  strand.getMovies(movieList);
              } else {
                  movieList.setText("");
              }

                System.out.println(firstChoice);
          }
        }
        @Override
        public void onNothingSelected(AdapterView<?> arg) {


        }

    }

    public void searchFunction (View v){
        System.out.println("Hello World!");
        startTime = startTimeField.getText().toString();
        endTime = endTimeField.getText().toString();
        testText.setText(movieName.getText() + " " + startTime + " " + endTime + " " + theaterName);

    }

    private void showDatePickerDialog(){
        DatePickerDialog datePicker = new DatePickerDialog(this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePicker.show();
    }

/*    private void showTimePickerDialog(TimePickerDialog timePicker){
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        timePicker = new TimePickerDialog(this,  this,
                minute,
                hour, true);
        timePicker.show();
    }*/
}





