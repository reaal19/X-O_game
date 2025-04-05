/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cp2.project;

import java.util.*;
public class CP2Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        //Get the players' names
        System.out.println("Player 1, what is your name? ");
        String p1 = s.next();
        System.out.println("Player 2, what is your name? ");
        String p2 = s.next();
        
        //3x3 tic Tac Toe board
        //- empty space
        //2 player 1
        //O player 2
        char[][] board = new char[3][3];
        
        //Fill the board with dashes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        
        //Keep track of whose turn it is
        boolean isPlayer1 = true;
        
        //Keep track if the game has ended
        boolean gameEnded = false;
        
        while (!gameEnded) {
            //Draw the board
            drawBoard(board);


            //Keep track of what symbol we are suing to play
            char symbol = ' ';

            if (isPlayer1) {
                symbol = 'X';
            }

            else {
                symbol = 'O';
            }

            //Print out the player's turn
              if(isPlayer1){
                System.out.println(p1 + "'s Turn(X):");
              }
              else {  
                System.out.println(p2 + "'s Turn(O):");
              }

            //Row and col variables
            int row = 0;
            int col = 0;

            while (true) {
                //Get row and col from user
                System.out.print("Enter a row (0, 1. or 2): ");
                row = s.nextInt();
                System.out.print("Enter a column (0, 1. or 2): ");
                col = s.nextInt();

                //Check if row and col are valid
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    //Row and col are out of bounds
                    System.out.println("Your row and column are out of bounds");
                }

                else if (board[row][col] != '-') {
                    //Board postion has an X or O
                    System.out.println("Someone has already made a move there!");
                }

                else {
                    //Row and col are valid!
                    break;
                }

            }

            //Setting the position on the board to the player's
            board[row][col] = symbol;

            

            //Check if a player has won
            if (hasWon(board) == 'X') {
                //Player 1 has won
                System.out.println(p1 + " has won!");
                gameEnded = true;
            }

            else if (hasWon(board) == 'O') {
                //Player 2 has won
                System.out.println(p2 + " has won!");
                gameEnded = true;
            }

            else {
                //Nobody has won
                if (hasTied(board)) {
                    //Tied
                    System.out.println("It's a tie");
                    gameEnded = true;
                }
                
                else {
                    //Continue the game and toggles the turn
                    isPlayer1 = !isPlayer1;
                }
            }
            
        }  
        
        //Print out final state of the board
        drawBoard(board);
        
    }
    
    //Printing out the board
    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                System.out.print(board[i][j]);
            }
            
            System.out.println();
        }
    }
    
     public static char hasWon(char[][] board) {
      //Row
      for(int i=0;i<3;i++){
         if(board[i][0]==board[i][1] && board[i][1]==board
         [i][2] && board[i][0] !='-' ) {
           return board[i][0];
         }
      }
      
     //Col
      for(int j=0;j<3;j++){
        if(board[0][j]==board[1][j]&&board[1][j]==board
        [2][j]&&board[0][j]!='-') {
        return board[0][j];
        }
      }
      
     //Diagonals
     if(board[0][0]==board[1][1]&&board[1][1]==board
     [2][2]&&board[0][0]!='-') {
       return board[0][0];
     }

     if(board[2][0]==board[1][1] && board[1][1]==board
     [0][2]&&board[2][0]!='-') {
       return board[2][0];
     }
    
    //Nobody has won
    return '-';
  }
     
     //Check if the board is full
     public static boolean hasTied(char[][] board) {
         for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 if (board[i][j] == '-') {
                     return false;
                 }
             }
         }
         
         return true;
     }
     
     
    
}
