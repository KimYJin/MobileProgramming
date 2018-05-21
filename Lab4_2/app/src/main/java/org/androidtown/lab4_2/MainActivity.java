package org.androidtown.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout slidingArea;
    Button baseBtn;
    Button slidingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slidingArea=(LinearLayout)findViewById(R.id.slidingArea);
        baseBtn=(Button)findViewById(R.id.baseButton);
        slidingBtn=(Button)findViewById(R.id.slidingButton);

        /**
         * When you click the button on the base Area,
         * the sliding area appears
         * with the slide animation to the left.
         */
        baseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.leftslide);
                slidingArea.startAnimation(anim);
                slidingArea.setVisibility(View.VISIBLE);

            }
        });

        /**
         * If the sliding area is displayed,
         * click the button on the sliding area,
         *  then the sliding area
         *  disappears with the slide animation to the right
         */
        slidingBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Animation anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rightslide);
                slidingArea.startAnimation(anim);
                slidingArea.setVisibility(View.GONE);
            }
        });
    }
}
