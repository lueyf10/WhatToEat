package my.edu.utar.ga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;




import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

//        TextInputEditText edtSignUpFullName = findViewById(R.id.edtSignUpFullName);
//        String input = edtSignUpFullName.getText().toString();

        mAuth = FirebaseAuth.getInstance();
//        FirebaseFirestore db = FirebaseFirestore.getInstance();




        Button btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize Firebase Authentication in your app's code
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                TextInputEditText edtSignUpEmail = findViewById(R.id.edtSignUpEmail);
                String email = edtSignUpEmail.getText().toString();

                TextInputEditText edtSignUpPassword = findViewById(R.id.edtSignUpPassword);
                String password = edtSignUpPassword.getText().toString();



                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NotNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // User is successfully registered
                                    // You can perform additional actions here, such as storing user data to a database
//                                    Log.d(TAG, "signInWithCustomToken:success");
//                                    Map<String,Object> Users = new HashMap<>();
////                                    Users.put("Username",username);
//                                    Users.put("Email",email);
//                                    db.collection("Users").add(Users)
//                                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                                @Override
//                                                public void onSuccess(DocumentReference documentReference) {
//                                                    Log.d(TAG, "Write:success");
//                                                    Toast.makeText(Register.this,"Register successful",Toast.LENGTH_LONG).show();
                                    Toast.makeText(Registration.this, "Register successful", Toast.LENGTH_SHORT).show();




                                } else {
                                    // Registration failed, handle the error
                                    Toast.makeText(Registration.this, "Register failed", Toast.LENGTH_SHORT).show();

                                    try {
                                        throw task.getException();
                                    } catch (FirebaseAuthWeakPasswordException e) {
                                        // Handle weak password error
                                        Toast.makeText(Registration.this, "Password must be more than 6 characters.", Toast.LENGTH_SHORT).show();
                                    } catch (FirebaseAuthInvalidCredentialsException e) {
                                        // Handle invalid email error
                                    } catch (FirebaseAuthUserCollisionException e) {
                                        // Handle email already exists error
                                    } catch (Exception e) {
                                        // Handle other errors
                                    }
                                }
                            }
                        });




            }
        });



    }
}