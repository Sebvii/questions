package com.example.questions;

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
        setContentView(R.layout.activity_main);

        // Initialize Views
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        progressBar = findViewById(R.id.progressBar);
        ImageView arrowLeft = findViewById(R.id.arrowLeft);
        ImageView arrowRight = findViewById(R.id.arrowRight);

        // Set initial progress
        progressBar.setProgress(progress);

        // Set listener for Radio Buttons
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedOption = findViewById(checkedId);
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
            }
        });
    }
}
