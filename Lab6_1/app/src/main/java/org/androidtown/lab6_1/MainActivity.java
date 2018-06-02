package org.androidtown.lab6_1;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText txtdata;//위젯 객체 및 객체 생성 부분
    private Button btnWriteSDFile;
    private Button bttnRead;
    private Button btnClearScreen;
    private Button btnFinish;
    private String mySdPath;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySdPath = Environment.getExternalStorageDirectory().getAbsolutePath();//디렉토리 설정 절대경로
        final File directory = new File(mySdPath + "");//파일 확장자 생성
        directory.mkdirs();//폴더 생성
        txtdata = (EditText) findViewById(R.id.txtData);//텍스트 데이터 객체 생성
        txtdata.setHint("Enter some lines of data here...");//힌트메세지 출력
        btnWriteSDFile = (Button) findViewById(R.id.btnWriteSDFile);//버튼 생성
        btnWriteSDFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File myFile = new File(directory, "mysdfile.txt");//파일 생성
                    OutputStreamWriter myOutwriter = new OutputStreamWriter(
                            new FileOutputStream(myFile));//입출력 스트림에 파일 할당
                    myOutwriter.append(txtdata.getText());//라이터,및 리더 연결
                    myOutwriter.close();
                    Toast.makeText(getApplicationContext(),
                            "Done writing Sd 'mysdfile.txt'", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();//익셉션일 경우 메시지 출력
                }
            }
        });
        bttnRead = (Button) findViewById(R.id.btnReadSDFile);
        bttnRead.setOnClickListener(new View.OnClickListener() {//리드버튼 리스너 함수
            @Override
            public void onClick(View v) {//클릭할 경우
                try {
                    BufferedReader myReader = new BufferedReader(//버퍼리더 객체 생성,입력 스트림 연결
                            new InputStreamReader(
                                    new FileInputStream(new File(directory, "mysdfile.txt"))));
                    String ab="";
                    String aBuffer = "";
                    while ((ab = myReader.readLine()) != null) {//문자열을 모두 읽어와라
                        aBuffer += ab + "\n";//문자를 버퍼에 할당헤라
                    }
                    txtdata.setText(aBuffer);//버퍼 호출
                    myReader.close();
                    Toast.makeText(getApplicationContext(),
                            "Done reading SD 'mysdfile.txt'", Toast.LENGTH_SHORT).show();//토스트 메시지 출력
                } catch (Exception e) {//익셉션일 경우
                    Toast.makeText(getApplicationContext(), e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnClearScreen=(Button)findViewById(R.id.btnClearScreen);
        btnClearScreen.setOnClickListener(new View.OnClickListener(){//클리어 버튼 리스너 함수
            @Override
            public void onClick(View v){
                txtdata.setText("");//클릭할경우 글자들을 지워라
            }
        });
        btnFinish=(Button)findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener(){//앱을 종료시키는 함수
            @Override
            public void onClick(View v){
                finish();//앱을 종료 시킨다
            }
        });
    }
}
