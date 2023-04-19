package my.edu.utar.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.annotations.NotNull;

public class ProfileActivity extends AppCompatActivity {

    private static final int MODIFY_PROFILE_REQUEST = 1;
    private TextInputEditText profileAgeEditText, profileFavoriteEditText, profileAddressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        profileAgeEditText = findViewById(R.id.profile_age_edittext);
        profileFavoriteEditText = findViewById(R.id.profile_favorite_edittext);
        profileAddressEditText = findViewById(R.id.profile_address_edittext);
        MaterialButton btnModify = findViewById(R.id.btnModify);

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modifyIntent = new Intent(ProfileActivity.this, ModifyActivity.class);
                modifyIntent.putExtra("age", profileAgeEditText.getText().toString());
                modifyIntent.putExtra("favorite", profileFavoriteEditText.getText().toString());
                modifyIntent.putExtra("address", profileAddressEditText.getText().toString());
                startActivityForResult(modifyIntent, MODIFY_PROFILE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NotNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MODIFY_PROFILE_REQUEST && resultCode == RESULT_OK && data != null) {
            profileAgeEditText.setText(data.getStringExtra("age"));
            profileFavoriteEditText.setText(data.getStringExtra("favorite"));
            profileAddressEditText.setText(data.getStringExtra("address"));
        }
    }
}