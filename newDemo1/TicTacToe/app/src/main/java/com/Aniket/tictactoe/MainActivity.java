package com.Aniket.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        int player = 0; //0 --> player 1 && 1 --> player 2
        int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int[][] win = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}};
        boolean activeGame = true;

        public void Clicked(View view) {
            if (!activeGame)
                reset(view);
            ImageView img = (ImageView) view;
            int tapPostion = Integer.parseInt(img.getTag().toString());
            if (gameState[tapPostion] == 2) {
                gameState[tapPostion] = player;
                img.setTranslationX(-1000f);
                TextView result = findViewById(R.id.Result);
                result.setText("Tap to Play");
                if (player == 0) {
                    player = 1;
                    img.setImageResource(R.drawable.x);
                    result.setText("O's Turn : Tap to play");
                } else {
                    player = 0;
                    img.setImageResource(R.drawable.o);
                    result.setText("X's Turn : Tap to play");
                }
                img.animate().translationXBy(1000f).setDuration(100);
            }

            String winner = "";
            for (int[] win : win) {
                if (gameState[win[0]] == gameState[win[1]] &&
                        gameState[win[1]] == gameState[win[2]] && gameState[win[0]] != 2) {
                    if (gameState[win[0]] == 0) {
                        winner = "Player1 has won";
                    } else {
                        winner = "Player2 has won";
                    }
                    TextView result = findViewById(R.id.Result);
                    Toast.makeText(this, winner, Toast.LENGTH_SHORT).show();
                    result.setText("Tap To Play Again");
                    activeGame = false;
                }
            }

            int count = 0;
            for(int i=0; i<9; i++)
            {
                if(gameState[i] != 2)
                        count++;
            }
            if(count == 9 && winner == ""){
                Toast.makeText(this, "Oops No one wins\n Game has been Reseted", Toast.LENGTH_SHORT).show();
                TextView result = findViewById(R.id.Result);
                result.setText("Tap to Play");
                activeGame = false;
            }
        }

            public void reset(View view){
            activeGame = true;
            player = 0;
            for(int i=0; i<9; i++)
                    gameState[i]=2;
            ((ImageView)findViewById(R.id.i0)).setImageResource(0);
            ((ImageView)findViewById(R.id.i1)).setImageResource(0);
            ((ImageView)findViewById(R.id.i2)).setImageResource(0);
            ((ImageView)findViewById(R.id.i3)).setImageResource(0);
            ((ImageView)findViewById(R.id.i4)).setImageResource(0);
            ((ImageView)findViewById(R.id.i5)).setImageResource(0);
            ((ImageView)findViewById(R.id.i6)).setImageResource(0);
            ((ImageView)findViewById(R.id.i7)).setImageResource(0);
            ((ImageView)findViewById(R.id.i8)).setImageResource(0);
            activeGame = true;
        }
}
