package View;

import Controller.Controller;
import Model.Board;
import Model.MovablePiece;
import Model.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Zafeiris
 */

public class GraphicUI extends JFrame {
    private JButton[] buttons = new JButton[60];
    private Image image;
    private URL imageUrl;
    private boolean pieceSelected;
    private JButton rulesButton;
    private Piece selectedpiece =null;
    private Board w = new Board();
    int[][] greenplaces = new int[8][10];
    private Piece[][] bb = w.initialize();
    private Piece[][] bb2 = bb;
    private Controller con = new Controller();

    /**
     * <b>constructor</b>: makes new window and initialize the buttons
     * <b>Post-condition</b>Creates a window
     * */

    public GraphicUI() throws IOException {
        JFrame frame = new JFrame("Stratego");
        frame.setBounds(10, 10,810,550);
        File folder = new File("C:\\Users\\zafei\\IdeaProjects\\Stratego_Phase1\\images\\bluePieces");
        File[] listOfFiles = folder.listFiles();
        w.GreenPlaces(selectedpiece);
//        for(int i = 0; i < 8; i++){
//            for(int j = 0; j < 10; j++){
//                if(bb[i][j] != null && bb[i][j].getType() != "Empty"){
////                    System.out.printf(bb[i][j].getType() + " ");
//                }
//            }
//        }
//        System.out.println();
        bb = w.getBoard();
//        for(int i = 0; i < 8; i++){
//            for(int j = 0; j < 10; j++){
//                if(bb[i][j] != null && bb[i][j].getType() != "Empty"){
//                    System.out.printf(bb[i][j].getType() + " ");
//                }
//            }
//            System.out.println();
//        }
        JPanel pn = new JPanel(){
            @Override
            public void paint(Graphics g) {
                if(con.terminateGame(bb) == true){
                    return;
                }
                boolean grayzone = false;
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 10; j++){
                        if((i == 3 && j == 2)|| (i == 3 && j == 3) || (i == 3 && j == 6) || (i == 3 && j == 7) || (i == 4 && j == 2) || (i == 4 && j == 3) || (i == 4 && j == 6) || (i == 4 && j == 7) ){
                            grayzone = true;
                        }else{
                            grayzone = false;
                        }
                        if(grayzone){
                            g.setColor(Color.yellow);
                        }else{
                            g.setColor(Color.white);
                        }
                        g.fillRect(j*80,i*64,80,64);
                        if(!grayzone) {
                            g.setColor(Color.black);
                            g.drawRect(j * 80, i * 64, 80, 64);
                        }
                    }
                }
                if(con.getTurn() % 2 == 0) {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (bb[i][j] == null) {
                                continue;
                            } else if (bb[i][j].getType() == "Empty") {
                                continue;
                            }
                            if (bb[i][j].getType() == "LavaBeast" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("lavaBeast.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Bomb" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("trapR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Dragon" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("dragonR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Dwarf" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("dwarfR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Elf" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("elfR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Flag" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("flagR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Knight" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("knightR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Mage" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("mageR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Scout" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("scoutR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Slayer" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("slayerR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Sorceress" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("sorceressR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "BeastRider" && bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("beastRiderR.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("blueHidden.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            }
                        }
                    }
                }else{
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (bb[i][j] == null) {
                                continue;
                            } else if (bb[i][j].getType() == "Empty") {
                                continue;
                            }
                            if (bb[i][j].getType() == "BeastRider" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("beastRiderB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Bomb" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("trapB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Dragon" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("dragonB.png");
                                Image modify = resizeza(img);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                                g.drawImage(modify, j * 80, i * 64, this);
                            } else if (bb[i][j].getType() == "Dwarf" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("dwarfB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Elf" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("elfB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Flag" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("flagB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Knight" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("knightB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Mage" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("mageB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Scout" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("scoutB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Slayer" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("slayerB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Sorceress" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("sorceressB.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getType() == "Yeti" && bb[i][j].getColor() == Color.blue) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("yeti.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            } else if (bb[i][j].getColor() == Color.red) {
                                Toolkit t = Toolkit.getDefaultToolkit();
                                Image img = t.getImage("redHidden.png");
                                Image modify = resizeza(img);
                                g.drawImage(modify, j * 80, i * 64, this);
                                bb[i][j].setPlaceInTheBoardX(i);
                                bb[i][j].setPlaceInTheBoardY(j);
                            }
                        }
                    }
                }
//                for(int i = 0; i < 8; i++){
//                    for(int j = 0; j < 10; j++){
//                        if(bb2[i][j] != null && bb2[i][j].getType() != "Empty"){
//                            System.out.printf(bb2[i][j].getType() + " ");
//                        }
//                    }
//                    System.out.println();
//                }
//                System.out.println("//////////////////////////////////////////////////");
//                for(int i = 0; i < 8; i++){
//                    for(int j = 0; j < 10; j++){
//                        if(bb[i][j] != null && bb[i][j].getType() != "Empty"){
//                            System.out.printf(bb[i][j].getType() + " ");
//                        }
//                    }
//                    System.out.println();
//                }
                greenplaces = w.GreenPlaces(selectedpiece);
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j< 10; j++){
                        if(greenplaces[i][j] == 1){
                            g.setColor(Color.green);
                            Graphics2D g2 = (Graphics2D) g;
                            g2.setStroke(new BasicStroke(5));
                            g2.drawRect(j * 80, i * 64, 80, 64);
                        }
                    }
                }
            }
        };
        frame.add(pn);
        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedpiece != null && selectedpiece.getType() != "Empty"){///////////////////////////////////////////////////////////////
                    for(int i = 0; i < 8; i++){
                        for(int j = 0; j < 10; j++){
                            if(bb[i][j] != null) {
                                if (selectedpiece.getType() == bb[i][j].getType() && selectedpiece.getColor() == bb[i][j].getColor() && bb[i][j].getPlaceInTheBoardX() == selectedpiece.getPlaceInTheBoardX() && bb[i][j].getPlaceInTheBoardY() == selectedpiece.getPlaceInTheBoardY()) {
                                    bb[i][j].setPlaceInTheBoardX(e.getX() / 80);
                                    bb[i][j].setPlaceInTheBoardY(e.getY() / 64);
//                                    System.out.println(bb[i][j].getType() + " " + bb[i][j].getPlaceInTheBoardX() + " " +bb[i][j].getPlaceInTheBoardY());
                                }
                            }
                        }
                    }

                    selectedpiece.setPlaceInTheBoardX(e.getX()/80);
                    selectedpiece.setPlaceInTheBoardY(e.getY()/64);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(placeToMove(e.getX(),e.getY(),bb) != null) {
//                    System.out.println(placeToMove(e.getX(), e.getY(), bb).getType());
                    selectedpiece = placeToMove(e.getX(), e.getY(), bb);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(selectedpiece != null) {
//                    System.out.println(e.getX()/80 + " " +e.getY()/64);
                    bb2 = con.copyBoard(bb);
//                    for(int i = 0; i < 8; i++){
//                        for(int j = 0; j < 10; j++){
//                            bb2[i][j] = bb[i][j];
//                            if(bb2[i][j] != null && bb2[i][j].getType() != "Empty"){
//                                System.out.printf(bb2[i][j].getType() + " ");
//                            }
//                        }
//                        System.out.println();
//                    }
//                    System.out.println();
                    bb = selectedpiece.move(selectedpiece, bb, e.getX()/80, e.getY()/64,greenplaces, con.getTurn());
                    if(con.changeTurn(bb, bb2) == 1){
                        con.setTurn(con.getTurn());
//                        System.out.println(con.getTurn());
                    }
//                    for(int i = 0; i < 8; i++){
//                        for(int j = 0; j < 10; j++){
//                            if(bb[i][j] != null && bb[i][j].getType() != "Empty"){
//                                System.out.printf(bb[i][j].getType() + " ");
//                            }
//                        }
//                        System.out.println();
//                    }
//                    System.out.println(con.changeTurn(bb, bb2));
                }
                frame.repaint();

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    /**
     * <p>Accessor</p>
     * <p>Pre-Condition: user selects a Piece</p>
     * <p>Post-Condition: returns the piece</p>
     * @param x
     * @param y
     * @param b
     * @return the Piece that the user selcts
     */
    public Piece placeToMove(int x, int y, Piece[][] b){
        int nx = x/80;
        int ny = y/64;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 10; j++){
                if(b[i][j] != null && b[i][j].getType() != "Empty"){
                    if (b[i][j].getPlaceInTheBoardX() == ny && b[i][j].getPlaceInTheBoardY() == nx) {
                        return b[i][j];
                    }
                }
            }
        }
        return null;
    }

    /**
     * <p>Transformer</p>
     * <p>Pre-Condition: The image is given</p>
     * <p>Post-Condition: The image changes size</p>
     * @param img
     * @return image
     */
    public Image resizeza(Image img){
        BufferedImage modify = new BufferedImage(80,64,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = modify.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img,0,0,80,64,null);
        g2.dispose();
        return modify;
    }

}
