package th.ac.su.cp.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent i = getIntent();
        int score = i.getIntExtra("score",0);

        TextView scoretxet = findViewById(R.id.Score_text);
        scoretxet.setText(String.valueOf(score));


    }
}