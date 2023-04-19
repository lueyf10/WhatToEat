package my.edu.utar.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MochiyukiOrigami extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mochiyuk_origami);

        dbHelper = new DatabaseHelper(this);

        // ... your existing code ...

        // Insert name and category into the database
        String name = "Mochiyuki Origami Kampar";
        String category = "Japanese restaurant ";
        double rating = 3.6;
        String mondayHours = "10:30am–9:30pm";
        String tuesdayHours = "10:30am–9:30pm";
        String wednesdayHours = "10:30am–9:30pm";
        String thursdayHours = "10:30am–9:30pm";
        String fridayHours = "10:30am–9:30pm";
        String saturdayHours = "10:30am–9:30pm";
        String sundayHours = "10:30am–9:30pm";
        String budget = "$$$";
        String description = "japanese restaurant that famous in onigiri and ramen.";
        dbHelper.insertRestaurant(name, category);

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView categoryTextView = findViewById(R.id.categoryTextView);
        TextView ratingTextView = findViewById(R.id.ratingTextView);
        TextView mondayHoursTextView = findViewById(R.id.mondayHoursTextView);
        TextView tuesdayHoursTextView = findViewById(R.id.tuesdayHoursTextView);
        TextView wednesdayHoursTextView = findViewById(R.id.wednesdayHoursTextView);
        TextView thursdayHoursTextView = findViewById(R.id.thursdayHoursTextView);
        TextView fridayHoursTextView = findViewById(R.id.fridayHoursTextView);
        TextView saturdayHoursTextView = findViewById(R.id.saturdayHoursTextView);
        TextView sundayHoursTextView = findViewById(R.id.sundayHoursTextView);
        TextView budgetTextView = findViewById(R.id.budgetTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        Button submitButton = findViewById(R.id.submitButton);


        nameTextView.setText("Name: " + name);
        categoryTextView.setText("Category: " + category);
        ratingTextView.setText("Rating: " + String.valueOf(rating));
        mondayHoursTextView.setText("Monday Hours: " + mondayHours);
        tuesdayHoursTextView.setText("Tuesday Hours: " + tuesdayHours);
        wednesdayHoursTextView.setText("Wednesday Hours: " + wednesdayHours);
        thursdayHoursTextView.setText("Thursday Hours: " + thursdayHours);
        fridayHoursTextView.setText("Friday Hours: " + fridayHours);
        saturdayHoursTextView.setText("Saturday Hours: " + saturdayHours);
        sundayHoursTextView.setText("Sunday Hours: " + sundayHours);
        budgetTextView.setText("Budget: " + budget);
        descriptionTextView.setText("Description: " + description);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to add the restaurant to the favorites
                addToFavorites();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }
    private void addToFavorites() {
        // Get the restaurant details
        String name = "Mochiyuki Origami Kampar";
        String category = " Japanese restaurant ";
        double rating = 3.6;
        String mondayHours = "10:30am–9:30pm";
        String tuesdayHours = "10:30am–9:30pm";
        String wednesdayHours = "10:30am–9:30pm";
        String thursdayHours = "10:30am–9:30pm";
        String fridayHours = "10:30am–9:30pm";
        String saturdayHours = "10:30am–9:30pm";
        String sundayHours = "10:30am–9:30pm";
        String budget = "$$$";
        String description = "japanese restaurant that famous in onigiri and ramen.";

        // Insert the restaurant into the favorites table
        DatabaseHelper dbHelper = new DatabaseHelper(this); // Instantiate DatabaseHelper
        dbHelper.insertFavorite(name, category);

        // Show a toast or a dialog indicating that the restaurant has been added to favorites
        Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show();
    }
}
