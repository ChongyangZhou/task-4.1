package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    private TextView textViewTitle, textViewDescription, textViewDueDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewDueDate = findViewById(R.id.textViewDueDate);

        // Assume that a task ID is passed as an extra in the intent
        int taskId = getIntent().getIntExtra("taskId", -1);
        if (taskId != -1) {
            // Query the database for the task details using the task ID
            // For now, we'll use dummy data
            textViewTitle.setText("Task Title");
            textViewDescription.setText("Task Description");
            textViewDueDate.setText("Due Date");
        } else {
            // No task ID, handle this situation, perhaps by closing the activity
            finish();
        }
    }
}
