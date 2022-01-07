package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Relative1 extends AppCompatActivity {
    int scoreTeamA=0;
    int scoreTeamB=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
    }
    public void addThree(View view){
        scoreTeamA = scoreTeamA+3;
        displayscoreTeamA(scoreTeamA);
    }
    public void addTwo(View view){
        scoreTeamA = scoreTeamA+2;
        displayscoreTeamA(scoreTeamA);
    }
    public void addOne(View view){
        scoreTeamA = scoreTeamA+1;
        displayscoreTeamA(scoreTeamA);
    }
    public void addOneB(View view){
        scoreTeamB = scoreTeamB+1;
        displayscoreTeamB(scoreTeamB);
    }
    public void addTwoB(View view){
        scoreTeamB=scoreTeamB+2;
        displayscoreTeamB(scoreTeamB);
    }
    public void addThreeB(View view){
        scoreTeamB=scoreTeamB+3;
        displayscoreTeamB(scoreTeamB);
    }
    public void reset(View view){
        scoreTeamA=0;
        scoreTeamB=0;
        displayscoreTeamA(scoreTeamA);
        displayscoreTeamB(scoreTeamB);
    }

    public void displayscoreTeamA(int number){
        TextView TeamATextView=(TextView) findViewById(R.id.team_a);
        TeamATextView.setText(""+number);
    }

    public void displayscoreTeamB(int number){
        TextView TeamATextView=(TextView) findViewById(R.id.team_b);
        TeamATextView.setText(""+number);
    }




}
