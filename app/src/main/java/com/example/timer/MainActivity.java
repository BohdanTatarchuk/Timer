package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton buttonStart;
    FloatingActionButton buttonStop;
    FloatingActionButton buttonPause;
    EditText editText;

    CountDownTimer timer;
    boolean timerRunning;
    long timeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.button_start);
        buttonStop = findViewById(R.id.button_stop);
        buttonPause = findViewById(R.id.button_pause);
        editText = findViewById(R.id.editTextNumber);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startTimer();
              buttonPause.setVisibility(View.VISIBLE);
              buttonStop.setVisibility(View.VISIBLE);
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerRunning){
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
    }

    private void startTimer(){
        timeLeft = Long.parseLong(String.valueOf(editText.getText()));
        timer = new CountDownTimer(timeLeft*1000, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                editText.setText(Long.toString(l/1000));
            }

            @Override
            public void onFinish() {
                timerRunning = false;
            }
        }.start();
        timerRunning = true;
    }

    private void pauseTimer(){
        timer.cancel();
        timerRunning = false;
    }

    private void resetTimer(){
        timer.cancel();
        timerRunning = false;
        buttonStop.setVisibility(View.INVISIBLE);
        buttonPause.setVisibility(View.INVISIBLE);
    }
}