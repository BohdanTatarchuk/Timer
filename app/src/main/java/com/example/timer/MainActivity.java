package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextNumber);
        text = findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               long seconds = Long.parseLong(String.valueOf(editText.getText()));
                CountDownTimer timer = new CountDownTimer(seconds * 1000,1000) {
                    @Override
                    public void onTick(long l) {
                        text.setText(Long.toString(l/1000));
                    }

                    @Override
                    public void onFinish() {
                        text.setText("Time is over!");
                    }
                };
                timer.start();
            }
        });
    }
}