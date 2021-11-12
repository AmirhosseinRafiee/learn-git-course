
package TickTackToe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ticktacktoe {
    
    private HashMap <Integer , String> table = new HashMap<>();
    private Boolean turn = true;
    private String player1 = "player1";
    private String player2 = "player2";
    private Boolean gameOver = false;
    private int counter = 0;
    private Scanner scanner = new Scanner(System.in);
    
    public Ticktacktoe() {       
        initTable();
        play();       
    }
    
    private void play() {
        reName();       
        while(!gameOver) {
            drawTable();
            System.out.println(" Turn " + (turn.equals(true)?player1:player2));
            System.out.print(" Choose a cell : ");
            int cell=0;
            try {
                cell = Integer.parseInt(scanner.nextLine());
                processCellInput(cell);
                
            } catch (NumberFormatException e) {
                System.out.println("Wrong input");
            }
            processTable();
        }      
    }
    
    private void processTable() {
        if(counter<5)
            return;
        boolean win = false;
        if((table.get(1).equals(table.get(2))) && table.get(1).equals(table.get(3)))
            win = true;
        else if((table.get(1).equals(table.get(4))) && table.get(1).equals(table.get(7)))
                win = true;
        else if((table.get(1).equals(table.get(5))) && table.get(1).equals(table.get(9)))
                win = true;
        else if((table.get(2).equals(table.get(5))) && table.get(2).equals(table.get(8)))
                win = true;
        else if((table.get(3).equals(table.get(6))) && table.get(3).equals(table.get(9)))
                win = true;
        else if((table.get(3).equals(table.get(5))) && table.get(3).equals(table.get(7)))
                win = true;
        else if((table.get(4).equals(table.get(5))) && table.get(4).equals(table.get(6)))
                win = true;
        else if((table.get(7).equals(table.get(8))) && table.get(7).equals(table.get(9)))
                win = true;
        if(win == false) {           
            if(counter == 9) {
            drawTable();
            System.out.println(" Game Over ");
            resetGame();
            }           
            return;           
        }
        System.out.println("\n " + (turn.equals(true) ? player2 : player1) + " is winner");
        resetGame();      
    }
    
    private void resetGame() {    
        initTable();
        turn = true;
        System.out.println("\n New Game ");        
    }
    // set players name
    private void reName() {
        if((player1.equals("player1")) || (player2.equals("player2"))) {
            String name = "";
            System.out.print("Please enter player 1 name : ");
            name = scanner.nextLine();
            //player1 = scanner.nextLine();
            if(name.equals(""))
                player1 = "Player1";
            else    
                player1 = name;                       
            System.out.print("Please enter player 2 name : ");
            name = scanner.nextLine();
            //player2 = scanner.nextLine();
            if(name.equals(""))
                player2 = "Player2";
            else    
                player2 = name; 
        }
    }
    // check and process input
    private void processCellInput(int cell) {
        if((cell<1) || (cell>9)) {
            System.out.println("Wrong input <1 or >9 ");
            return;
        }
        else {
            try {
                Integer.parseInt(table.get(cell));
            } catch (Exception e) {
                System.out.println("Cell already in use ");
                return;
            }
        }
        table.replace(cell, (turn.equals(true)?"X":"Y"));
        turn = turn.equals(true) ? false : true;
        counter++;
    }
    
    private void initTable() {
        table.put(1 , "1");
        table.put(2 , "2");
        table.put(3 , "3");
        table.put(4 , "4");
        table.put(5 , "5");
        table.put(6 , "6");
        table.put(7 , "7");
        table.put(8 , "8");
        table.put(9 , "9");       
    }
    
    private void drawTable() {
        System.out.println();
        for(Map.Entry<Integer , String> entry : table.entrySet()) {           
            System.out.print("\t" + entry.getValue() + "\t");
            if(entry.getKey() % 3 == 0) 
                System.out.println("\n");
        }  
    }
  
}
