package systems.singularity.cinttamobi.gui;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import systems.singularity.cinttamobi.Main;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

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
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        domainTextField.setText(prefs.get("domainConnection", ""));
        portTextField.setText(prefs.get("portConnection", ""));
        userTextField.setText(prefs.get("userConnection", ""));
        passwordPasswordField.setText(prefs.get("passwordConnection", ""));
        databaseTextField.setText(prefs.get("databaseConnection", ""));

        commitButton.setOnAction(event -> {
            if (ConnectionFactory.verifyConnection(
                    domainTextField.getText(),
                    portTextField.getText(),
                    databaseTextField.getText(),
                    userTextField.getText(),
                    passwordPasswordField.getText()
            )) {
                prefs.put("domainConnection", domainTextField.getText());
                prefs.put("portConnection", portTextField.getText());
                prefs.put("userConnection", userTextField.getText());
                prefs.put("passwordConnection", passwordPasswordField.getText());
                prefs.put("databaseConnection", databaseTextField.getText());

                StageTools.alert(
                        Alert.AlertType.INFORMATION,
                        null,
                        "Connection settings committed successfully!",
                        "It might be necessary to restart the application so that the changes can be applied",
                        true
                );
            } else {
                StageTools.alert(
                        Alert.AlertType.ERROR,
                        null,
                        "Connection unsuccessful!",
                        "Please verify your connection settings and try again",
                        true
                );
            }
        });
    }
}
