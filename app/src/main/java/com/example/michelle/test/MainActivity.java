package com.example.michelle.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    View[] checkBoxList;

    View[] imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxList = new View[]{findViewById(R.id.checkBox_nose), findViewById(R.id.checkBox_eyes),
                findViewById(R.id.checkBox_eyebrows), findViewById(R.id.checkBox_mouth),
                findViewById(R.id.checkBox_arms), findViewById(R.id.checkBox_ears),
                findViewById(R.id.checkBox_glasses), findViewById(R.id.checkBox_hat),
                findViewById(R.id.checkBox_mustache), findViewById(R.id.checkBox_shoes)};

        imageList = new View[]{findViewById(R.id.nose), findViewById(R.id.eyes),
                findViewById(R.id.eyebrows), findViewById(R.id.mouth),
                findViewById(R.id.arms), findViewById(R.id.ears),
                findViewById(R.id.glasses), findViewById(R.id.hat),
                findViewById(R.id.mustache), findViewById(R.id.shoes)};

        // Loop trough all checkboxes to see if checked and adapt image to it
        for (int i = 0; i < checkBoxList.length; i++) {
            onCheckboxClicked(checkBoxList[i]);
        }

    }

    public void screenOrientation() {
        for (int i = 0; i < checkBoxList.length; i++) {
            onCheckboxClicked(checkBoxList[i]);
        }
    }

    public void onCheckboxClicked(View view) {
        // Is checkbox checked
        boolean checked = ((CheckBox)view).isChecked();

        // The image that needs to be made (in)visible
        View image = null;
        // Check which checkbox was clicked
        for (int i = 0; i < checkBoxList.length; i++) {
            if (checkBoxList[i].getId() == view.getId()) {
                image = imageList[i];
            }
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
