package com.example.lab3_ilhammmm339;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    // UI elements for displaying information
    private TextView summaryDisplay;
    private Button navigateBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // Initialize views from the layout
        summaryDisplay = findViewById(R.id.summaryDetailsTextView);
        navigateBackButton = findViewById(R.id.goBackButton);

        // Get the intent that started this activity
        Intent intent = getIntent();
        String receivedFullName = intent.getStringExtra("userFullName");
        String receivedEmail = intent.getStringExtra("userEmail");
        String receivedPhone = intent.getStringExtra("userPhone");
        String receivedAddress = intent.getStringExtra("userAddress");
        String receivedCity = intent.getStringExtra("userCity");

        // Format the received data into a display string
        String summaryText = "Nom complet: " + formatData(receivedFullName) + "\n" +
                "Email: " + formatData(receivedEmail) + "\n" +
                "Téléphone: " + formatData(receivedPhone) + "\n" +
                "Adresse: " + formatData(receivedAddress) + "\n" +
                "Ville: " + formatData(receivedCity);

        // Set the summary text to the TextView
        summaryDisplay.setText(summaryText);

        // Set a click listener for the back button to close the activity
        navigateBackButton.setOnClickListener(v -> finish());
    }

    // Helper function to handle null or empty strings
    private String formatData(String data) {
        return (data == null || data.trim().isEmpty()) ? "N/A" : data.trim();
    }
}