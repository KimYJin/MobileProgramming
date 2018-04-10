package org.androidtown.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goButton;
    Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        // Create variable  TextView textview ,Button goButton, and Button backButton
        textView = (TextView)findViewById(R.id.textView);
        goButton=(Button)findViewById(R.id.goButton);
        backButton = (Button)findViewById(R.id.backButton);

        //Get Passed intent value
        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("url");
        textView.setText(passedUrl);

        //When you click ‘GO button, show webpage
        //If there are no text on TextView, then float Toast message
        goButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(!passedUrl.equals(""))
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"주소를 다시입력해주세요.",Toast.LENGTH_LONG).show();
                }
            }
        });

        //When you click ‘BACK’ button, return to 1st screen and float Toast message
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
                Toast.makeText(getApplicationContext(),"뒤로가기버튼을 눌렀습니다.",Toast.LENGTH_LONG).show();
            }
        });


    }
}
