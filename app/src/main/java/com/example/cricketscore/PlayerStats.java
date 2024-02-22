package com.example.cricketscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayerStats extends AppCompatActivity {

    public void submit(View view){
        Intent intent=new Intent(PlayerStats.this,PlayerInfo.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stats);
    }
}