package com.example.myapplication;
import java.io.Serializable;
public class Task implements Serializable {
    private int id;
    private String title;
    private String description;
    private String dueDate;

    // Constructor for creating a new task
    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    // Constructor including id for tasks retrieved from the database
    public Task(int id, String title, String description, String dueDate) {
        this.id = id;
        this.title = title;

         this.description = description;
        this.dueDate = dueDate;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
