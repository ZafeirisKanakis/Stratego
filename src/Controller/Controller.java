package Controller;

import Model.*;

import java.awt.*;


/**
 * This class is the Mind the game and controls all the actions that the Player does
 * @author Zafeiris
 */
public class Controller {
    private Player player1, player2;
    private Board board = new Board();
    private Piece[][] pieces = new Piece[8][10];
    private int turn = 0;

    /**
     * <b>constructor</b>: Constructs a new game and (initialize the board, makes the arraylists for the Players...)
     * <b>Post-condition</b>Creates a new Movable Piece
     */
    public Controller(){
        player1 = new Player("player1");
        player2 = new Player("player2");
        player1.initializeTheListBlue();
        player2.initializeTheListRed();
        board.initialize();

    }

    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Returns the board changed</p>
     * @return board
     */
    public Board changeBoard(){
        pieces = board.getBoard();
//        board.setBoard();
        return board;
    }

    /**
     * <b>Accessor</b>
     * @return turn
     */
    public int getTurn(){
        return turn;
    }

    /**
     *
     * <b>Transformer</b>
     * <p>Pre-Condition: The changeaTurn has to return 1</p>
     * <p>Post-Condition: Changes the turn</p>
     * @param add
     */
    public void setTurn(int add){turn = add + 1;
    }

    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Changes the turn</p>
     * @return 1 if you can change turn 0 if not
     */
    //if turn%2 == 1 then player2 is playing otherwise player1 is playing
    public int changeTurn(Piece[][] b1, Piece[][] b2){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j++){
                if(b2[i][j] != null && b2[i][j].getType() != "Empty"){
                    System.out.printf(b2[i][j].getType() + " ");
                }
            }
            System.out.println();
        }
        System.out.println("//////////////////////////////////////////////////");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j++){
                if(b1[i][j] != null && b1[i][j].getType() != "Empty"){
                    System.out.printf(b1[i][j].getType() + " ");
                }
            }
            System.out.println();
        }
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j++){
                if(b1[i][j] != null && b2[i][j] != null){
                    if(b1[i][j].getType() != b2[i][j].getType()){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * <p>Transformer</p>
     * <p>Pre-Condition: There is a board that needs to get copied</p>
     * @param bb
     * @return the copy of the Board
     */

    public Piece[][] copyBoard(Piece[][] bb){
        Piece[][] b = new Piece[8][10];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j++){
                if(bb[i][j] == null){
                    b[i][j] = null;
                }else if (bb[i][j].getType() == "LavaBeast" && bb[i][j].getColor() == Color.red) {
                    LavaBeast lavaBeast = new LavaBeast(Color.red);
                    b[i][j] = lavaBeast;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Bomb" && bb[i][j].getColor() == Color.red) {
                    Bomb bomb = new Bomb(Color.red);
                    b[i][j] = bomb;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Dragon" && bb[i][j].getColor() == Color.red) {
                    Dragon dragon = new Dragon(Color.red);
                    b[i][j] = dragon;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Dwarf" && bb[i][j].getColor() == Color.red) {
                    Dwarf dwarf = new Dwarf(Color.red);
                    b[i][j] = dwarf;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Elf" && bb[i][j].getColor() == Color.red) {
                    Elf elf = new Elf(Color.red);
                    b[i][j] = elf;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Flag" && bb[i][j].getColor() == Color.red) {
                    Flag flag = new Flag(Color.red);
                    b[i][j] = flag;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Knight" && bb[i][j].getColor() == Color.red) {
                    Knight knight = new Knight(Color.red);
                    b[i][j] = knight;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Mage" && bb[i][j].getColor() == Color.red) {
                    Mage mage = new Mage(Color.red);
                    b[i][j] = mage;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Scout" && bb[i][j].getColor() == Color.red) {
                    Scout scout = new Scout(Color.red);
                    b[i][j] = scout;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Slayer" && bb[i][j].getColor() == Color.red) {
                    Slayer slayer = new Slayer(Color.red);
                    b[i][j] = slayer;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Sorceress" && bb[i][j].getColor() == Color.red) {
                    Sorceress sorceress = new Sorceress(Color.red);
                    b[i][j] = sorceress;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "BeastRider" && bb[i][j].getColor() == Color.red) {
                    BeastRider beastRider = new BeastRider(Color.red);
                    b[i][j] = beastRider;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Empty") {
                    Empty empty = new Empty();
                    b[i][j] = empty;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                }else if (bb[i][j].getType() == "BeastRider" && bb[i][j].getColor() == Color.blue) {
                    BeastRider beastRider = new BeastRider(Color.blue);
                    b[i][j] = beastRider;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Bomb" && bb[i][j].getColor() == Color.blue) {
                    Bomb bomb = new Bomb(Color.blue);
                    b[i][j] = bomb;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Dragon" && bb[i][j].getColor() == Color.blue) {
                    Dragon dragon = new Dragon(Color.blue);
                    b[i][j] = dragon;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Dwarf" && bb[i][j].getColor() == Color.blue) {
                    Dwarf dwarf = new Dwarf(Color.blue);
                    b[i][j] = dwarf;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Elf" && bb[i][j].getColor() == Color.blue) {
                    Elf elf = new Elf(Color.blue);
                    b[i][j] = elf;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Flag" && bb[i][j].getColor() == Color.blue) {
                    Flag flag = new Flag(Color.blue);
                    b[i][j] = flag;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Knight" && bb[i][j].getColor() == Color.blue) {
                    Knight knight = new Knight(Color.blue);
                    b[i][j] = knight;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Mage" && bb[i][j].getColor() == Color.blue) {
                    Mage mage = new Mage(Color.blue);
                    b[i][j] = mage;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Scout" && bb[i][j].getColor() == Color.blue) {
                    Scout scout = new Scout(Color.blue);
                    b[i][j] = scout;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Slayer" && bb[i][j].getColor() == Color.blue) {
                    Slayer slayer = new Slayer(Color.blue);
                    b[i][j] = slayer;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Sorceress" && bb[i][j].getColor() == Color.blue) {
                    Sorceress sorceress = new Sorceress(Color.blue);
                    b[i][j] = sorceress;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Yeti" && bb[i][j].getColor() == Color.blue) {
                    Yeti yeti =  new Yeti(Color.blue);
                    b[i][j] = yeti;
                    bb[i][j].setPlaceInTheBoardX(i);
                    bb[i][j].setPlaceInTheBoardY(j);
                } else if (bb[i][j].getType() == "Empty") {
                    Empty empty = new Empty();
                    b[i][j] = empty;
                    b[i][j].setPlaceInTheBoardX(i);
                    b[i][j].setPlaceInTheBoardY(j);
                }
            }
        }
        return b;
    }

    /**
     * <b>Accessor:</b>
     * <p>Pre-Condition; The game must be started</p>
     * @return true - false
     */
    public boolean terminateGame(Piece[][] board1) {
        int flag = 0;
        int count = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j ++){

                if(board1[i][j] != null && board1[i][j].getType() != "Empty"){
                    int[][] greenplaces = board.GreenPlaces(board1[i][j]);
                    for(int p = 0; p < 8; p++) {
                        for (int k = 0;k < 10; k++){
                            if(greenplaces[p][k] == 1){
                                count++;
                            }

                        }
                    }
                    if( board1[i][j].getType() == "Flag"){
                        flag++;
                    }
                }

            }
        }
        if(count == 0){
            return true;
        }
        if(flag != 2){
            return true;
        }
        return false;
    }
}
