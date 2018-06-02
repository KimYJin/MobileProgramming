package org.androidtown.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    Button store, call, initialization;
    String username, password;
    EditText userID, userPassword;
    SharedPreferences pref1;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        store = findViewById(R.id.button2);//초기화를 시킨다 (xml)
        call = findViewById(R.id.button1);
        initialization = findViewById(R.id.button3);
        userID = findViewById(R.id.edit2);
        userPassword = findViewById(R.id.edit1);
        store.setOnClickListener(new Button.OnClickListener() {//저장하는 함수 선언
            @Override
            public void onClick(View view) {
                username = userID.getText().toString();//유저 이름 받고
                password = userPassword.getText().toString();//학번 받고
                sharedPreferences();
                Toast.makeText(getApplicationContext(), "Data is saved", Toast.LENGTH_SHORT).show();
            }//토스트 메시지 출력
        });
        initialization.setOnClickListener(new Button.OnClickListener() {//화면 초기화 함수
            @Override
            public void onClick(View view) {//클릭했을때
                userID.setText(""); //초기화
                userPassword.setText("");
            }
        });
        call.setOnClickListener(new Button.OnClickListener() {//불러오는 함수
            @Override
            public void onClick(View view) {
                applySharedPreference();//applysharedpeference호출

            }
        });

    }

    public void sharedPreferences() {
        pref1 = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = pref1.edit();
        toEdit.putString("Username", username);//username에 이름을 넣어준다
        toEdit.putString("Password", password);//number에 학번을 넣어준다
        toEdit.commit();//저장
    }

    public void applySharedPreference() {
        pref1 = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if (pref1 != null && pref1.contains("Username")) {
            String name = pref1.getString("Username", "noname");//유저이름을 가져온다
            String pw = pref1.getString("Password", "nopassword");//학번을 가져온다
            userID.setText(name);//userId에 보여준다
            userPassword.setText(pw);//userPassword에 보여준다
        }
    }
}
