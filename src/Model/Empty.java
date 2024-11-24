package Model;

import java.awt.*;

public class Empty extends ImmovablePiece{

    /**
     * Constructor.
     *
     * <b>Post-condition</b>Creates a new Immovable Piece
     *

     */
    public Empty() {
        super("Empty", -1, false, Color.gray);
    }
}
