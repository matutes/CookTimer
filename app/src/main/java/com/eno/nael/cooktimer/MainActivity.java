package com.eno.nael.cooktimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    Button button;
    TextView textView;
    Boolean counterIsActive=false;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;
    TextView textView2;
public void reset (){
    textView.setText("5:00");
    seekBar.setProgress(300);
    counterIsActive=false;
    seekBar.setEnabled(true);
    countDownTimer.cancel();
    button.setText("Go!");
    textView2.setVisibility(View.INVISIBLE);



}

    public void Any (int leftTime){
        int mint =(int) leftTime/60;
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
            seekBar.setEnabled(false);
            button.setText("Stop");
            textView2.setVisibility(View.INVISIBLE);
            countDownTimer=new  CountDownTimer((int) seekBar.getProgress() * 1000 + 100, 1000) {
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
        seekBar=(SeekBar)findViewById(R.id.seekBar3);
        button=(Button) findViewById(R.id.button);
        textView=(TextView) findViewById(R.id.textView);
        textView2=(TextView) findViewById(R.id.textView2);

        seekBar.setMax(900*2);
        seekBar.setProgress(300);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Any(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






    }
}
