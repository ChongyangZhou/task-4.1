package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Info
    private static final String DATABASE_NAME = "taskManager";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_TASKS = "tasks";

    // Task Table Columns
    private static final String KEY_TASK_ID = "id";
    private static final String KEY_TASK_TITLE = "title";
    private static final String KEY_TASK_DESCRIPTION = "description";
    private static final String KEY_TASK_DUE_DATE = "dueDate";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TASKS_TABLE = "CREATE TABLE " + TABLE_TASKS +
                "(" +
                KEY_TASK_ID + " INTEGER PRIMARY KEY," + // Define a primary key
                KEY_TASK_TITLE + " TEXT," +
                KEY_TASK_DESCRIPTION + " TEXT," +
                KEY_TASK_DUE_DATE + " TEXT" +
                ")";

        db.execSQL(CREATE_TASKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // For simplicity, just drop the old table and create a new one.
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);
            onCreate(db);
        }
    }

    // Insert a task into the database
    public void addTask(Task task) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_TASK_TITLE, task.getTitle());
            values.put(KEY_TASK_DESCRIPTION, task.getDescription());
            values.put(KEY_TASK_DUE_DATE, task.getDueDate());

            db.insertOrThrow(TABLE_TASKS, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            // Error in inserting row
        } finally {
            db.endTransaction();
        }
    }

    // Update a task in the database
    public int updateTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TASK_TITLE, task.getTitle());
        values.put(KEY_TASK_DESCRIPTION, task.getDescription());
        values.put(KEY_TASK_DUE_DATE, task.getDueDate());

        // Updating row
        return db.update(TABLE_TASKS, values, KEY_TASK_ID + " = ?",
                new String[]{String.valueOf(task.getId())});
    }

    // Delete a task in the database
    public void deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASKS, KEY_TASK_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Fetch a task from the database (you'll need to implement this)
    // public Task getTask(int id) { ... }

    // Fetch all tasks from the database (you'll need to implement this)
    // public List<Task> getAllTasks() { ... }
}

