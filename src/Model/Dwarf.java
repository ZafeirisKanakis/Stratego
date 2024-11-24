package Model;

import java.awt.*;

public class Dwarf extends SpecialMovablePiece{
    public Dwarf(Color col) {
        super(3, "Dwarf", 3, true, col);
    }

    @Override
    public int Attack(Piece piece0, Piece piece1){
        if(piece0.getType() == "Bomb"){
            return 1;
        }
        if(piece0.getPower() > piece1.getPower()){
            return 0;
        }else if(piece0.getPower() < piece1.getPower()){
            return 1;
        }
        return 2;
    }
}
