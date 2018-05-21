package org.androidtown.lab5_2;

 import android.os.AsyncTask;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.TextView;


 public class MainActivity extends AppCompatActivity {


     EditText editText;
     Button calculBtn;
     TextView showText;
     TextView resultText;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         editText = findViewById(R.id.editText);
         calculBtn = findViewById(R.id.calculBtn);
         showText = findViewById(R.id.showText);
         resultText = findViewById(R.id.resultText);


         calculBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 CalculateTask task = new CalculateTask();
                 int num = Integer.parseInt(editText.getText().toString()); //get number from editText
                 task.execute(num);
             }
         });


     }


     class CalculateTask extends AsyncTask<Integer, Integer, Void>{

         String s = "";
         long c = 1;

         @Override
         protected void onPreExecute() {
             super.onPreExecute();
         }


         @Override
         protected void onPostExecute(Void aVoid) {
             super.onPostExecute(aVoid);
         }


         @Override
         protected Void doInBackground(Integer... integers) {
             int n = integers[0];
             int temp = n;
             for(int i = 0 ; i < n ; i++){
                 try {
                     Thread.sleep(500);
                     publishProgress(temp,0); //update
                     temp--;
                 }catch(InterruptedException ex){}
             }
             publishProgress(0,1);//update
             return null;
         }


         @Override
         protected void onProgressUpdate(Integer... values) {
             int n1 = values[0];
             int n2 = values[1];

             //showing factorial numbers.
             if(n2 == 0) {
                 c *= n1;
                 s = s.concat(n1 + " ");
                 showText.setText(s);

             }
             //complete showing factorial numbers.
             else
                 {
                 resultText.setText("= " + c);
             }
         }
     }
 }

