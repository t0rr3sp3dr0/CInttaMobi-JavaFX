package systems.singularity.cinttamobi.gui.swing;

import javafx.scene.input.KeyCode;
import systems.singularity.cinttamobi.Programa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by lvrma on 20/06/16.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener, ComponentListener {

    private int SizeW = 800;
    private int SizeH = 600;
    private int X = 0;
    private int Y = 0;
    private int ScaleW = 4;
    private int ScaleH = 3;
    private Image background = Toolkit.getDefaultToolkit().getImage(
            Programa.class.getResource("/images/logo.png"));

    public GamePanel(){
        super();
        this.addKeyListener(this);
        this.addComponentListener(this);
        this.setPreferredSize(new Dimension(SizeW, SizeH));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    public void componentResized(ComponentEvent arg0) {
        Rectangle present = arg0.getComponent().getBounds();
        if(present.width == SizeW || present.width <= 0 || present.height <= 0 || present.height == SizeH){
            setBounds(X, Y, SizeW, SizeH);
            return;
        }
        setBounds(X, Y, present.width, present.width*ScaleH/ScaleW);
        SizeH = getHeight();
        SizeW = getWidth();
        this.setPreferredSize(new Dimension(SizeW, SizeH));
    }

    public void componentShown(ComponentEvent arg0) {}

    public void keyPressed(KeyEvent arg0) {
        System.out.println("AAAAA");
        if(arg0.getKeyCode() == KeyEvent.VK_A)
            System.out.println("Left key");
    }

    public void keyReleased(KeyEvent arg0) {}

    public void keyTyped(KeyEvent arg0) {}

    public void actionPerformed(ActionEvent arg0) {}

    public void componentHidden(ComponentEvent arg0) {}

    public void componentMoved(ComponentEvent arg0) {}
}