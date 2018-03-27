package org.androidtown.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0; // initialize integer variable,imageIndex 0 to identify whether the button is clicked.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //레이아웃에 정의된 이미지 뷰 객체들을 참조한다.
        //make reference to View Objects which is defined in Layout
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

    }

    // implement when the user push the button which of onClick attribute is 'onButton1Clicked'.
    public void onButton1Clicked(View v) {
        changeImage();
    }

    private void changeImage() {

        // if  the value of imageIndex is 0, then make imageView visible and make imageView2 invisible.
        if (imageIndex == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            imageIndex = 1; // change the value of imageIndex from 0 to 1 to check  whether the button is clicked.
        }
        // if  the value of imageIndex is 1, then make imageView invisible and make imageView2 visible.
        else if(imageIndex==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);

            imageIndex=0;  // change the value of imageIndex from 1 to 0 to check  whether the button is clicked.
        }
    }
}



