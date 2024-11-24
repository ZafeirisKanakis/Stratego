package Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents a Board that the game takes place
 * @author Zafeiris
 */

public class Board {
    private Piece[][] board = new Piece[8][10];
    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Initialize the Board</p>
     * @return board
     */
    public Piece[][] initialize(){
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        ArrayList<Piece> army1 = new ArrayList<>();
        ArrayList<Piece> army2 = new ArrayList<>();
        army1 = player1.initializeTheListBlue();
        army2 = player2.initializeTheListRed();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 10; j++){
                int ranplace = (int)(Math.random() * army1.size());
                board[i][j] = army1.get(ranplace);
                board[i][j].setPlaceInTheBoardX(i);
                board[i][j].setPlaceInTheBoardY(j);
                army1.remove(ranplace);
            }
        }
        for(int i = 3; i < 5; i++){
            for(int j = 0; j < 10; j++){
                if(j == 2 || j == 3 || j == 6 || j == 7){
                    board[i][j] = null;
                }else {
                    Empty empty = new Empty();
                    board[i][j] = empty;
                }
            }
        }
        for(int i = 5; i < 8;i++){
            for(int j = 0; j < 10; j++){
                int ranplace = (int)(Math.random() * army2.size());
                board[i][j] = army2.get(ranplace);
                board[i][j].setPlaceInTheBoardX(i);
                board[i][j].setPlaceInTheBoardY(j);
                army2.remove(ranplace);
            }
        }
        return board;
    }

    /**
     * <b>Accessor</b>
     * <p>Post-Condition: Gets the board</p>
     * @return board
     */
    public Piece[][] getBoard(){
        return board;
    }
    /**
     * <b>Transformer</b>
     * <p>Post-Condition: Sets the Board</p>
     */
    public void setBoard(Piece[][] b, Piece a, int x, int y){

    }

    /**
     * <b>Accessor</b>
     * <p>Post-Condition: Checks where the piece can move</p>
     * @return placesCanMove
     * @param ad
     */
    public int[][] GreenPlaces(Piece ad){
        int[][] placesCanMove = new int[8][10];
        int x, y;

        for(int i = 0; i < 8;i++) {
            for (int j = 0; j < 10; j++) {
                placesCanMove[i][j] = 0;
            }
        }
        if (ad == null){
            return placesCanMove;
        }
        if(ad.getType() == "Bomb" || ad.getType() == "Flag"){
            return placesCanMove;
        }
        x = ad.getPlaceInTheBoardX();
        y = ad.getPlaceInTheBoardY();
        if(x > 7 || y > 9){
            return placesCanMove;
        }
        if(ad.getType() == "Scout"){
            if(x != 7) {
                for (int i = x + 1; x < 7; i++) {
                    if (board[i][y] == null) break;
                    if(board[i][y].getType() != "Empty") {
                        if (board[i][y].getColor() == ad.getColor()) break;
                        if(board[i][y].getColor() != ad.getColor()){
                            placesCanMove[i][y] = 1;
                            break;
                        }
                    }
                    placesCanMove[i][y] = 1;
                }
            }
            if(x != 0) {
                for (int i = x - 1; i > 0; i--) {
                    if (board[i][y] == null) break;
                    if(board[i][y].getType() != "Empty") {
                        if (board[i][y].getColor() == ad.getColor()) break;
                        if(board[i][y].getColor() != ad.getColor()){
                            placesCanMove[i][y] = 1;
                            break;
                        }
                    }
                    placesCanMove[i][y] = 1;
                }
            }
            if(y != 9){
                for(int j = y + 1; j < 10; j++){
                    if (board[x][j] == null) break;
                    if(board[x][j].getType() != "Empty") {
                        if (board[x][j].getColor() == ad.getColor()) break;
                        if(board[x][j].getColor() != ad.getColor()){
                            placesCanMove[x][j] = 1;
                            break;
                        }
                    }
                    placesCanMove[x][j] = 1;
                }

            }
            if(y != 0){
                for(int j = y - 1; j > 0; j--){
                    if (board[x][j] == null) break;
                    if(board[x][j].getType() != "Empty") {
                        if (board[x][j].getColor() == ad.getColor()) break;
                        if(board[x][j].getColor() != ad.getColor()){
                            placesCanMove[x][j] = 1;
                            break;
                        }
                    }
                    placesCanMove[x][j] = 1;
                }

            }

            return placesCanMove;
        }

        if(x != 0 && y < 10){
            if(board[x-1][y] != null){
                if (board[x-1][y].getColor() != ad.getColor()){
                    placesCanMove[x-1][y] = 1;
                }
            }
        }
        if(y != 9 && x < 8) {
            if (board[x][y + 1] != null) {
                if(board[x][y + 1].getColor() != ad.getColor()){
                    placesCanMove[x][y + 1] = 1;
                }
            }
        }
        if(y != 0 && x < 8){
            if(board[x][y -1] != null){
                if(board[x][y - 1].getColor() != ad.getColor()){
                    placesCanMove[x][y - 1] = 1;
                }
            }
        }
        if(x != 7 && y < 10 && x < 8){
            if(board[x + 1][y] != null){
                if(board[x + 1][y].getColor() !=ad.getColor()) {
                    placesCanMove[x + 1][y] = 1;
                }
            }
        }
        return placesCanMove;
    }
}
