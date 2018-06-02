package org.androidtown.lab6_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;//리스트 생성
    Button add, delete;//버튼,에디터,SQLITEDB,helper등등 생성
    EditText name, sn;
    SQLiteDatabase db;
    MyDBHelper helper;
    String[] str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);//초기화
        sn = findViewById(R.id.sn);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        listView = findViewById(R.id.list);
        helper = new MyDBHelper(this, "stdt.db", null, 1);


        add.setOnClickListener(new View.OnClickListener() {//데이터를 넣는함수
            @Override
            public void onClick(View v) {//클릭했을경우
                String str1, str2;
                str1 = name.getText().toString();
                str2 = sn.getText().toString();
                if (TextUtils.isEmpty(str1) && TextUtils.isEmpty(str2)) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();//토스트 메시지 출력
                    return;
                }
                if (TextUtils.isEmpty(str2)) {//항목이 없을 경우
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();//토스트메세지 출력
                    return;
                }
                insert(str1, str2);//인서트함수 호출
                invalidate();//최신화 시키는 함수
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {//데이터를 삭제하는 함수
            @Override
            public void onClick(View v) {//클릭했을경우
                String str1 = name.getText().toString();
                if (TextUtils.isEmpty(str1)) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();//토스트 메시지 출력
                    return;
                }
                delete(str1);//딜리트 함수 호출
                invalidate();//최신화시키는 함수 호출
            }
        });
    }


    public void insert(String name, String sn) {//데이터를 넣음
        db = helper.getWritableDatabase();//디비 접근 권한 부여
        ContentValues values = new ContentValues();//contentvalues 객체 생성
        values.put("name", name);//이름학번을 입력
        values.put("sn", sn);
        db.insert("student", null, values);//디비를 업데이트 시킴
    }


    public void delete(String name) {//데이터 삭제 함수
        db = helper.getWritableDatabase();//디비 접근 권한 부여
        db.delete("student", "name=?", new String[]{name});//각각 키를 사용해 삭제
    }


    public class MyDBHelper extends SQLiteOpenHelper { //SQLiteOpenHelper를 상속받아서 클래스를 작은 DB 공간으로 사용
        public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int v) { //생성자 초기화 , 컨텍스트와 이름,권한 등을 부모 클래스에게 넘겨줌
            super(context, name, factory, v);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {//디비가 만들어졌을 경우
            String sql = "create table student (" +//테이블구성 및 이름 학번을 구성 시킨다
                    "name text," +
                    "sn text);";
            db.execSQL(sql);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//업데이트 시키는함수
            String sql = "drop table if exists student";//테이블의 내용이 삭제되면 자동으로 업데이트를 한다
            db.execSQL(sql);
            onCreate(db);
        }
    }


    public void select() {//샐렉트 함수
        db = helper.getReadableDatabase();//데이터 베이스 객체에 읽기 권한을 부여한다.
        Cursor c = db.query("student", null, null, null, null, null, null);//학생 테이블의 커서 객체를 생성한다.
        str = new String[c.getCount()];//전체 테이블의 데이터 수 파악을하고 배열크기를 초기화 시킨다
        int count = 0;
        while (c.moveToNext()) {//커서를 움직이면서 이름과 학번 데이터를 데이터 셋 배열에 입력 시킨다
            str[count] = c.getString(c.getColumnIndex("name"))//이름과 학번을 데이터 배열에 입력시킨다.
                    + " " + c.getString(c.getColumnIndex("sn"));
            count++;
        }
        c.close();//커서를 닫는다.
    }

    private void invalidate() {//최신화 시키는 함수
        select();//셀렉트 함수를 통해 배열에 정보들을 지속적으로 업데이트 시킨다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);//어뎁터와 리스트 뷰를 사용해서 위젯에서 차례대로 계속해서 띄어준다.
        listView.setAdapter(adapter);
    }
}
