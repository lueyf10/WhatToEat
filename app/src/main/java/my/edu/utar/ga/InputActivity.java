package my.edu.utar.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);


        Button nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText option1 = findViewById(R.id.option1);
                EditText option2 = findViewById(R.id.option2);
                EditText option3 = findViewById(R.id.option3);

                Intent intent = new Intent(InputActivity.this, SpinActivity.class);
                intent.putExtra("option1", option1.getText().toString());
                intent.putExtra("option2", option2.getText().toString());
                intent.putExtra("option3", option3.getText().toString());
                startActivity(intent);
            }
        });
    }
}
