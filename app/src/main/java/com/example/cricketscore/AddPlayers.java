package com.example.cricketscore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddPlayers extends AppCompatActivity {
    Button button;
    EditText editText, editText2, editText3;
    String host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        button = (Button) findViewById(R.id.start_match);
        editText = (EditText) findViewById(R.id.striker);
        editText2 = (EditText) findViewById(R.id.non_striker);
        editText3 = (EditText) findViewById(R.id.opening_bowler);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);

        button.setOnClickListener(view -> {
            Intent intent1 = new Intent(AddPlayers.this, InputScoreboard.class);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("striker", editText.getText().toString());
            myEdit.putString("nonStriker", editText2.getText().toString());
            myEdit.putString("openingBowler", editText3.getText().toString());
            myEdit.commit();
            startActivity(intent1);
        });

    }
}