package Model;

import java.awt.*;
/**
 * This class represents a Piece type Scout
 * @author Zafeiris
 */
public class Scout extends SpecialMovablePiece{
    public Scout(Color col) {
        super(2, "Scout", 2, true, col);
    }

    @Override
    public Piece[][] move(Piece k, Piece[][] o, int x, int y, int[][] gree, int turn) {
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 10; j++) {
                    if(o[i][j] != null) {
                        if(o[y][x] == null){
                            return o;
                        }

                        if (k.getType() == o[i][j].getType() && k.getColor() == o[i][j].getColor() && o[i][j].getPlaceInTheBoardX() == x && o[i][j].getPlaceInTheBoardY() == y){
                            if(turn%2 == 0){
                                if(o[i][j].getColor() == Color.blue){
                                    return o;
                                }
                            }else if (turn%2 == 1){
                                if(o[i][j].getColor() == Color.red){
                                    return o;
                                }
                            }
                            if(o[y][x].getColor() == o[i][j].getColor()) {
                                return o;
                            }
                            if(gree[y][x] == 0){
                                return o;
                            }
                            if(o[y][x].getType() != "Empty") {
                                int winner = o[i][j].Attack(o[y][x], o[i][j]);
                                if (winner == 0) {
                                    Empty e = new Empty();
                                    o[i][j] = e;
                                    return o;
                                } else if (winner == 1) {
                                    Empty e = new Empty();
                                    o[y][x] = o[i][j];
                                    o[i][j] = e;
                                    return o;
                                } else if (winner == 2) {
                                    Empty e = new Empty();
                                    Empty e1 = new Empty();
                                    o[y][x] = e;
                                    o[i][j] = e1;
                                    return o;
                                }
                            }

                            Empty e = new Empty();
                            Piece as = o[y][x];
                            o[y][x] = o[i][j];
                            o[i][j] = as;
                        }
                    }
                }
            }
            return o;
    }
}
