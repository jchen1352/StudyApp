package org.pltw.examples.studyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShowAssignmentsActivity extends AppCompatActivity {

    private ListView assignmentListView;
    private static final String TAG = ShowAssignmentsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_assignments);
        assignmentListView = (ListView) findViewById(R.id.assignment_list);
        //ArrayList<Assignment> assignments = readAssignments();
        MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());
        ArrayList<Assignment> assignments = db.getAllAssignments();
        ArrayAdapter<Assignment> adapter = new ArrayAdapter<Assignment>(
                this, android.R.layout.simple_list_item_1, assignments);
        assignmentListView.setAdapter(adapter);
    }
}
