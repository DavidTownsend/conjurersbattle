package com.lol.conjurersbattle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lol.conjurersbattle.engines.MainEngine;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_simulation_button = (Button) findViewById(R.id.start_simulation_button);

        start_simulation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainEngine mainEngine = new MainEngine();
                try {
                    mainEngine.startTurn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
