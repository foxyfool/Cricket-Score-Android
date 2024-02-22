package com.example.cricketscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class PlayerInfo extends AppCompatActivity {
    String player, team;
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8;
    Database database;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);

        Intent intent = getIntent();
        player = intent.getStringExtra("player");
        team = intent.getStringExtra("team");
        textView1 = (TextView) findViewById(R.id.matches);
        textView2 = (TextView) findViewById(R.id.fours);
        textView3 = (TextView) findViewById(R.id.sixes);
        textView4 = (TextView) findViewById(R.id.runs);
        textView5 = (TextView) findViewById(R.id.balls);
        textView6 = (TextView) findViewById(R.id.wickets);
        textView7 = (TextView) findViewById(R.id.fifties);
        textView8 = (TextView) findViewById(R.id.hundreds);

        cursor = database.getPlayerInfo(player, team);

        if(cursor.getCount() > 0)
        {
            while(cursor.moveToNext()) {
                textView1.setText(textView1.getText() + "\n" + cursor.getString(1));
                textView2.setText(textView2.getText() + "\n" + cursor.getString(2));
                textView3.setText(textView3.getText() + "\n" + cursor.getString(3));
                textView3.setText(textView4.getText() + "\n" + cursor.getString(4));
                textView7.setText(textView7.getText() + "\n" + cursor.getString(5));
                textView8.setText(textView8.getText() + "\n" + cursor.getString(6));
                textView5.setText(textView5.getText() + "\n" + cursor.getString(7));
                textView6.setText(textView6.getText() + "\n" + cursor.getString(8));
            }
        }
    }
}