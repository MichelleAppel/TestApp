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

       //bodyCheckBox.isChecked();
        //itemClicked(bodyCheckBox, body);

    }

    public void onCheckboxClicked(View view) {
        // Is checkbox checked
        boolean checked = ((CheckBox) view).isChecked();

        // The image that needs to be made (in)visible
        View image;
        // Check which checkbox was clicked
        if (((CheckBox) view).getId() == R.id.checkBox_body) {
            image = findViewById(R.id.body);
        }// else if (((CheckBox) view).getId() == R.id.checkBox_body) {
        //    image = findViewById(R.id.body);
        //}

        // Set visibility on or of
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
