package Project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SquidGame {
    private int[][] ladder;
    private int lives;
    private ArrayList<Integer> selections;

    public SquidGame(int panels, int lives) {
        this.ladder = new int[panels][2];
        this.lives = lives;
        this.selections = new ArrayList<Integer>();
        initializeLadder();
    }

    private void initializeLadder() {
        Random rand = new Random();
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < 2; j++) {
                ladder[i][j] = rand.nextInt(2);
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int currentRow = 0;
        while (currentRow < ladder.length) {
            printLadder(currentRow);
            System.out.println("Enter your selection (R/L):");
            String input = scanner.next().toLowerCase();
            if (input.equals("r") || input.equals("l")) {
                int selection = (input.equals("r")) ? 1 : 0;
                selections.add(selection);
                if (ladder[currentRow][selection] == 1) {
                    currentRow++;
                } else {
                    lives--;
                    System.out.println("You lost 1 life. Total lives: " + lives);
                    if (lives == 0) {
                        scanner.close();
                        System.out.println("YOU DIED");
                        return;
                    }
                }
            } else {
                System.out.println("Invalid selection. Please enter R or L.");
            }
        }
        printLadder(currentRow);
        scanner.close();
        System.out.println("Congrats You Won!!");
    }

    private void printLadder(int currentRow) {
        System.out.println("|||||| ---- Start");
        for (int i = 0; i <= currentRow; i++) {
            System.out.print("|");
            for (int j = 0; j < 2; j++) {
                if (i < currentRow || (i == currentRow && j <= selections.size() - 1)) {
                    System.out.print(ladder[i][j]);
                } else {
                    System.out.print("?");
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("|||||| ---- Finish");
    }

    public int getLives() {
        return lives;
    }

    public void death() {
        lives--;
    }
}