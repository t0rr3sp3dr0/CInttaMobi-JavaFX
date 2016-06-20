package systems.singularity.cinttamobi.guiController;

import javafx.embed.swing.SwingNode;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import systems.singularity.cinttamobi.gui.GamePanel;
import systems.singularity.cinttamobi.negocio.gui.StageTools;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public TabPane tabPane;
    public Tab mainTab;
    public SwingNode swingNode;

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

    public void setPane(final SwingNode swingNode){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GamePanel panel = new GamePanel();
                swingNode.setContent(panel);
            }
        });
    }

}
