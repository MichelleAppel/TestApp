package com.example.michelle.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final String CHECKBOX_NOSE = "checkBox_nose_state";
    static final String CHECKBOX_EYES = "checkBox_eyes_state";
    static final String CHECKBOX_EYEBROWS = "checkBox_eyebrows_state";
    static final String CHECKBOX_MOUTH = "checkBox_mouth_state";
    static final String CHECKBOX_ARMS = "checkBox_arms_state";
    static final String CHECKBOX_EARS = "checkBox_ears_state";
    static final String CHECKBOX_GLASSES = "checkBox_glasses_state";
    static final String CHECKBOX_HAT = "checkBox_hat_state";
    static final String CHECKBOX_MUSTACHE = "checkBox_mustache_state";
    static final String CHECKBOX_SHOES = "checkBox_shoes_state";

    public View[] imageList;
    public View[] checkBoxList;
    public String[] checkBoxName = new String[]{CHECKBOX_NOSE, CHECKBOX_EYES, CHECKBOX_EYEBROWS, CHECKBOX_MOUTH,
            CHECKBOX_ARMS, CHECKBOX_EARS, CHECKBOX_GLASSES, CHECKBOX_HAT, CHECKBOX_MUSTACHE,
            CHECKBOX_SHOES};

    //onSaveInstanceState
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageList = new View[]{findViewById(R.id.nose), findViewById(R.id.eyes),
                findViewById(R.id.eyebrows), findViewById(R.id.mouth),
                findViewById(R.id.arms), findViewById(R.id.ears),
                findViewById(R.id.glasses), findViewById(R.id.hat),
                findViewById(R.id.mustache), findViewById(R.id.shoes)};

        checkBoxList = new View[]{findViewById(R.id.checkBox_nose), findViewById(R.id.checkBox_eyes),
                findViewById(R.id.checkBox_eyebrows), findViewById(R.id.checkBox_mouth),
                findViewById(R.id.checkBox_arms), findViewById(R.id.checkBox_ears),
                findViewById(R.id.checkBox_glasses), findViewById(R.id.checkBox_hat),
                findViewById(R.id.checkBox_mustache), findViewById(R.id.checkBox_shoes)};


        if (savedInstanceState != null) {
            // Loop trough all images to check if boxes are checked
            for (int i = 0; i < checkBoxName.length; i++) {
                if (savedInstanceState.getBoolean(checkBoxName[i]) && !((CheckBox) checkBoxList[i]).isChecked()) {
                    checkBoxList[0].performClick();
                } else if (!savedInstanceState.getBoolean(checkBoxName[i]) && ((CheckBox) checkBoxList[i]).isChecked()) {
                    checkBoxList[0].performClick();
                }
            }

            // Loop trough all checkboxes to see if checked and adapt image to it
            for (int i = 0; i < checkBoxName.length; i++) {
                if (savedInstanceState.getBoolean(checkBoxName[i]) && imageList[i].getVisibility() == View.INVISIBLE) {
                    imageList[i].setVisibility(View.VISIBLE);
                } else if (!savedInstanceState.getBoolean(checkBoxName[i]) && imageList[i].getVisibility() == View.VISIBLE) {
                    imageList[i].setVisibility(View.INVISIBLE);
                }
            }

        } else {
            // Random configuration at the start
            Random rand = new Random();
            for (int i = 0; i < rand.nextInt(checkBoxList.length); i++) {
                checkBoxList[rand.nextInt(checkBoxList.length)].performClick();
            }

            // Loop trough all checkboxes to see if checked and adapt image to it
            for (int i = 0; i < checkBoxName.length; i++) {
                if (((CheckBox) checkBoxList[i]).isChecked() && imageList[i].getVisibility() == View.INVISIBLE) {
                    imageList[i].setVisibility(View.VISIBLE);
                } else if (!((CheckBox) checkBoxList[i]).isChecked() && imageList[i].getVisibility() == View.VISIBLE) {
                    imageList[i].setVisibility(View.INVISIBLE);
                }
            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        for (int i = 0; i < checkBoxName.length; i++) {
            savedInstanceState.putBoolean(checkBoxName[i], ((CheckBox) checkBoxList[i]).isChecked());
        }
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
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
