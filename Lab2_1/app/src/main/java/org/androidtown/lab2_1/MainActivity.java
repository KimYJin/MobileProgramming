package org.androidtown.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create variable Edit Text Name, Edit Text NameAge, and Button addButton
        Name = (EditText)findViewById(R.id.editText1);
        Age=(EditText)findViewById(R.id.editText2);
        addButton = (Button)findViewById(R.id.addButton);


        //If you click add button,then it happen the event.
        addButton .setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){

                //Assign value that input string in name and age.
                String name = Name.getText().toString();
                String age = Age.getText().toString();

                // Change Main Activity into NewActivity in screen through intent.
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);

                // Send data values that name and age .
                intent.putExtra("loginName", name);
                intent.putExtra("loginAge", age);

                startActivity(intent);
            }

        });
    }
}
