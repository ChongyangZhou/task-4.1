package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddEditTaskActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextDescription, editTextDueDate;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextDueDate = findViewById(R.id.editTextDueDate);
        buttonSave = findViewById(R.id.buttonSave);

        // Check if we're in edit mode if an extra was passed
        if (getIntent().hasExtra("taskId")) {

            editTextTitle.setText("Task 1");
            editTextDescription.setText("Description of Task 1");

            editTextDueDate.setText("2024-05-01");
        }

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTask();
            }
        });
    }

    private void saveTask() {
        // Collect the data from the fields and save it to  database
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();

        String dueDate = editTextDueDate.getText().toString().trim();

        if (title.isEmpty() || description.isEmpty() || dueDate.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Code to save the task to the database...

        // After saving, you would likely want to return to MainActivity
        finish();
    }
}


