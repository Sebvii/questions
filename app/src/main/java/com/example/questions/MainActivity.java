package com.example.questions;

import android.content.Intent; // Import this
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress = 50; // Initial progress value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_question2);

        // Initialize Views
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        progressBar = findViewById(R.id.progressBar);
        ImageView arrowLeft = findViewById(R.id.arrowLeft);
        ImageView arrowRight = findViewById(R.id.arrowRight);

        // Set initial progress
        progressBar.setProgress(progress);

        // Set listener for Radio Buttons and change color on selection
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            // Reset all radio buttons to their default text color
            for (int i = 0; i < group.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) group.getChildAt(i);
                radioButton.setTextColor(Color.BLACK); // Default color for all buttons
            }

            // Change the color of the selected radio button to black
            RadioButton selectedOption = findViewById(checkedId);
            selectedOption.setTextColor(Color.BLACK);

            // Display a toast message for the selected option
            String message = "Selected: " + selectedOption.getText();
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });

        // Navigation Arrows functionality
        arrowLeft.setOnClickListener(v -> {
            if (progress > 0) {
                progress -= 10;
                progressBar.setProgress(progress);
            }
        });

        arrowRight.setOnClickListener(v -> {
            if (progress < 100) {
                progress += 10;
                progressBar.setProgress(progress);
            } else {
                // Navigate to the SecondActivity when the progress reaches 100
                Intent intent = new Intent(MainActivity.this, FoodQuestion2.class);
                startActivity(intent);
            }
        });
    }
}
