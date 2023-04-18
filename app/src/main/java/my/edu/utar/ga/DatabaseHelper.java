package my.edu.utar.ga;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "restaurant.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "restaurants";
    public static final String FAVORITE_TABLE_NAME = "favorites"; // New table for favorites
    private static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_FAVORITE = "favorite"; // New column for favorite status

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create restaurants table
        String createRestaurantsTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CATEGORY + " TEXT);";
        db.execSQL(createRestaurantsTableQuery);

        // Create favorites table
        String createFavoritesTableQuery = "CREATE TABLE IF NOT EXISTS " + FAVORITE_TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_FAVORITE + " INTEGER);"; // Column to store favorite status
        db.execSQL(createFavoritesTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop and recreate restaurants table
        String dropRestaurantsTableQuery = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(dropRestaurantsTableQuery);
        onCreate(db);

        // Drop and recreate favorites table
        String dropFavoritesTableQuery = "DROP TABLE IF EXISTS " + FAVORITE_TABLE_NAME + ";";
        db.execSQL(dropFavoritesTableQuery);
        onCreate(db);
    }

    public void insertRestaurant(String name, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_CATEGORY, category);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public void insertFavorite(String name, String category) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_CATEGORY, category);
        values.put(COLUMN_FAVORITE, 1); // Set favorite status to 1 (true)

        // Insert the values into the favorites table
        db.insert(FAVORITE_TABLE_NAME, null, values);

        // Close the database
        db.close();
    }
}
