package my.edu.utar.ga;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SpinActivity extends AppCompatActivity {

    private ArrayList<String> inputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin2);

        ImageView spinWheel = findViewById(R.id.spin_wheel);

        Bundle extras = getIntent().getExtras();
        inputs = new ArrayList<>();
        if (extras != null) {
            inputs.add(extras.getString("option1"));
            inputs.add(extras.getString("option2"));
            inputs.add(extras.getString("option3"));
        }

        startSpinning(spinWheel);
    }

    private void startSpinning(ImageView spinWheel) {
        // Start the spinning animation
        RotateAnimation rotate = new RotateAnimation(0, 360 * 5, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setFillAfter(true);
        spinWheel.startAnimation(rotate);

        // Show the result after 5 seconds
        new Handler().postDelayed(() -> {
            Random random = new Random();
            String randomOption = inputs.get(random.nextInt(inputs.size()));

            showResultDialog(randomOption);
        }, 5000);
    }

    private void showResultDialog(String randomOption) {
        new AlertDialog.Builder(SpinActivity.this)
                .setTitle("Result")
                .setMessage("The random restaurant is " + randomOption)
                .setPositiveButton("OK", (dialog, which) -> {
                    // Navigate to home page
                    Intent intent = new Intent(SpinActivity.this, InputActivity.class);
                    startActivity(intent);
                    finish();
                })
                .setNegativeButton("RESPIN", (dialog, which) -> {
                    // Restart the SpinActivity
                    recreate();
                })
                .show();
    }
}
