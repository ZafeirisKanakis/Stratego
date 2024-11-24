package Model;

import Controller.Controller;
import View.GraphicUI;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
//    public static void main(String[] args) {
////        Piece Dwarf = new SpecialMovablePiece(3,"Dwarf",3,true, Color.red,1,3);
////        Player player1 = new Player ("player3");
////        Board board = new Board();
////        Controller controller = new Controller();
////        player1.setPiecesAlive(Dwarf);
////        ArrayList<Piece> redArmy = new ArrayList<>();
////        redArmy = player1.getPiecesAlive();
////        System.out.println(redArmy.get(0).getType());
//        ArrayList<Piece> dd = new ArrayList<>();
//        Player player = new Player("za");
//        dd = player.initializeTheListBlue();
//        for(int i = 0; i < dd.size(); i++) {
//            System.out.println(dd.get(i).getType()+ dd.get(i).getColor());
//        }
//        ArrayList<Piece> dd2 = new ArrayList<>();
//        Player player1 = new Player("zxa");
//        dd2 = player1.initializeTheListRed();
//        for(int i = 0; i < dd2.size(); i++) {
//            System.out.println(dd2.get(i).getType() + dd2.get(i).getColor());
//        }
//        System.out.println();
//        Board board = new Board();
//        Piece[][] k = new Piece[8][10];
//        k = board.initialize();
//        for(int i = 0; i < 8; i++){
//            for(int j = 0; j < 10; j++){
//                if(k[i][j] != null) {
//                    System.out.printf(k[i][j].getType() + " ");
//                }else{
//                    System.out.printf("null" + " ");
//                }
//            }
//            System.out.println();
//        }
//    }
    public static void main(String[] args) throws IOException {
        Board board = new Board();
        Piece[][] k = new Piece[8][10];
        k = board.initialize();
        Piece[][] a ;


        GraphicUI g = new GraphicUI();
        a = board.getBoard();
        System.out.println();
//        for(int i = 0; i < 8; i++){
//            for(int j = 0; j < 10; j++){
//                if(a[i][j] != null && a[i][j].getType() != "Empty"){
//                    System.out.printf(a[i][j].getType() + " ");
//                }
//            }
//            System.out.println();
//        }
    }
}
