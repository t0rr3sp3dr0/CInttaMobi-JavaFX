package systems.singularity.cinttamobi.gui.swing;

import javafx.scene.input.KeyCode;
import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.gui.javafx.EventsTimeline;

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
    private boolean[][] blockedTiles = new boolean[(ScaleW*4)][(ScaleH*4)];
    private int[] tilesX = new int[(ScaleW*4)];
    private int[] tilesY = new int[(ScaleH*4)];
    private int presentTileX = 4;
    private int presentTileY = 5;
    private int presentMoveVariantX = 0;
    private int presentMoveVariantY = 0;

    private Image background = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/background.png"));

    private Image southStand = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/southStand.png"));
    private Image southWalk1 = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/southWalk1.png"));
    private Image southWalk2 = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/southWalk2.png"));

    private Image northStand = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/northStand.png"));
    private Image northWalk1 = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/northWalk1.png"));
    private Image northWalk2 = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/northWalk2.png"));

    private Image westStand = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/westStand.png"));
    private Image westWalk1 = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/westWalk1.png"));
    private Image westWalk2 = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/westWalk2.png"));

    private Image eastStand = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/eastStand.png"));
    private Image eastWalk1 = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/eastWalk1.png"));
    private Image eastWalk2 = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/eastWalk2.png"));

    private Image character = southStand;


    public GamePanel() {
        super();
        this.addComponentListener(this);
        this.setPreferredSize(new Dimension(sizeW, sizeH));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, x, y, getWidth(), getHeight(), this);
        g.drawImage(character, presentMoveVariantX + tilesX[presentTileX],
                presentMoveVariantY + tilesY[presentTileY], (getWidth() / (ScaleW*8)), (getHeight() / (ScaleH*5)), this);
    }

    public void componentResized(ComponentEvent arg0) {
        Rectangle present = arg0.getComponent().getBounds();
        if (present.width <= 0 || present.height <= 0) {
            setBounds(x, y, sizeW, sizeH);
            return;
        }
        if (present.height != sizeH) {
            setBounds(x, y, present.height * ScaleW / ScaleH, present.height);
            sizeH = getHeight();
            sizeW = getWidth();
            this.setPreferredSize(new Dimension(sizeW, sizeH));
            reTile();
            if (present.width < sizeW) {
                setBounds(x, y, present.width, present.width * ScaleH / ScaleW);
            }
            return;
        }
        setBounds(x, y, present.width, present.width * ScaleH / ScaleW);
        sizeH = getHeight();
        sizeW = getWidth();
        this.setPreferredSize(new Dimension(sizeW, sizeH));
        reTile();
    }

    public void moveNorth() {
        if (presentTileY > 0) {
            if (!isMoving) {
                isMoving = true;
                EventsTimeline eventsTimeline = new EventsTimeline();
                EventsTimeline.setDelay(150/speedMultiplier);
                eventsTimeline.add(event -> {
                    character = northWalk1;
                    presentMoveVariantY -= (getHeight() / (ScaleH*4)) / 2;
                    repaint();
                });
                eventsTimeline.add(event -> {
                    character = northWalk2;
                    presentMoveVariantY -= (getHeight() / (ScaleH*4)) / 2;
                    repaint();
                });
                eventsTimeline.add(event -> {
                    character = northStand;
                    presentMoveVariantY = 0;
                    presentTileY--;
                    repaint();
                }, 100/speedMultiplier);

                eventsTimeline.play();
            }
        }
    }

    public void moveSouth() {
        if (presentTileY < tilesY.length - 1) {
            if (!isMoving) {
                isMoving = true;
                EventsTimeline eventsTimeline = new EventsTimeline();
                EventsTimeline.setDelay(150/speedMultiplier);
                eventsTimeline.add(event -> {
                    character = southWalk1;
                    presentMoveVariantY += (getHeight() / (ScaleH*4)) / 2;
                    repaint();
                });
                eventsTimeline.add(event -> {
                    character = southWalk2;
                    presentMoveVariantY += (getHeight() / (ScaleH*4)) / 2;
                    repaint();
                });
                eventsTimeline.add(event -> {
                    character = southStand;
                    presentMoveVariantY = 0;
                    presentTileY++;
                    repaint();
                }, 100/speedMultiplier);

                eventsTimeline.play();
            }
        }
    }

    public void moveWest() {
        if (presentTileX > 0) {
            if (!isMoving) {
                isMoving = true;
                EventsTimeline eventsTimeline = new EventsTimeline();
                EventsTimeline.setDelay(150/speedMultiplier);
                eventsTimeline.add(event -> {
                    character = westWalk1;
                    presentMoveVariantX -= (getHeight() / (ScaleH*4)) / 2;
                    repaint();
                });
                eventsTimeline.add(event -> {
                    character = westWalk2;
                    presentMoveVariantX -= (getHeight() / (ScaleH*4)) / 2;
                    repaint();
                });
                eventsTimeline.add(event -> {
                    character = westStand;
                    presentMoveVariantX = 0;
                    presentTileX--;
                    repaint();
                }, 100/speedMultiplier);
                eventsTimeline.play();
            }
        }
    }

    public void moveEast() {
        if (presentTileX < tilesX.length - 1) {
            if (!isMoving) {
                isMoving = true;
                EventsTimeline eventsTimeline = new EventsTimeline();
                EventsTimeline.setDelay(150/speedMultiplier);
                eventsTimeline.add(event -> {
                    character = eastWalk1;
                    presentMoveVariantX += (getHeight() / (ScaleH*4)) / 2;
                    repaint();
                });
                eventsTimeline.add(event -> {
                    character = eastWalk2;
                    presentMoveVariantX += (getHeight() / (ScaleH*4)) / 2;
                    repaint();
                });
                eventsTimeline.add(event -> {
                    character = eastStand;
                    presentMoveVariantX = 0;
                    presentTileX++;
                    repaint();
                }, 100/speedMultiplier);

                eventsTimeline.play();
            }
        }
    }

    public void startRun() {
        this.speedMultiplier = 2;
    }

    public void stopRun() {
        this.speedMultiplier = 1;
    }

    public void stopMoving(){
        isMoving = false;
    };

    private void reTile() {
        for (int i = 0; i < (ScaleW*4); i++)
            tilesX[i] = (getWidth() / (ScaleW*4)) * i;
        for (int j = 0; j < (ScaleH*4); j++)
            tilesY[j] = (getHeight() / (ScaleH*4)) * j;
    }

    public void componentShown(ComponentEvent arg0) {
    }

    public void componentHidden(ComponentEvent arg0) {
    }

    public void componentMoved(ComponentEvent arg0) {
    }
}