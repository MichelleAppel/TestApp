package com.example.michelle.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckboxClicked(View view) {
        // Is checkbox checked
        boolean checked = ((CheckBox) view).isChecked();

        // The image that needs to be made (in)visible
        View image = null;
        // Check which checkbox was clicked
        if (view.getId() == R.id.checkBox_nose) {
            image = findViewById(R.id.nose);
        } else if (view.getId() == R.id.checkBox_eyes) {
            image = findViewById(R.id.eyes);
        } else if (view.getId() == R.id.checkBox_eyebrows) {
            image = findViewById(R.id.eyebrows);
        } else if (view.getId() == R.id.checkBox_mouth) {
            image = findViewById(R.id.mouth);
        } else if (view.getId() == R.id.checkBox_arms) {
            image = findViewById(R.id.arms);
        } else if (view.getId() == R.id.checkBox_ears) {
            image = findViewById(R.id.ears);
        } else if (view.getId() == R.id.checkBox_glasses) {
            image = findViewById(R.id.glasses);
        } else if (view.getId() == R.id.checkBox_hat) {
            image = findViewById(R.id.hat);
        } else if (view.getId() == R.id.checkBox_mustache) {
            image = findViewById(R.id.mustache);
        } else if (view.getId() == R.id.checkBox_shoes) {
            image = findViewById(R.id.shoes);
        }

        // Set visibility on or of
        if (image != null) {
            if (checked) {
                if (image.getVisibility() == View.INVISIBLE) {
                    image.setVisibility(View.VISIBLE);
                }
            } else {
                if (image.getVisibility() == View.VISIBLE) {
                    image.setVisibility(View.INVISIBLE);
                }
            }
        }
    }
}
