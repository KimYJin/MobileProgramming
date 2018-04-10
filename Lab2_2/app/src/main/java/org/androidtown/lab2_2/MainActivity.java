package org.androidtown.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Create variable Edit Text Url and Button nextButton
    EditText Url;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃에 정의된 이미지 뷰 객체들을 참조한다.
        //make reference to View Objects which is defined in Layout through id
        Url = (EditText)findViewById(R.id.editText);
        nextButton=(Button)findViewById(R.id.nextButton);

        //if push the next button, then open new Activity
        nextButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                String myUrl = Url.getText().toString();

                Intent intent = new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("url",myUrl);

                startActivity(intent);
            }

        });
    }
}
