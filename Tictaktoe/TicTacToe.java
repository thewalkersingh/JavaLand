package week_3.b_OOPS_IV.Tictaktoe;

import java.util.Scanner;

public class TicTacToe {
    private Player player1, player2;
    private Board board;
    private int numPlayers;

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();
    }

    public void startGame() {
        Scanner s = new Scanner(System.in);
        // take players input
        player1 = takePlayerInput(++numPlayers);
        player2 = takePlayerInput(++numPlayers);
        // checking the symbol
        while (player1.getSymbol() == player2.getSymbol()) {
            System.out.println("Symbol already taken!! \n Please enter the symbol again");
            player2.setSymbol(s.next().charAt(0));
        }
        // create the board
        board = new Board(player1.getSymbol(), player2.getSymbol());
        // play the game
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while (status == Board.INCOMPLETE || status == Board.INVALIDMOVE) {
            if (player1Turn) {
                System.out.println("Player 1 - " + player1.getName() + "'s turn");
                System.out.print("Enter x: ");
                int x = s.nextInt();
                System.out.print("Enter y: ");
                int y = s.nextInt();
                status = board.move(player1.getSymbol(), x, y);
                if (status == Board.INVALIDMOVE) {
                    System.out.println("Invalid move! Please Try again!!");
                    continue;
                }
            } else {
                System.out.println("Player 2 - " + player1.getName() + "'s turn");
                System.out.print("Enter x: ");
                int x = s.nextInt();
                System.out.print("Enter y: ");
                int y = s.nextInt();
                status = board.move(player2.getSymbol(), x, y);
                if (status == Board.INVALIDMOVE) {
                    System.out.println("Invalid move! Please Try again!!");
                    continue;
                }
            }
            player1Turn = !player1Turn;
            board.print();
        }
        if (status == Board.PLAYER1WINS) {
            System.out.println("Player 1 - " + player1.getName() + " wins !!");
        } else if (status == Board.PLAYER2WINS) {
            System.out.println("Player 2 - " + player2.getName() + " wins !!");
        } else System.out.println("It's a Draw !! ");
    }

    private Player takePlayerInput(int num) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please choose symbol form: x OR 0");
        System.out.print("Enter Player " + num + " name: ");
        String name = s.nextLine();
        System.out.print("Enter Player " + num + " symbol: ");
        char symbol = s.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;
    }
}
/*
1- player 1 wins
2- player 2 wins
3- draw
4- incomplete
5- invalid
 */
