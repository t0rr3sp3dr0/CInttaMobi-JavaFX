package systems.singularity.cinttamobi.gui.swing;

import javafx.scene.input.KeyCode;
import systems.singularity.cinttamobi.Programa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

/**
 * Created by lvrma on 20/06/16.
 */
public class GamePanel extends JPanel implements ComponentListener {

    private int sizeW = 800;
    private int sizeH = 600;
    private int x = 0;
    private int y = 0;
    private int ScaleW = 4;
    private int ScaleH = 3;
    private int speedMultiplier = 1;
    private boolean isMoving = false;
    private boolean[][] blockedTiles = new boolean[8][6];
    private int[] tilesX = new int[8];
    private int[] tilesY = new int[6];
    private int presentTileX = 0;
    private int presentTileY = 0;
    private int presentMoveVariantX = 0;
    private int presentMoveVariantY = 0;

    private Image background = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/logo.png"));

    private Image character = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/small.png"));

    public GamePanel(){
        super();
        this.addComponentListener(this);
        this.setPreferredSize(new Dimension(sizeW, sizeH));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, x, y, getWidth(), getHeight(), this);
        g.drawImage(character, presentMoveVariantX + tilesX[presentTileX],
                presentMoveVariantY + tilesY[presentTileY], (getWidth()/8), (getHeight()/6), this);
    }

    public void componentResized(ComponentEvent arg0) {
        Rectangle present = arg0.getComponent().getBounds();
        if(present.width <= 0 || present.height <= 0){
            setBounds(x, y, sizeW, sizeH);
            return;
        }
        if(present.height != sizeH){
            setBounds(x, y, present.height*ScaleW/ScaleH, present.height);
            sizeH = getHeight();
            sizeW = getWidth();
            this.setPreferredSize(new Dimension(sizeW, sizeH));
            reTile();
            if(present.width < sizeW){
                setBounds(x, y, present.width, present.width*ScaleH/ScaleW);
            }
            return;
        }
        setBounds(x, y, present.width, present.width*ScaleH/ScaleW);
        sizeH = getHeight();
        sizeW = getWidth();
        this.setPreferredSize(new Dimension(sizeW, sizeH));
        reTile();
    }

    public void moveNorth(){
        if(!isMoving) {
            isMoving = true;
            System.out.println("Move North");
            if (presentTileY > 0)
                presentTileY--;
            System.out.println(presentTileX + " , " + presentTileY);
            repaint();
            isMoving = false;
        }
    }

    public void moveSouth(){
        if(!isMoving) {
            isMoving = true;
            System.out.println("Move South");
            if (presentTileY < tilesY.length - 1)
                presentTileY++;
            System.out.println(presentTileX + " , " + presentTileY);
            repaint();
            isMoving = false;
        }
    }

    public void moveWest(){
        if(!isMoving) {
            isMoving = true;
            System.out.println("Move West");
            if (presentTileX > 0)
                presentTileX--;
            System.out.println(presentTileX + " , " + presentTileY);
            repaint();
            isMoving = false;
        }
    }

    public void moveEast(){
        if(!isMoving) {
            isMoving = true;
            System.out.println("Move East");
            if (presentTileX < tilesX.length - 1)
                presentTileX++;
            System.out.println(presentTileX + " , " + presentTileY);
            repaint();
            isMoving = false;
        }
    }

    public void startRun(){
        this.speedMultiplier = 2;
    }

    public void stopRun(){
        this.speedMultiplier = 1;
    }

    private void reTile(){
        for (int i = 0; i < 8; i++)
            tilesX[i] = (getWidth()/8)*i;
        for(int j = 0; j < 6; j++)
            tilesY[j] = (getHeight()/6)*j;
    }

    public void componentShown(ComponentEvent arg0) {}

    public void componentHidden(ComponentEvent arg0) {}

    public void componentMoved(ComponentEvent arg0) {}
}