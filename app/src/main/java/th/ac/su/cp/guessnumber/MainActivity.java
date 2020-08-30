package th.ac.su.cp.guessnumber;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import th.ac.su.cp.guessnumber.model.Answer;

public class MainActivity extends AppCompatActivity {

    Answer a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = new Answer();



        // Camel case
        Button guessButton = findViewById(R.id.guess_button);
       // guessButton.setText("Hello");
        guessButton.setTextColor(Color.RED);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////////ร อ่านค่าจาก edittext ที่รับมา////////
                EditText numberEditText = findViewById(R.id.number_edit_text);
                String numText = numberEditText.getText().toString();
                int num  = Integer.parseInt(numText);

                String msg=a.checkAnswer(num);

              /* double x = 5/2.0;
                Log.i("MainActivity","ค่าของ x "+x);*/

                /*if(num==answer){
                            msg="ถูกต้องครับไอสัส".;
                }else if (num>answer) {
                    //ทายตัวเลยที่มากเกินไป
                            msg="ผิดครับทายมากเกินไป";
                }else{
                    //ทายตัวเลยที่มากเกินไป
                            msg="ผิดครับทายน้อยเกินไป";
                }*/
                Toast t = Toast.makeText(
                        MainActivity.this,
                        msg,
                        Toast.LENGTH_LONG
                );
                t.show();


            }
        });
    }


}