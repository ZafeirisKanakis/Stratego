package Model;

import java.awt.*;

public class Slayer extends SpecialMovablePiece{

    public Slayer(Color col) {
        super(1, "Slayer", 1, true, col);
    }

    @Override
    public int Attack(Piece piece0,Piece piece1){
        if(piece0.getType() == "Dragon"){
            return 1;
        }else if(piece0.getPower() >piece1.getPower()){
            return 0;
        }
        return 2;
    }
}
