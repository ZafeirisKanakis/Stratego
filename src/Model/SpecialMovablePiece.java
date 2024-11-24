package Model;

import java.awt.*;
/**
 * This class represents a Special movable piece
 * @author Zafeiris
 */
public class SpecialMovablePiece extends MovablePiece{
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
    public SpecialMovablePiece(int idOfPiece, String type, int power, boolean isAlive, Color col) {
        super(idOfPiece, type, power, isAlive, col);
    }
}
