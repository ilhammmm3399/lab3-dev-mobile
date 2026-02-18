package com.example.lab3_ilhammmm339;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // User input fields
    private EditText fullNameInput, emailInput, phoneInput, addressInput, cityInput;

    // Action button
    private Button submitFormButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Called when the activity is first created.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Links the UI to this activity

        // Get references to the views from the layout
        fullNameInput = findViewById(R.id.fullNameEditText);
        emailInput   = findViewById(R.id.emailEditText);
        phoneInput   = findViewById(R.id.phoneEditText);
        addressInput = findViewById(R.id.addressEditText);
        cityInput   = findViewById(R.id.cityEditText);
        submitFormButton = findViewById(R.id.submitFormButton);

        // Set a click listener on the submit button
        submitFormButton.setOnClickListener(v -> {
            // Read the text from the input fields
            String fullNameStr = fullNameInput.getText().toString().trim();
            String emailStr   = emailInput.getText().toString().trim();
            String phoneStr   = phoneInput.getText().toString().trim();
            String addressStr = addressInput.getText().toString().trim();
            String cityStr   = cityInput.getText().toString().trim();

            // Simple validation: check if required fields are empty
            if (fullNameStr.isEmpty() || emailStr.isEmpty()) {
                Toast.makeText(this, "Le nom et l'e-mail sont requis.", Toast.LENGTH_SHORT).show();
                return; // Stop the process
            }

            // Create an explicit intent to navigate to the second screen
            Intent intent = new Intent(MainActivity.this, Screen2Activity.class);

            // Pass data to the next activity using extras
            intent.putExtra("userFullName", fullNameStr);
            intent.putExtra("userEmail", emailStr);
            intent.putExtra("userPhone", phoneStr);
            intent.putExtra("userAddress", addressStr);
            intent.putExtra("userCity", cityStr);

            // Start the summary activity
            startActivity(intent);
        });
    }
}