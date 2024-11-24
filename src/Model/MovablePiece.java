package Model;

import java.awt.*;
/**
 * This class represents a Movable Piece
 * @author Zafeiris
 */
public class MovablePiece extends Board implements Piece {
    private int idOfPiece;
    private String type;
    private int power;
    private boolean isAlive;
    private Color col;
    private int placeInTheBoardX = 0;
    private int placeInTheBoardY = 0;
    private Board b = new Board();
    /**
     * Constructor.
     *
     * <b>Post-condition</b>Creates a new Movable Piece
     *
     * @param col
     * @param power
     * @param isAlive
     * @param col

     */
    public MovablePiece(int idOfPiece,String type,int power, boolean isAlive, Color col){
        this.idOfPiece = idOfPiece;
        this.type = type;
        this.power = power;
        this.isAlive = isAlive;
        this.col = col;
    }


    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void setPower() {
        power = this.getPower();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType() {
        type = this.getType();
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
        return isAlive;
    }

    @Override
    public void setAlive() {
        isAlive = this.getAlive();
    }

    @Override
    public Color getColor() {
        return col;
    }

    @Override
    public void setColor() {
        col = this.getColor();
    }

    /**
     * <b>Accessor:</b>
     * <p>Post-Condition: Piece Id has been returned</p>
     * @return int IdOfPiece
     */
    public int getIdOfPiece() {
        return idOfPiece;
    }

    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Piece Id has been set</p>
     */

    public void setIdOfPiece() {
        idOfPiece = this.getIdOfPiece();
    }

    /**
     * <b>Accessor:</b>
     * <p>Post-Condition: The place that the Piece wants to move returned</p>
     * @return 1 - 0
     */

    public Piece[][] move(Piece k, Piece[][] o, int x, int y, int[][] gree, int turn){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j++) {
                if(o[i][j] != null) {

                    if(o[y][x] == null){
                        return o;
                    }

                    if (k.getType() == o[i][j].getType() && k.getColor() == o[i][j].getColor() && o[i][j].getPlaceInTheBoardX() == x && o[i][j].getPlaceInTheBoardY() == y){
                        if(o[i][j].getType() == "Yeti"){
                            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

                        }
                        if(turn%2 == 0){
                            if(o[i][j].getColor() == Color.blue){
                                return o;
                            }
                        }else if (turn%2 == 1){
                            if(o[i][j].getColor() == Color.red){
                                return o;
                            }
                        }
                        if(o[y][x] == o[i][j]){
                            return o;
                        }
                        if(o[y][x].getColor() == o[i][j].getColor()) {
                            return o;
                        }
                        if(gree[y][x] == 0){
                            return o;
                        }
                        if(o[y][x].getType() != "Empty"){
                            int winner = o[i][j].Attack(o[y][x], o[i][j]);
                            if(winner == 0){
                                Empty e = new Empty();
                                o[i][j] = e;
                                return o;
                            }else if(winner == 1){
                                Empty e = new Empty();
                                o[y][x] = o[i][j];
                                o[i][j] = e;
                                return o;
                            }else if(winner == 2){
                                Empty e = new Empty();
                                Empty e1 = new Empty();
                                o[y][x] = e;
                                o[i][j] = e1;
                                 return o;
                            }
                        }
                        Piece as = o[y][x];
                        o[y][x] = o[i][j];
                        o[i][j] = as;
                    }
                }
            }
        }
        return o;
    }

    @Override
    public int Attack(Piece piece0,Piece piece1) {
        if(piece0.getType() == "Bomb"){
            return 0;
        }
        if(piece0.getPower() > piece1.getPower()){
            return 0;
        }else if(piece0.getPower() < piece1.getPower()){
            return 1;
        }
        return 2;
    }
}

