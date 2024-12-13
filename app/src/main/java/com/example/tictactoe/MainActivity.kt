package com.example.tictactoe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var turn = 0;
        var board = Array(3) { IntArray(3) { 0 } } //0 is empty, 1 is X, 2 is O
        // Get the ImageButton by ID
        // Declare and initialize the ImageButtons
        var imageButton00 = findViewById<ImageButton>(R.id.imageButton00)
        var imageButton01 = findViewById<ImageButton>(R.id.imageButton01)
        var imageButton02 = findViewById<ImageButton>(R.id.imageButton02)

        var imageButton10 = findViewById<ImageButton>(R.id.imageButton10)
        var imageButton11 = findViewById<ImageButton>(R.id.imageButton11)
        var imageButton12 = findViewById<ImageButton>(R.id.imageButton12)

        var imageButton20 = findViewById<ImageButton>(R.id.imageButton20)
        var imageButton21 = findViewById<ImageButton>(R.id.imageButton21)
        var imageButton22 = findViewById<ImageButton>(R.id.imageButton22)
        var status=findViewById<TextView>(R.id.StatusBtn)
        imageButton00.setOnClickListener {
            if (board[0][0] == 0) { // Check if the spot is empty
                if (turn % 2 == 0) {
                    imageButton00.setImageResource(R.drawable.x_logo)
                    board[0][0] = 1
                } else {
                    imageButton00.setImageResource(R.drawable.o_logo)
                    board[0][0] = 2
                }
                turn++
            }
        }

        imageButton01.setOnClickListener {
            if (board[0][1] == 0) {
                if (turn % 2 == 0) {
                    imageButton01.setImageResource(R.drawable.x_logo)
                    board[0][1] = 1
                } else {
                    imageButton01.setImageResource(R.drawable.o_logo)
                    board[0][1] = 2
                }
                turn++
            }
        }

        imageButton02.setOnClickListener {
            if (board[0][2] == 0) {
                if (turn % 2 == 0) {
                    imageButton02.setImageResource(R.drawable.x_logo)
                    board[0][2] = 1
                } else {
                    imageButton02.setImageResource(R.drawable.o_logo)
                    board[0][2] = 2
                }
                turn++
            }
        }

        imageButton10.setOnClickListener {
            if (board[1][0] == 0) {
                if (turn % 2 == 0) {
                    imageButton10.setImageResource(R.drawable.x_logo)
                    board[1][0] = 1
                } else {
                    imageButton10.setImageResource(R.drawable.o_logo)
                    board[1][0] = 2
                }
                turn++
            }
        }

        imageButton11.setOnClickListener {
            if (board[1][1] == 0) {
                if (turn % 2 == 0) {
                    imageButton11.setImageResource(R.drawable.x_logo)
                    board[1][1] = 1
                } else {
                    imageButton11.setImageResource(R.drawable.o_logo)
                    board[1][1] = 2
                }
                turn++
            }
        }

        imageButton12.setOnClickListener {
            if (board[1][2] == 0) {
                if (turn % 2 == 0) {
                    imageButton12.setImageResource(R.drawable.x_logo)
                    board[1][2] = 1
                } else {
                    imageButton12.setImageResource(R.drawable.o_logo)
                    board[1][2] = 2
                }
                turn++
            }
        }

        imageButton20.setOnClickListener {
            if (board[2][0] == 0) {
                if (turn % 2 == 0) {
                    imageButton20.setImageResource(R.drawable.x_logo)
                    board[2][0] = 1
                } else {
                    imageButton20.setImageResource(R.drawable.o_logo)
                    board[2][0] = 2
                }
                turn++
            }
        }

        imageButton21.setOnClickListener {
            if (board[2][1] == 0) {
                if (turn % 2 == 0) {
                    imageButton21.setImageResource(R.drawable.x_logo)
                    board[2][1] = 1
                } else {
                    imageButton21.setImageResource(R.drawable.o_logo)
                    board[2][1] = 2
                }
                turn++
            }
        }

        imageButton22.setOnClickListener {
            if (board[2][2] == 0) {
                if (turn % 2 == 0) {
                    imageButton22.setImageResource(R.drawable.x_logo)
                    board[2][2] = 1
                } else {
                    imageButton22.setImageResource(R.drawable.o_logo)
                    board[2][2] = 2
                }
                turn++
                if(checkIfWon(board)==1){
                    status.text="Player X won"

                }else if(checkIfWon(board)==2) {
                    status.text = "Player O won"
                }
                else if(checkIfWon(board)==3){
                    status.text="It's a draw"

                }
                else{
                    if (turn % 2 == 0) {
                        status.text="Player X's turn"
                    } else {
                        status.text = "Player O's turn"
                    }
                }
            }
        }

    }
    fun checkIfWon(board: Array<IntArray>): Int {
        for (i in 0..2) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != 0) {
                // Horizontal win
                return board[i][0]
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != 0) {
                // Vertical win
                return board[0][i]
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0) {
            // Diagonal win
            return board[0][0]
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0) {
            // Diagonal win
            return board[0][2]
        }
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == 0) {
                    return 0
                }
            }

        }
        if (false){
            return 2;
        };
        return 3;
    }
}