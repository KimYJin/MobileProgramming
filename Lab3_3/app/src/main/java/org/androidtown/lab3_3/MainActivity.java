package org.androidtown.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button tab1;
    public Button tab2;
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setListener();
    }

    public void init(){
        tab1 = (Button) findViewById(R.id.tab1);
        tab2 = (Button) findViewById(R.id.tab2);

        //firstFragment =(FirstFragment)getSupportFragmentManager().findFragmentById(R.id.firstFragment);
        firstFragment=new FirstFragment();
        secondFragment= new SecondFragment();
    }

    private void setListener(){
        tab1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                onFragmentChanged(0);
            }
        });

        tab2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                onFragmentChanged(1);
            }
        });
    }


    public void onFragmentChanged(int index){
        if(index==0)
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_for_fragment,firstFragment).commit();
        else if(index==1)
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_for_fragment,secondFragment).commit();
    }

}
