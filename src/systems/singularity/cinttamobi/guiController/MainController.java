package systems.singularity.cinttamobi.guiController;

import javafx.embed.swing.SwingNode;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import systems.singularity.cinttamobi.negocio.gui.StageTools;

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

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);

        stageTools.newTab("vemCadastro", tabPane);
        stageTools.newTab("onibusCadastro", tabPane);
    }
}
