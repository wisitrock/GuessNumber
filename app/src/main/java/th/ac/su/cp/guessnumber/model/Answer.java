package th.ac.su.cp.guessnumber.model;

import android.util.Log;

import java.util.Random;

public class Answer {
    private int value;

    public enum GuessResult{
        OVER,UNDER,OK
    }
    public Answer() {
        randomvalue();
    }

    private void randomvalue(){
        Random r = new Random();
        this.value = r.nextInt(100);
        Log.i("MainActivity","ค่าของ answer ที่สุ่มได้คือ "+this.value);
    }
   public GuessResult checkAnswer(int num){
        GuessResult result;
        if(num==this.value){
            result=GuessResult.OK;
        }else if (num>this.value) {
            //ทายตัวเลยที่มากเกินไป
            result=GuessResult.OVER;
        }else{
            //ทายตัวเลยที่มากเกินไป
            result=GuessResult.UNDER;
        }
        return  result;
    }
}
