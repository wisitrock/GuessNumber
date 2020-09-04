package th.ac.su.cp.guessnumber;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import th.ac.su.cp.guessnumber.model.Answer;

public class MainActivity extends AppCompatActivity {

    Answer a;
    int score = 0;

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
                int num = Integer.parseInt(numText);

                Answer.GuessResult result = a.checkAnswer(num);

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
            /*    Toast t = Toast.makeText(
                        MainActivity.this,
                        msg,
                        Toast.LENGTH_LONG
                );
                t.show();*/
                TextView resultTextView = findViewById(R.id.result_text_view);
                switch (result) {
                    case OK:
                        score++;
                        Log.i("MainActivity","คะแนนทั้งหมด : "+ score);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("ผลลัพท์");
                        dialog.setMessage("ถูกต้องนะครับ \n\n คุณต้องการเล่นเกมใหม่หรือไม่");
                        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //todo : ทำการสุ่มเลขใหม่

                                    a = new Answer();
                            }
                        });
                        dialog.setNegativeButton("No", null);
                        dialog.show();
                        resultTextView.setText("");
                        break;
                    case OVER:

                        resultTextView.setText("ผิดครับ! ทายมากเกินไปครับ");
                       /* dialog.setMessage("ผิดครับ! ทายมากเกินไปครับ");
                        dialog.setPositiveButton("OK", null);*/
                        break;
                    case UNDER:
                        resultTextView.setText("ผิดครับ! ทายน้อยเกินไปครับ");
                       /* dialog.setMessage("ผิดครับ! ทายน้อยเกินไปครับ");
                        dialog.setPositiveButton("OK", null);*/
                        break;


                }

                /*
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("ผลลัพท์");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK",null);
                dialog.show();
*/
            }
        });

        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle(R.string.exit_titile);
                dialog.setMessage(R.string.exit_message);
                dialog.setNegativeButton("No", null);
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                dialog.show();
            }
        });

        Button scoreButton =findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,ScoreActivity.class);
                i.putExtra("score",score);
                startActivity(i);
            }
        });
    }


}