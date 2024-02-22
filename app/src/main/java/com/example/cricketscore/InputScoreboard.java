package com.example.cricketscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InputScoreboard extends AppCompatActivity {
    TextView teamsPlaying, batsman1, batsman2;
    Button b0,b1,b2,b3,b4,b5,b6;
    TextView t1,t2,t3,t4,t5,t6;
    Button undo,swap,retire,wicket,wide,noball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_scoreboard);

        teamsPlaying = (TextView) findViewById(R.id.team_names);
        batsman1 = (TextView) findViewById(R.id.batsman_1);
        batsman2 = (TextView) findViewById(R.id.batsman_2);

        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        // The value will be default as empty string because for
        // the very first time when the app is opened, there is nothing to show
        String host = sh.getString("host", "");
        String visitor = sh.getString("visitor", "");
        teamsPlaying.setText(host + " VS \n" + visitor);
        batsman1.setText(sh.getString("striker", ""));
        batsman2.setText(sh.getString("nonStriker", ""));
        int overs = sh.getInt("overs", 0);

        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);



        int i;


        for(i=1;i<=6;i++)
        {
            int finalI = i;
            b0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 1)
                    {
                        t1.setText("0");


                    }
                    if(finalI == 2)
                    {
                        t2.setText("0");
                    }
                    if(finalI == 3)
                    {
                        t3.setText("0");
                    }
                    if(finalI == 4)
                    {
                        t4.setText("0");
                    }
                    if(finalI == 5)
                    {
                        t5.setText("0");
                    }
                    if(finalI == 6)
                    {
                        t6.setText("0");
                    }

                }
            });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 1)
                    {
                        t1.setText("1");


                    }
                    if(finalI == 2)
                    {
                        t2.setText("1");
                    }
                    if(finalI == 3)
                    {
                        t3.setText("1");
                    }
                    if(finalI == 4)
                    {
                        t4.setText("1");
                    }
                    if(finalI == 5)
                    {
                        t5.setText("1");
                    }
                    if(finalI == 6)
                    {
                        t6.setText("1");
                    }

                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 1)
                    {
                        t1.setText("2");


                    }
                    if(finalI == 2)
                    {
                        t2.setText("2");
                    }
                    if(finalI == 3)
                    {
                        t3.setText("2");
                    }
                    if(finalI == 4)
                    {
                        t4.setText("2");
                    }
                    if(finalI == 5)
                    {
                        t5.setText("2");
                    }
                    if(finalI == 6)
                    {
                        t6.setText("2");
                    }

                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 1)
                    {
                        t1.setText("3");


                    }
                    if(finalI == 2)
                    {
                        t2.setText("3");
                    }
                    if(finalI == 3)
                    {
                        t3.setText("3");
                    }
                    if(finalI == 4)
                    {
                        t4.setText("3");
                    }
                    if(finalI == 5)
                    {
                        t5.setText("3");
                    }
                    if(finalI == 6)
                    {
                        t6.setText("3");
                    }

                }
            });

            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 1)
                    {
                        t1.setText("4");


                    }
                    if(finalI == 2)
                    {
                        t2.setText("4");
                    }
                    if(finalI == 3)
                    {
                        t3.setText("4");
                    }
                    if(finalI == 4)
                    {
                        t4.setText("4");
                    }
                    if(finalI == 5)
                    {
                        t5.setText("4");
                    }
                    if(finalI == 6)
                    {
                        t6.setText("4");
                    }

                }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 1)
                    {
                        t1.setText("5");


                    }
                    if(finalI == 2)
                    {
                        t2.setText("5");
                    }
                    if(finalI == 3)
                    {
                        t3.setText("5");
                    }
                    if(finalI == 4)
                    {
                        t4.setText("5");
                    }
                    if(finalI == 5)
                    {
                        t5.setText("5");
                    }
                    if(finalI == 6)
                    {
                        t6.setText("5");
                    }

                }
            });

            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI == 1)
                    {
                        t1.setText("6");


                    }
                    if(finalI == 2)
                    {
                        t2.setText("6");
                    }
                    if(finalI == 3)
                    {
                        t3.setText("6");
                    }
                    if(finalI == 4)
                    {
                        t4.setText("6");
                    }
                    if(finalI == 5)
                    {
                        t5.setText("6");
                    }
                    if(finalI == 6)
                    {
                        t6.setText("6");
                    }

                }
            });
        }
    }
}