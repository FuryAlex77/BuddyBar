package com.example.buddybar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class StoreSignUP extends AppCompatActivity {

    private EditText email, password;
    private Button signUpBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_sign_up);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        signUpBtn = findViewById(R.id.btn_register_store);

        signUpBtn.setOnClickListener(v -> {
            String emailText = email.getText().toString().trim();
            String passwordText = password.getText().toString().trim();

            if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)) {
                Toast.makeText(StoreSignUP.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.createUserWithEmailAndPassword(emailText, passwordText)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(StoreSignUP.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(StoreSignUP.this, StoreLogin.class));
                            finish();
                        } else {
                            Toast.makeText(StoreSignUP.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

    }
}