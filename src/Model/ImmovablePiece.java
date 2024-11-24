package Model;

import java.awt.*;
/**
 * This class represents an Immovable Piece
 * @author Zafeiris
 */

public class ImmovablePiece implements Piece{
    private int power;
    private Color col;
    private boolean alive;
    private int placeInTheBoardX;
    private int placeInTheBoardY;
    private String type;
    /**
     * Constructor.
     *
     * <b>Post-condition</b>Creates a new Immovable Piece
     *
     * @param col
     * @param power
     * @param alive
     * @param col

     */
    ImmovablePiece(String type, int power, boolean alive, Color col){
        this.type = type;
        this.power = power;
        this.alive = alive;
        this.col = col;
    }


    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public void setPower() {
        power = this.power;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType() {

    }

    @Override
    public int getPlaceInTheBoardX() {
        return placeInTheBoardX;
    }

    @Override
    public void setPlaceInTheBoardX(int x) {
        placeInTheBoardX = x;
    }

    @Override
    public int getPlaceInTheBoardY() {
        return placeInTheBoardY;
    }

    @Override
    public void setPlaceInTheBoardY(int y) {
        placeInTheBoardY = y;
    }

    @Override
    public boolean getAlive() {
        return alive;
    }

    @Override
    public void setAlive() {
        alive = this.getAlive();
    }

    @Override
    public Color getColor() {
        return col;
    }

    @Override
    public Piece[][] move(Piece k, Piece[][] o, int x, int y, int[][] greenplaces, int turn) {
        return o;
    }

    @Override
    public int Attack(Piece piece0, Piece piece1) {
        return 6;
    }

    @Override
    public void setColor() {
        col = this.getColor();
    }
}
