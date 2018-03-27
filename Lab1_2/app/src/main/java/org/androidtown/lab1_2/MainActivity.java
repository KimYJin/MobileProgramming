package org.androidtown.lab1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //make reference to View Objects which is defined in Layout
    public void init(){
        edit_name = (EditText)findViewById(R.id.edit_name);
        btn_print = (Button)findViewById(R.id.btn_print);
        btn_clear = (Button)findViewById(R.id.btn_clear);
        view_print = (TextView)findViewById(R.id.view_print);
    }

    // implement when the user push the button which of onClick attribute is 'clearClicked'.
    public void clearClicked(View v){
        edit_name.setText("");          //initialize 'editView'
        view_print.setText("contents");
    }

    // implement when the user push the button which of onClick attribute is 'printClicked'
    public void printClicked(View v){
        String text="";
        text = edit_name.getText().toString();  // get text from editView object and store as String type.
        view_print.setText(text);    // print out text which is get from editView
    }

}
