package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MinyoGameResult extends AppCompatActivity {

    TextView correct, wrong; // 맞은 개수, 틀린 개수
    int correct_num, wrong_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minyo_game_result);

        correct = findViewById(R.id.correct);
        wrong = findViewById(R.id.wrong);

        Intent getMinyoIntent = getIntent();
        correct_num = getMinyoIntent.getIntExtra("correct",0);
        wrong_num = getMinyoIntent.getIntExtra("wrong",0);

        correct.setText(String.valueOf(correct_num));
        wrong.setText(String.valueOf(wrong_num));


    }

    public void replayMinyoGame(View view) {
        startActivity(new Intent(MinyoGameResult.this, MinyoGameIntro.class));
    }
}