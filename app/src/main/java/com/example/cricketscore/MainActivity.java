package com.example.cricketscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addMatch, matchHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMatch = (Button) findViewById(R.id.add_match);
        matchHistory = (Button) findViewById(R.id.match_history);

        addMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddMatch.class);
                startActivity(intent);
            }
        });

        matchHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MatchHistory.class);
                startActivity(intent);
            }
        });

    }

    public void openTeamStats(View view) {
        Intent intent = new Intent(MainActivity.this, TeamStats.class);
        startActivity(intent);
    }
}