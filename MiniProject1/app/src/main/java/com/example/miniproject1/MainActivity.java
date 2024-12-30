package com.example.miniproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String [][] questions = {
            {"Which is the newest character in Brawl Stars at December 12.2024","Shelly","Bull","Frenk","Buzz Lighter","4"},
            {"Who is creator of Minecraft","Bill Gates","Ilon Musk","Steve Jobs","Markus Persson","4"},
            {"Highest building in 2024","Eiffel Tower","Burj Khalifa","One World Trade Center","Shanghai Tower","2"},
            {"Richest man in the world at December 12.2024","Bill Gates","Ilon Musk","Gautam Adani","Lei Jun","3"},

    };

    int currentQuestion = 0,score = 0;
    TextView questionText, scoreText;
    Button[] options= new Button[4];

    Button playAgainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionText = findViewById(R.id.questionText);
        options[0] = findViewById(R.id.btn1);
        options[1] = findViewById(R.id.btn2);
        options[2] = findViewById(R.id.btn3);
        options[3] = findViewById(R.id.btn4);
        playAgainButton = findViewById(R.id.btnAgain);
        scoreText = findViewById(R.id.score);

        loadQuestion();
        for (int i = 0; i < options.length; i++) {
            int finalI  =i;
            options[i].setOnClickListener( v -> checkAnswer(finalI + 1));
        }
        playAgainButton.setOnClickListener( v -> resetGame());
    }

    private void resetGame(){
        currentQuestion = 0;
        score = 0;
        scoreText.setText(score);
        for (Button option : options){
            option.setVisibility(View.VISIBLE);
        }
        loadQuestion();
        playAgainButton.setVisibility(View.GONE);
    }
    private void loadQuestion() {
        if (currentQuestion < questions.length){
            questionText.setText(questions[currentQuestion][0]);
            for (int i = 0; i < options.length; i++) {
                options[i].setText(questions[currentQuestion][i + 1]);
                options[i].setBackgroundColor(Color.LTGRAY);
                options[i].setEnabled(true);
            }
        }
        else {
            questionText.setText("Quiz is Finished\n Score: " + score + "/" + questions.length);
            for (Button option : options) {
                option.setVisibility(View.GONE);
            }
            playAgainButton.setVisibility(View.VISIBLE);
        }
    }
    private void checkAnswer(int selectedOption){
        int correct = Integer.parseInt(questions[currentQuestion][5]);
        if (selectedOption == correct){
            options[selectedOption - 1].setBackgroundColor(Color.GREEN);
            score++;
        }
        else {
            options[selectedOption - 1].setBackgroundColor(Color.RED);
            options[correct - 1].setBackgroundColor(Color.GREEN);
        }

        scoreText.setText("Score: " + score);
        for (Button option : options) {
            option.setEnabled(false);
        }
        questionText.postDelayed( () ->{currentQuestion++;loadQuestion();},2000);
    }
}