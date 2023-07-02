package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameText, heightText,weightText,ageText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        heightText = findViewById(R.id.HeightText);
        weightText = findViewById(R.id.Weight);
        ageText = findViewById(R.id.Age);

        Button calculate = findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                int height = Integer.parseInt(heightText.getText().toString());
                double weight = Double.parseDouble(weightText.getText().toString());
                int age = Integer.parseInt(ageText.getText().toString());

                if (name.isEmpty() || name.length() > 50) {
                    nameText.setError("Name can't be empty or with length greater than 50");
                    return;
                }

                if (height <= 0 || height >= 250) {
                    heightText.setError("Height is invalid");
                    return;
                }
                if (weight <= 0 || weight >= 250) {
                    weightText.setError("Weight is invalid");
                    return;
                }
                if (age <= 0 || age >= 150) {
                    ageText.setError("Age must be greater than 0 and less than 150");
                }

                double calories = calculateCalories(weight,height,age);

                TextView resultText = findViewById(R.id.Result);
                resultText.setText("Your Calories are: " + String.valueOf(calories));
            }

            private double calculateCalories (double weight, int height, int age) {
                double calories = weight * height * age;
                return calories;
            }
        });
    }
}