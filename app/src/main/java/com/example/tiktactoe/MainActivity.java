package com.example.tiktactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //declaration
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9; //initialization of buttons
    String b1, b2, b3, b4, b5, b6, b7, b8, b9; //text passed by user
    int flag = 0, moves = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init(); //initialization
        Button end_button = findViewById(R.id.end);
        end_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void check(View view) {
        Button current_button = (Button) view;
        if (current_button.getText().toString().isEmpty()) {
            //if position is blank then only execute the following conditions - this will solve the changing values of buttons upon clicking simultaneously
            moves++;
            if (flag == 0) {
                current_button.setText("X");
                flag = 1;
            } else {
                current_button.setText("O");
                flag = 0;
            }

            if (moves > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //conditions
                if (b1.equals(b2) && b2.equals(b3) && !b1.isEmpty()) {
                    //row 1
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.isEmpty()) {
                    //row 2
                    Toast.makeText(this, "Winner is " + b4, Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.isEmpty()) {
                    //row 3
                    Toast.makeText(this, "Winner is " + b7, Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.isEmpty()) {
                    //column 1
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.isEmpty()) {
                    //column 2
                    Toast.makeText(this, "Winner is " + b2, Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.isEmpty()) {
                    //column 3
                    Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.isEmpty()) {
                    //diagonal 1
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (b3.equals(b5) && b5.equals(b7) && !b7.isEmpty()) {
                    //diagonal 2
                    Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
                    newGame();
                } else if (!b1.isEmpty() && !b2.isEmpty() && !b3.isEmpty() && !b4.isEmpty() && !b5.isEmpty() && !b6.isEmpty() && !b7.isEmpty() && !b8.isEmpty() && !b9.isEmpty()) {
                    Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
                    newGame();
                }
            }
        }
    }

    public void newGame() {
        //method to clear user inputs and start the new game with blank buttons
        int flag = 0, moves = 0;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }
}