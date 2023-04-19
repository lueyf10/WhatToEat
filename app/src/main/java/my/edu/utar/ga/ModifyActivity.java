package my.edu.utar.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ModifyActivity extends AppCompatActivity {

    private TextInputEditText modifyAgeEditText, modifyFavoriteEditText, modifyAddressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        modifyAgeEditText = findViewById(R.id.modify_age_edittext);
        modifyFavoriteEditText = findViewById(R.id.modify_favorite_edittext);
        modifyAddressEditText = findViewById(R.id.modify_address_edittext);
        Button btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        modifyAgeEditText.setText(intent.getStringExtra("age"));
        modifyFavoriteEditText.setText(intent.getStringExtra("favorite"));
        modifyAddressEditText.setText(intent.getStringExtra("address"));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("age", modifyAgeEditText.getText().toString());
                resultIntent.putExtra("favorite", modifyFavoriteEditText.getText().toString());
                resultIntent.putExtra("address", modifyAddressEditText.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}