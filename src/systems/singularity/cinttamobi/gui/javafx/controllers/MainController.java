package systems.singularity.cinttamobi.gui.javafx.controllers;

import javafx.embed.swing.SwingNode;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import systems.singularity.cinttamobi.gui.swing.GamePanel;
import systems.singularity.cinttamobi.gui.javafx.StageTools;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public TabPane tabPane;
    public Tab mainTab;
    public SwingNode swingNode;

    private GamePanel panel = new GamePanel();
    private Properties messages = new Properties();
    private StageTools stageTools = new StageTools();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            messages.loadFromXML(getClass().getResourceAsStream("/values/messages.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stageTools.setTabPane(tabPane);

        setPane(swingNode);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);

        stageTools.newTab("vemCadastro", tabPane);
        stageTools.newTab("onibusCadastro", tabPane);
    }

    public void setPane(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingNode.setContent(panel);
            }
        });
    }

    public void onMovement(Scene scene) {
        scene.setOnKeyPressed(event -> {
            if(tabPane.getSelectionModel().isSelected(0)) {
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
            if(tabPane.getSelectionModel().isSelected(0))
                if (event.getCode() == KeyCode.SHIFT)
                    panel.stopRun();
        });
    }
}
