package com.eno.nael.cooktimer;


import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sdsmdg.harjot.crollerTest.Croller;
import com.sdsmdg.harjot.crollerTest.OnCrollerChangeListener;
public class MainActivity extends AppCompatActivity {

    // Declaring
    Croller croller;
    Button button;
    TextView textView;
    Boolean counterIsActive=false;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;
    TextView textView2;



// reset method
public void reset (){
    textView.setText("5:00");
   croller.setProgress(300);
    counterIsActive=false;
 //   croller.setEnabled(true);
    countDownTimer.cancel();
    button.setText("Go!");
    textView2.setVisibility(View.INVISIBLE);
}


public void Any (int leftTime){
        int mint = leftTime /60;
        int secnd =leftTime-mint*60;
        String StringSecnd=Integer.toString(secnd);
        if (secnd<=9){
            StringSecnd="0"+Integer.toString(secnd);
        }
        textView.setText(Integer.toString(mint)+":"+StringSecnd);
}
public void timerControl (View view){
        if(counterIsActive==false) {
            counterIsActive = true;
            //croller.setEnabled(false);
            button.setText("Stop");
            textView2.setVisibility(View.INVISIBLE);
            countDownTimer = new CountDownTimer( (int)croller.getProgress()*1000 + 100 , 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    Any((int) (millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                   reset();

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.telephone);
                    mediaPlayer.start();


                }
            }.start();
        }else {
            reset();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.button);
        textView=(TextView) findViewById(R.id.textView);
        textView2=(TextView) findViewById(R.id.textView2);
        croller = (Croller) findViewById(R.id.croller);

        //croller properties
        croller.setIndicatorWidth(10);
        croller.setBackCircleColor(Color.parseColor("#EDEDED"));
        croller.setMainCircleColor(android.R.color.white);
        croller.setMax(900*2);
        croller.setProgress(300);
        croller.setStartOffset(45);
        croller.setIsContinuous(true);
        croller.setLabelColor(Color.BLACK);
        croller.setProgressPrimaryColor(Color.parseColor("#fb9d4f"));
        croller.setIndicatorColor(Color.parseColor("#0B3C49"));
        croller.setProgressSecondaryColor(Color.parseColor("#f9b97a"));
        croller.setProgressPrimaryCircleSize(60);










         croller.setOnCrollerChangeListener(new OnCrollerChangeListener() {
            @Override
            public void onProgressChanged(Croller croller, int progress) {
                Any(( progress));

            }

            @Override
            public void onStartTrackingTouch(Croller croller) {
                // tracking started
            }

            @Override
            public void onStopTrackingTouch(Croller croller) {
               // croller.setProgress(0); // tracking stopped
            }
        });






    }
}
