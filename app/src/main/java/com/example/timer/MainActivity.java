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
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.button_start);
        editText = findViewById(R.id.editTextNumber);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               long seconds = Long.parseLong(String.valueOf(editText.getText()));
                CountDownTimer timer = new CountDownTimer(seconds * 1000,1000) {
                    @Override
                    public void onTick(long l) {
                        editText.setText(Long.toString(l/1000));
                    }

                    @Override
                    public void onFinish() {

                    }
                };
                timer.start();
            }
        });
    }
}