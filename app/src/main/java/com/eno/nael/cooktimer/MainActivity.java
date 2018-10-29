package com.eno.nael.cooktimer;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.harjot.crollerTest.Croller;
import com.sdsmdg.harjot.crollerTest.OnCrollerChangeListener;

public class MainActivity extends AppCompatActivity {
    // Declaring
    Croller croller;
    Button button;
    Button tipsBtn;
    Button bFBtn;
    TextView textView;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;
    TextView textView2;
    Animation zoom;
    ImageView imageView;

    // reset method
    public void reset() {
        textView.setText("5:00");
        croller.setProgress(300);
        counterIsActive = false;
        croller.setEnabled(true);
        countDownTimer.cancel();
        button.setText("Go!");
        textView2.setVisibility(View.INVISIBLE);
    }

    public void Any(int leftTime) {
        int mint = leftTime / 60;
        int secnd = leftTime - mint * 60;
        String StringSecnd = Integer.toString(secnd);
        if (secnd <= 9) {
            StringSecnd = "0" + Integer.toString(secnd);
        }
        textView.setText(Integer.toString(mint) + ":" + StringSecnd);
    }

    public void timerControl(View view) {
        if (counterIsActive == false) {
            counterIsActive = true;
            //croller.setEnabled(false);
            button.setText("Stop");
//            textView2.setVisibility(View.INVISIBLE);
            countDownTimer = new CountDownTimer((int) croller.getProgress() * 1000 + 100, 1000) {

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
        } else {
            reset();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.wow);
        mediaPlayer.start();

        button = findViewById(R.id.button);
        tipsBtn = findViewById(R.id.tipsBtn);
        bFBtn = findViewById(R.id.bFBtn);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        croller = findViewById(R.id.croller);
        imageView = findViewById(R.id.imageView);
        try{
            croller.setMax(900 * 2);
            croller.setProgress(0);
            croller.setProgressPrimaryCircleSize(10f);
        }catch (Exception e){
            Toast.makeText(this, "nothing happened", Toast.LENGTH_SHORT).show();
        }



        croller.setOnCrollerChangeListener(new OnCrollerChangeListener() {
            @Override
            public void onProgressChanged(Croller croller, int progress) {
                Any((progress));

            }

            @Override
            public void onStartTrackingTouch(Croller croller) {
//                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dun);
//                mediaPlayer.start(); // tracking started
            }

            @Override
            public void onStopTrackingTouch(Croller croller) {
                // croller.setProgress(0); // tracking stopped
            }
        });
    }

    public void tips(View view) {

        Intent intent = new Intent(this, TipsActivity.class);
        startActivity(intent);
    }

    public void breakfast(View view) {


        Intent intent = new Intent(this, BreakfastActivity.class);
        startActivity(intent);
    }

    public void cotact(View view) {

        Intent intent = new Intent(this, ContactUsActivity.class);
        startActivity(intent);
    }

}

