package org.androidtown.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    Intent intent2;
    Intent myIntent;
    String name2="",sex2="",receive2="";
    TextView textName,textSex,textRecieve;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textName=findViewById(R.id.textName);
        textSex=findViewById(R.id.textSex);
        textRecieve=findViewById(R.id.textRecieve);
        backBtn = findViewById(R.id.backBtn);

        //get data of name,sex,and receive-type from  Main Activity.
        myIntent = getIntent();
        intent2 = new Intent(getApplicationContext(),MainActivity.class);
        name2=myIntent.getStringExtra("name");
        sex2=myIntent.getStringExtra("sex");
        receive2=myIntent.getStringExtra("receiveType");

        // show data of name,sex,and receive-type
        textName.setText(name2);
        textSex.setText(sex2);
        textRecieve.setText(receive2);

        ////when the backButton(이전) is clicked, go back to Main Activity.
        backBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(intent2);
                finish();
            }
        });
    }

}
