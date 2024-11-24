package Model;

import java.awt.*;
import java.util.ArrayList;
/**
 * This class represents a player that plays the game Stratego
 * @author Zafeiris
 */
public class Player {
    private ArrayList<Piece> piecesAlive = new ArrayList<>();
    private ArrayList<Piece> piecesCaptured = new ArrayList<>();
    private String name;
    private double winPercentage = 0;
    private int revives = 0;

    /**
     * Constructor.
     *
     * <b>Post-condition</b>Creates a new Player
     *
     * @param name
     */

    public Player(String name){
        this.name = name;
    }

    /**
     * <b>Transformer:</b>
     * <p>Post-Condition: Updates the Army</p>
     */
    public ArrayList<Piece> updateArmy(){
        return piecesAlive;
    }

    /**
     * <b>Accessor</b>
     * <p>Post-Condition: return the win percentage</p>
     * @return double winPercentage
     */
    public double getWinPercentage(){
        return winPercentage;
    }//

    /**
     * <b>Transformer:</b>
     * <p>Post-Condition: Sets the Win Percentage</p>
     */
    public void setWinPercentage(){
        winPercentage = this.getWinPercentage();
    }//

    /**
     * <b>Accessor</b>
     * <p>Post-Condition: Returns the number of the revives</p>
     */
    public int getRevives(){
        return revives;
    }//

    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Sets the number the revives</p>
     */
    public void setRevives(){
        revives = this.getRevives();
    }//

    /**
     * <b>Accessor</b>
     * <p>Post-Condition: returns the list with the alive pieces</p>
     * @return ArrayList<Piece> piecesAlive</Piece>
     */
    public ArrayList<Piece> getPiecesAlive() {
        return piecesAlive;
    }//

    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Sets the Pieces alive</p>
     * @param deadPiece
     */
    public void setPiecesAlive(Piece deadPiece){//
        this.piecesAlive.remove(deadPiece);
    }
    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Put all the Red Pieces in the list</p>
     * @return piecesAlive
     */
    public ArrayList<Piece> initializeTheListRed(){//
        Dwarf dwarf = new Dwarf(Color.red);
        Dwarf dwarf1 = new Dwarf(Color.red);
        Dwarf dwarf2 = new Dwarf(Color.red);
        Dwarf dwarf3 = new Dwarf(Color.red);
        Dwarf dwarf4 = new Dwarf(Color.red);
        piecesAlive.add(dwarf);
        piecesAlive.add(dwarf1);
        piecesAlive.add(dwarf2);
        piecesAlive.add(dwarf3);
        piecesAlive.add(dwarf4);

        Slayer slayer = new Slayer(Color.red);
        piecesAlive.add(slayer);

        Scout scout = new Scout(Color.red);
        Scout scout1 = new Scout(Color.red);
        Scout scout2 = new Scout(Color.red);
        Scout scout3 = new Scout(Color.red);
        piecesAlive.add(scout);
        piecesAlive.add(scout1);
        piecesAlive.add(scout2);
        piecesAlive.add(scout3);

        Elf elf = new Elf(Color.red);
        Elf elf1 = new Elf(Color.red);
        piecesAlive.add(elf);
        piecesAlive.add(elf1);

        LavaBeast lavaBeast = new LavaBeast(Color.red);
        LavaBeast lavaBeast1 = new LavaBeast(Color.red);
        piecesAlive.add(lavaBeast);
        piecesAlive.add(lavaBeast1);

        Sorceress sorceress = new Sorceress(Color.red);
        Sorceress sorceress1 = new Sorceress(Color.red);
        piecesAlive.add(sorceress);
        piecesAlive.add(sorceress1);

        BeastRider beastRider = new BeastRider(Color.red);
        BeastRider beastRider1 = new BeastRider(Color.red);
        BeastRider beastRider2 = new BeastRider(Color.red);
        piecesAlive.add(beastRider);
        piecesAlive.add(beastRider1);
        piecesAlive.add(beastRider2);

        Knight knight = new Knight(Color.red);
        Knight knight1 = new Knight(Color.red);
        piecesAlive.add(knight);
        piecesAlive.add(knight1);

        Mage mage = new Mage(Color.red);
        piecesAlive.add(mage);

        Dragon dragon = new Dragon(Color.red);
        piecesAlive.add(dragon);

        Bomb bomb = new Bomb(Color.red);
        Bomb bomb1 = new Bomb(Color.red);
        Bomb bomb2 = new Bomb(Color.red);
        Bomb bomb3 = new Bomb(Color.red);
        Bomb bomb4 = new Bomb(Color.red);
        Bomb bomb5= new Bomb(Color.red);
        piecesAlive.add(bomb);
        piecesAlive.add(bomb1);
        piecesAlive.add(bomb2);
        piecesAlive.add(bomb3);
        piecesAlive.add(bomb4);
        piecesAlive.add(bomb5);

        Flag flag = new Flag(Color.red);
        piecesAlive.add(flag);

        return piecesAlive;

    }
    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Put all the Blue Pieces in the list</p>
     * @return piecesAlive
     */
    public ArrayList<Piece> initializeTheListBlue(){//
        Dwarf dwarf = new Dwarf(Color.blue);
        Dwarf dwarf1 = new Dwarf(Color.blue);
        Dwarf dwarf2 = new Dwarf(Color.blue);
        Dwarf dwarf3 = new Dwarf(Color.blue);
        Dwarf dwarf4 = new Dwarf(Color.blue);
        piecesAlive.add(dwarf);
        piecesAlive.add(dwarf1);
        piecesAlive.add(dwarf2);
        piecesAlive.add(dwarf3);
        piecesAlive.add(dwarf4);

        Slayer slayer = new Slayer(Color.blue);
        piecesAlive.add(slayer);

        Scout scout = new Scout(Color.blue);
        Scout scout1 = new Scout(Color.blue);
        Scout scout2= new Scout(Color.blue);
        Scout scout3 = new Scout(Color.blue);
        piecesAlive.add(scout);
        piecesAlive.add(scout1);
        piecesAlive.add(scout2);
        piecesAlive.add(scout3);

        Elf elf = new Elf(Color.blue);
        Elf elf2 = new Elf(Color.blue);
        piecesAlive.add(elf);
        piecesAlive.add(elf2);

        Yeti yeti = new Yeti(Color.blue);
        Yeti yeti1 = new Yeti(Color.blue);
        piecesAlive.add(yeti);
        piecesAlive.add(yeti1);

        Sorceress sorceress = new Sorceress(Color.blue);
        Sorceress sorceress1 = new Sorceress(Color.blue);
        piecesAlive.add(sorceress);
        piecesAlive.add(sorceress1);

        BeastRider beastRider = new BeastRider(Color.blue);
        BeastRider beastRider1 = new BeastRider(Color.blue);
        BeastRider beastRider2 = new BeastRider(Color.blue);
        piecesAlive.add(beastRider);
        piecesAlive.add(beastRider1);
        piecesAlive.add(beastRider2);

        Knight knight = new Knight(Color.blue);
        Knight knight1 = new Knight(Color.blue);
        piecesAlive.add(knight);
        piecesAlive.add(knight1);

        Mage mage = new Mage(Color.blue);
        piecesAlive.add(mage);

        Dragon dragon = new Dragon(Color.blue);
        piecesAlive.add(dragon);

        Bomb bomb = new Bomb(Color.blue);
        Bomb bomb1 = new Bomb(Color.blue);
        Bomb bomb2 = new Bomb(Color.blue);
        Bomb bomb3 = new Bomb(Color.blue);
        Bomb bomb4 = new Bomb(Color.blue);
        Bomb bomb5 = new Bomb(Color.blue);
        piecesAlive.add(bomb);
        piecesAlive.add(bomb1);
        piecesAlive.add(bomb2);
        piecesAlive.add(bomb3);
        piecesAlive.add(bomb4);
        piecesAlive.add(bomb5);

        Flag flag = new Flag(Color.blue);
        piecesAlive.add(flag);
        return piecesAlive;
    }

    /**
     * <b>Accessor</b>
     * <p>Post-Condition: Returns the pieces captured</p>
     * @return piecesCaptured
     */
    public ArrayList<Piece> getPiecesCaptured() {
        return piecesCaptured;
    }//

    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Sets the captures Pieces</p>
     * @param capturedPiece
     * @return piecesAlive
     */
    public void setPiecesCaptured(Piece capturedPiece){
        this.piecesCaptured.add(capturedPiece);
    }//
}
