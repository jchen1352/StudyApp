package org.pltw.examples.studyapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddAssignmentActivity extends AppCompatActivity {

    EditText assignmentNameET;
    DatePicker dueDateDP;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        assignmentNameET = (EditText) findViewById(R.id.new_assignment_name);
        dueDateDP = (DatePicker) findViewById(R.id.date_picker);
        button = (Button) findViewById(R.id.new_assignment_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String assignmentName = assignmentNameET.getText().toString().trim();
                int month = dueDateDP.getMonth();
                int day = dueDateDP.getDayOfMonth();
                int year = dueDateDP.getYear();
                Assignment assignment = new Assignment(assignmentName, month, day, year);

                MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());
                db.addAssignment(assignment);
                //saveAssignment(assignment);

                Toast toast = Toast.makeText(getApplicationContext(),
                        assignment.toString(), Toast.LENGTH_SHORT);
                toast.show();

                finish();
            }
        });
    }
}
