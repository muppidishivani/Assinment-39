package com.web.java;

import java.util.Scanner;

public class TicToe_39 {

	
	    private char[][] board;
	    private char currentPlayer;

	    public TicToe_39() {
	        board = new char[3][3];
	        currentPlayer = 'X';
	        initializeBoard();
	    }

	   
	    private void initializeBoard() {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = '-';
	            }
	        }
	    }

	    
	    public void drawBoard() {
	        System.out.println("-------------");
	        for (int i = 0; i < 3; i++) {
	            System.out.print("| ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(board[i][j] + " | ");
	            }
	            System.out.println();
	            System.out.println("-------------");
	        }
	    }

	    
	    public boolean checkWinner() {
	        return (checkRows() || checkColumns() || checkDiagonals());
	    }

	    
	    private boolean checkRows() {
	        for (int i = 0; i < 3; i++) {
	            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
	                return true;
	            }
	        }
	        return false;
	    }

	   
	    private boolean checkColumns() {
	        for (int i = 0; i < 3; i++) {
	            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
	                return true;
	            }
	        }
	        return false;
	    }

	   
	    private boolean checkDiagonals() {
	        return (checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0]));
	    }

	   
	    private boolean checkRowCol(char c1, char c2, char c3) {
	        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
	    }

	   
	    public void switchPlayer() {
	        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	    }

	   
	    public void playerMove(int row, int col) {
	        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
	            board[row][col] = currentPlayer;
	            switchPlayer();
	        } else {
	            System.out.println("Invalid move. Try again.");
	        }
	    }

	    public static void main(String[] args) {
	    	 TicToe_39 game = new  TicToe_39();
	        Scanner scanner = new Scanner(System.in);
	        int row, col;

	       
	        while (!game.checkWinner()) {
	            game.drawBoard();
	            System.out.println("Player " + game.currentPlayer + ", enter your move (row [0-2] column [0-2]): ");
	            row = scanner.nextInt();
	            col = scanner.nextInt();
	            game.playerMove(row, col);
	        }

	        
	        game.drawBoard();
	        game.switchPlayer();
	        System.out.println("Player " + game.currentPlayer + " wins!");
	        scanner.close();
	    }
	}
