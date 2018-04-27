package org.androidtown.lab3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button addBtn;
    EditText editName;
    RadioGroup radSex;
    RadioButton radBoy;
    RadioButton radGirl;
    CheckBox chkSms;
    CheckBox chkEmail;

    String name="", sex="", receiveType="";

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make reference to View Objects which is defined in Layout
        addBtn = findViewById(R.id.addBtn);
        editName = findViewById(R.id.editName);
        radSex = findViewById(R.id.radSex);
        radBoy=findViewById(R.id.radBoy);
        radGirl=findViewById(R.id.radGirl);
        chkSms = findViewById(R.id.chkSms);
        chkEmail=findViewById(R.id.chkEmail);

        //make intent to send data to and receive data from New Activity
        intent = new Intent(getApplicationContext(),NewActivity.class);

        //when the addButton(등록) is clicked, send data of name,sex,and receive-type to New Activity.
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = editName.getText().toString();

                int radId = radSex.getCheckedRadioButtonId();
                if(radBoy.getId()==radId)
                    sex+="남";
                if(radGirl.getId()==radId)
                    sex+="여";

                if(chkSms.isChecked())
                    receiveType+="SMS";
                if(chkEmail.isChecked())
                    receiveType+=" e-mail";

                intent.putExtra("name",name);
                intent.putExtra("sex",sex);
                intent.putExtra("receiveType",receiveType);
                startActivity(intent);

                finish();
            }
        });
    }


}
