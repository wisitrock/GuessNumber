package th.ac.su.cp.guessnumber.model;

import android.util.Log;

import java.util.Random;

public class Answer {
    private int value;

    public Answer() {
        randomvalue();
    }

    private void randomvalue(){
        Random r = new Random();
        this.value = r.nextInt(100);
        Log.i("MainActivity","ค่าของ answer ที่สุ่มได้คือ "+this.value);
    }
   public String checkAnswer(int num){
        String msg;
        if(num==this.value){
            msg="ถูกต้องครับไอสัส";
        }else if (num>this.value) {
            //ทายตัวเลยที่มากเกินไป
            msg="ผิดครับทายมากเกินไป";
        }else{
            //ทายตัวเลยที่มากเกินไป
            msg="ผิดครับทายน้อยเกินไป";
        }
        return  msg;
    }
}
