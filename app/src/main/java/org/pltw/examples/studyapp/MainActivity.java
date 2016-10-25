package org.pltw.examples.studyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String FILENAME = "assignments_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.due:
                Toast toastDue = Toast.makeText(this, "Show what's due", Toast.LENGTH_SHORT);
                toastDue.show();
                showAssignments();
                return true;
            case R.id.new_assignment:
                Toast toastAddNew = Toast.makeText(this, "Add new assignment", Toast.LENGTH_SHORT);
                toastAddNew.show();
                addNewAssignment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addNewAssignment() {
        Intent newAssignmentIntent = new Intent(this, AddAssignmentActivity.class);
        startActivity(newAssignmentIntent);
    }

    public void showAssignments() {
        Intent showAssignmentsIntent = new Intent(this, ShowAssignmentsActivity.class);
        startActivity(showAssignmentsIntent);
    }
}
