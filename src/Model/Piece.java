package Model;

import java.awt.*;

/**
 * Makes the Pieces that are needed to play Stratego
 * @author zafeiris
 */
public interface Piece {
    /**
     * <b>Accessor:</b>
     * <p>Post-Condition: Piece power has been returned</p>
     * returns the Piece power
     * @return int power
     */
    public int getPower();//Accessor(Returns the Power of a Card.)

    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Piece power has been set</p>
     * sets the Piece value
     */
    public void setPower();//Transformer

    /**
     * <b>Accessor:</b>
     * <p>Post-Condition: Piece type has been returned</p>
     * @return String type
     */
    public String getType();//Accessor

    /**
     * <b>Transformer:</b>
     * <p>Post-Condition: Piece power has been set</p>
     */
    public void setType();//Transformer

    /**
     * <b>Accessor:</b>
     * <p>Post-Condition: Piece place in the board X has been returned</p>
     * returns the place in the axis X for the Piece
     * @return int X
     */
    public int getPlaceInTheBoardX();//Accessor
    /**
     * <b>Transformer:</b>
     * <p>Pre-Condition: Piece place in the board X has been set</p>
     * sets the Piece place αs for the x-axis
     */
    public void setPlaceInTheBoardX(int x);//Transformer

    /**
     * <b>Accessor:</b>
     * <p>Post-Condition: Piece place in the board Y has been returned</p>
     * returns the place in the axis Υ for the Piece
     * @return int Υ
     */
    public int getPlaceInTheBoardY();//Accessor

    /**
     * <b>Transformer:</b>
     * <p>Post-Condition: Piece place in the board X has been returned</p>
     * sets the Piece place αs for the Y-axis
     */
    public void setPlaceInTheBoardY(int y);//Transformer

    /**
     * <b>Accessor:</b>
     * <p>Pre-Condition: Piece alive has been returned</p>
     * returns true if the piece is alive
     * @return boolean alive
     */
    public boolean getAlive();//Accessor

    /**
     * <b>Transformer:</b>
     * <p>Post-Condition: Piece alive has been set</p>
     * sets the Piece to be alive
     */
    public void setAlive();//Transformer

    /**
     * <b>Accessor:</b>
     * <p>Post-Condition: Piece color has been returned</p>
     * returns Blue (if the Piece is in the blue army) or Red (if the Piece is in the red army)
     * @return Color col
     */
    public Color getColor();//Accessor
    public void setColor();

    public Piece[][] move(Piece k, Piece[][] o, int x, int y, int[][] greenplaces, int turn);
    /**
     * <b>Accessor:</b>
     * <p>Post-Condition: Return 0 if the defender won 1 if the attacker won or 2 if none won</p>
     * @return 0 - 1 -2
     */
    public int Attack(Piece piece0, Piece piece1);

}
