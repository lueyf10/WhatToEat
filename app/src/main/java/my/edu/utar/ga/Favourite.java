package my.edu.utar.ga;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.os.Bundle;

public class Favourite extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> favoriteList;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        // Initialize views
        listView = findViewById(R.id.listView);
        favoriteList = new ArrayList<>();
        dbHelper = new DatabaseHelper(this);

        // Retrieve data from Favourite table
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + DatabaseHelper.COLUMN_NAME + ", " + DatabaseHelper.COLUMN_CATEGORY +
                " FROM " + DatabaseHelper.FAVORITE_TABLE_NAME, null);

        // Iterate through cursor and add data to favoriteList
        if (cursor.moveToFirst()) {
            do {
                int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME);
                int categoryIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_CATEGORY);

// ...

                String name = cursor.getString(nameIndex);
                String category = cursor.getString(categoryIndex);
                favoriteList.add("Name: " + name + "\nCategory: " + category);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        // Initialize and set adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, favoriteList);
        listView.setAdapter(adapter);
    }
}