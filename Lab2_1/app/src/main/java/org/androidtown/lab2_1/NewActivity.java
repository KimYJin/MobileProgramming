package org.androidtown.lab2_1;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        closeButton = (Button)findViewById(R.id.closeButton);

        //Get Passed intent value.
        Intent passedIntent = getIntent();

        //If passedIntent have intent value, assign to string variables intent's string name value and string age value.
        if (passedIntent != null) {

            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge");

            //Show student info value in screen.
            Toast.makeText(getApplication(), "Student info : " + loginName + ", " + loginAge, Toast.LENGTH_LONG).show();
        }

        //If click close button, finish NewActivity.
        closeButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                finish();
            }

        });
    }
}
