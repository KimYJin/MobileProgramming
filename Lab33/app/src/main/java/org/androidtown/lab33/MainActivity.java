package org.androidtown.lab33;

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

        firstFragment=(FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        secondFragment= new SecondFragment();
    }


    private void setListener(){
        tab1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_for_fragment,firstFragment).commit();
            }
        });

        tab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_for_fragment,secondFragment).commit();
            }
        });
    }

}