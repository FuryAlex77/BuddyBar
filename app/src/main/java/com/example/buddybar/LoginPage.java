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

public class LoginPage extends AppCompatActivity {

    private EditText email, password;
    private Button loginBtn, goToSignupBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login_btn);
        goToSignupBtn = findViewById(R.id.go_to_signup_btn);

        loginBtn.setOnClickListener(v -> {
            String emailText = email.getText().toString().trim();
            String passwordText = password.getText().toString().trim();

            if (TextUtils.isEmpty(emailText) || TextUtils.isEmpty(passwordText)) {
                Toast.makeText(LoginPage.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(emailText, passwordText)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            // Navigate to next screen
                            startActivity(new Intent(LoginPage.this, HomePage.class));
                            finish();

                        } else {
                            Toast.makeText(LoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        goToSignupBtn.setOnClickListener(v -> {
            startActivity(new Intent(LoginPage.this, SignupPage.class));
        });

    }
}