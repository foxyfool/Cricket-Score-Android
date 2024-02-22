package com.example.cricketscore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class AddMatch extends AppCompatActivity {
    EditText host, away, overs;
    RadioGroup tossWon, optedFor;
    Button next;
    public void next(View view){
        Intent intent=new Intent(AddMatch.this,AddPlayers.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_match);
        host = (EditText) findViewById(R.id.host_team);
        away = (EditText) findViewById(R.id.visitor_team);
        overs = (EditText) findViewById(R.id.overs);
        tossWon = (RadioGroup) findViewById(R.id.toss_won);
        optedFor = (RadioGroup) findViewById(R.id.opted_for);
        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AddPlayers.class);
            intent.putExtra("host", host.toString());
            intent.putExtra("away", away.toString());
            intent.putExtra("tossWon", tossWon.toString());
            intent.putExtra("optedFor", optedFor.toString());
            intent.putExtra("overs", overs.toString());
            startActivity(intent);
        });

    }

    public void reset(View view) {
        host.setText("");
        away.setText("");
    }
}