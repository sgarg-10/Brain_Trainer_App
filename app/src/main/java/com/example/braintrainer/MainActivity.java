package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    ArrayList<Integer> answers= new ArrayList<Integer>();
    int locationofcorrectanswer;
    TextView resultTextview;
    int score=0;
    int noofquestion=0;
    TextView scoreTextview;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgain;
    ImageView imageView;

    public void playAgain(View view){
        score=0;
        noofquestion=0;
        timerTextView.setText("30s");
        scoreTextview.setText(Integer.toString(score)+ "/" +Integer.toString(noofquestion));
        newQuestion();
        playAgain.setVisibility(View.INVISIBLE);
        resultTextview.setText("");
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {

                timerTextView.setText(String.valueOf(millisUntilFinished/1000) + "s");

            }

            @Override
            public void onFinish() {
                resultTextview.setText("Done");
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();


    }

    public void chooseAnswer(View view){

        if(Integer.toString(locationofcorrectanswer).equals(view.getTag().toString()))
        {
             resultTextview.setText("Correct!!");
             score++;
        }
        else
        {
            resultTextview.setText("Wrong :(");
        }
        noofquestion++;
        scoreTextview.setText(Integer.toString(score)+ "/" +Integer.toString(noofquestion));
        newQuestion();



    }

    public void go(View view){
        button.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.timerTextView));
        sumTextView.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        scoreTextview.setVisibility(View.VISIBLE);
        resultTextview.setVisibility(View.VISIBLE);
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.VISIBLE);

    }

    public void newQuestion(){

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + "+" + Integer.toString(b));

        locationofcorrectanswer = rand.nextInt(4);
        answers.clear();

        for (int i = 0; i <= 3; i++) {
            if (i == locationofcorrectanswer) {
                answers.add(a + b);
            }
            else {
                int Wronganswer = rand.nextInt(41);
                while (Wronganswer == a + b) {
                    Wronganswer = rand.nextInt(41);

                }
                answers.add(Wronganswer);
            }

        }


        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         sumTextView = findViewById(R.id.sumTextView);
         button0=findViewById(R.id.button0);
         button1=findViewById(R.id.button1);
         button2=findViewById(R.id.button2);
         button3=findViewById(R.id.button3);
        resultTextview=findViewById(R.id.resultTextView);
        scoreTextview=findViewById(R.id.scoreTextView);
        timerTextView=findViewById(R.id.timerTextView);
        playAgain = findViewById(R.id.playAgainButton);
        imageView=findViewById(R.id.imageView);

        button = findViewById(R.id.button);
        button.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.INVISIBLE);
        timerTextView.setVisibility(View.INVISIBLE);
        scoreTextview.setVisibility(View.INVISIBLE);
        sumTextView.setVisibility(View.INVISIBLE);
        resultTextview.setVisibility(View.INVISIBLE);
        button0.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);



    }}
