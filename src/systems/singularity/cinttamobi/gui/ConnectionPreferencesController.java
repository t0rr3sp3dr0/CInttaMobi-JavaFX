package systems.singularity.cinttamobi.gui;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by caesa on 02/05/2016.
 * © 2016 Singularity Systems
 */
public class ConnectionPreferencesController implements Initializable {
    public TextField domainTextField;
    public TextField portTextField;
    public TextField userTextField;
    public PasswordField passwordPasswordField;
    public TextField databaseTextField;
    public Button commitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
