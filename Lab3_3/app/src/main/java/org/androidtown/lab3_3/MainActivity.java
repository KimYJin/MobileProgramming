package org.androidtown.lab3_3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button tab1;
    public Button tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make reference to View Objects which is defined in Layout.
        tab1 = (Button) findViewById(R.id.tab1);
        tab2 = (Button) findViewById(R.id.tab2);

        //If tab1 or tab2 clicked, call OnClick method by setOnClickListener.
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        FragmentManager  fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //if tab1 is clicked, call and show first fragment in the framelayout.
        if(id == R.id.tab1) {
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.replace(R.id.container, firstFragment, "firstFragment");
        }
        //if tab2 is clicked, call and show second fragment in the framelayout.
        else if(id == R.id.tab2) {
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.container, secondFragment, "secondFragment");
        }
        fragmentTransaction.commit();
    }
}
