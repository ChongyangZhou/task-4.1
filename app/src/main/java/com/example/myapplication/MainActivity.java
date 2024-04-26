package com.example.myapplication; ; // Change to your actual package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView tasksListView;
    private ArrayAdapter<String> tasksAdapter;


    private ArrayList<String> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksListView = findViewById(R.id.tasksListView);
        tasksList = new ArrayList<>();
        // Initialize with some dummy data
        tasksList.add("Task 1");
        tasksList.add("Task 2");

        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasksList);
        tasksListView.setAdapter(tasksAdapter);

        tasksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the click event
                // For now, let's say we want to edit the task
                Intent intent = new Intent(MainActivity.this, AddEditTaskActivity.class);
                intent.putExtra("taskId", position); // pass the task ID or position to the AddEditTaskActivity
                startActivity(intent);
            }
        });
    }

    // You may want to override onResume to refresh the list if the tasks have been modified
    @Override
    protected void onResume() {

        super.onResume();
        // Refresh the tasks list
    }

    // Code to navigate to AddEditTaskActivity to add a new task
    public void addNewTask(View view) {
        Intent intent = new Intent(this, AddEditTaskActivity.class);
        startActivity(intent);
    }
}
