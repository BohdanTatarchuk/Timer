package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton buttonStart;
    FloatingActionButton buttonStop;
    FloatingActionButton buttonPause;
    EditText editTextSeconds;
    EditText editTextMinutes;
    EditText editTextHours;

    CountDownTimer timer;
    boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.button_start);
        buttonStop = findViewById(R.id.button_stop);
        buttonPause = findViewById(R.id.button_pause);
        editTextSeconds = findViewById(R.id.editTextSeconds);
        editTextMinutes = findViewById(R.id.editTextMinutes);
        editTextHours = findViewById(R.id.editTextHours);

        buttonStart.setOnClickListener(view -> {
            if(editTextMinutes.getText().toString().equals("") &&
                    editTextSeconds.getText().toString().equals("") &&
                    editTextHours.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Write your time!", Toast.LENGTH_SHORT).show();
            } else {
                startTimer();
                buttonPause.setVisibility(View.VISIBLE);
                buttonStop.setVisibility(View.VISIBLE);
            }
        });

        buttonPause.setOnClickListener(view -> {
            if(timerRunning){
                pauseTimer();
            } else {
                startTimer();
            }
        });

        buttonStop.setOnClickListener(view -> resetTimer());
    }

    private void startTimer(){
        long seconds = Long.parseLong(String.valueOf(editTextSeconds.getText()));

        timer = new CountDownTimer(seconds*1000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                editTextSeconds.setText(Long.toString((l/1000)));
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