package systems.singularity.cinttamobi.gui.javafx.controllers;

import javafx.embed.swing.SwingNode;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import systems.singularity.cinttamobi.gui.javafx.StageTools;
import systems.singularity.cinttamobi.gui.swing.GamePanel;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public static boolean canMove = true;
    public static TabPane mainTabPane;
    private final GamePanel panel = new GamePanel();
    private final Properties messages = new Properties();
    private final StageTools stageTools = new StageTools();
    public TabPane tabPane;
    public Tab mainTab;
    public SwingNode swingNode;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            messages.loadFromXML(getClass().getResourceAsStream("/values/messages.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stageTools.setTabPane(tabPane);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);
        mainTabPane = tabPane;

        setPane(swingNode);

        stageTools.newTab("vemCadastro", tabPane);
        stageTools.newTab("onibusCadastro", tabPane);

        mainTabPane.getSelectionModel().select(0);
    }


    public void setPane(final SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> swingNode.setContent(panel));
    }

    public void onMovement(Scene scene) {
        if(!canMove){
            return;
        }
        scene.setOnKeyPressed(event -> {
            if (tabPane.getSelectionModel().isSelected(0)) {
                switch (event.getCode()) {
                    case W:
                        panel.moveNorth();
                        break;
                    case S:
                        panel.moveSouth();
                        break;
                    case A:
                        panel.moveWest();
                        break;
                    case D:
                        panel.moveEast();
                        break;
                    case SHIFT:
                        panel.startRun();
                        break;
                }
            }
        });

        scene.setOnKeyReleased(event -> {
            if (tabPane.getSelectionModel().isSelected(0) && canMove)
                switch (event.getCode()) {
                    case W:
                        panel.stopMoving();
                        break;
                    case S:
                        panel.stopMoving();
                        break;
                    case A:
                        panel.stopMoving();
                        break;
                    case D:
                        panel.stopMoving();
                        break;
                    case SHIFT:
                        panel.stopRun();
                        break;
                }
        });
    }
}
