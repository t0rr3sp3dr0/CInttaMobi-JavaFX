package systems.singularity.cinttamobi.gui.javafx.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.fachada.Fachada;
import systems.singularity.cinttamobi.gui.javafx.ComboBoxAutoComplete;
import systems.singularity.cinttamobi.gui.javafx.StageTools;
import systems.singularity.cinttamobi.negocio.vem.VEMComum;
import systems.singularity.cinttamobi.negocio.vem.VEMIdoso;
import systems.singularity.cinttamobi.negocio.vem.VEMInfantil;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Edjan Michiles on 02/05/2016.
 * © 2016 Singularity Systems
 */
public class VEMATMController implements Initializable {
    public Label pastLabel;
    public Label pastBallanceLabel;
    public Label futureLabel;
    public Label futureBallanceLabel;
    public ComboBox<VEM> vemComboBox;
    public TextField vemTextField;
    public Button validateButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Fachada fachada = Fachada.getInstance();

        pastLabel.setVisible(false);
        pastBallanceLabel.setVisible(false);
        futureLabel.setVisible(false);
        futureBallanceLabel.setVisible(false);

        vemComboBox.setItems(FXCollections.observableArrayList(fachada.listVEM()));
        vemComboBox.setConverter(new StringConverter<VEM>() {
            @Override
            public String toString(VEM object) {
                if (object instanceof VEMComum)
                    return String.format("%s\t- VEM Comum", object.getNumber());
                return String.format("%s\t- (%s) %s", object.getNumber(), object.getT(), object.getN());
            }

            @Override
            public VEM fromString(String string) {
                return null;
            }
        });
        vemComboBox.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        new ComboBoxAutoComplete<>(vemComboBox);

        vemTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (vemComboBox.getValue() == null) {
                    StageTools.alert(Alert.AlertType.WARNING, "", "Por favor selecione um VEM", "", true);
                    vemTextField.setText(null);
                } else {
                    if (!newValue.matches("[0-9.]+"))
                        vemTextField.setText(newValue.replaceAll("[^0-9.]+", ""));
                    else if (newValue.contains("."))
                        vemTextField.setText(newValue.substring(0, newValue.indexOf(".")) + "." + newValue.substring(newValue.indexOf("."), newValue.length()).replaceAll("\\D+", ""));
                    calculate();
                }
            }
        });

        validateButton.setOnAction(event -> {
            if (vemComboBox.getValue() == null)
                StageTools.alert(Alert.AlertType.WARNING, "", "Por favor selecione um VEM", "", true);
            else if (vemTextField.getText() == null && !vemTextField.getText().equals(""))
                StageTools.alert(Alert.AlertType.WARNING, "", "Por favor digite o valor a ser creditado", "", true);
            else {
                try {
                    fachada.creditarVEM(vemComboBox.getValue().getNumber(), Double.parseDouble(vemTextField.getText()));

                    vemComboBox.setValue(null);
                    vemTextField.setText(null);

                    StageTools.alert(Alert.AlertType.INFORMATION, "", "Crédito Executado com Sucesso", "", true);
                } catch (Exception e) {
                    StageTools.exception(e, true);
                }
            }
        });
    }

    public void calculate() {
        VEM vem = vemComboBox.getValue();
        if (vemComboBox.getValue() != null && vemTextField.getText() != null && !vemTextField.getText().equals("") && !(vem instanceof VEMInfantil) && !(vem instanceof VEMIdoso)) {
            double past = vem.getBalance();
            double price = Double.parseDouble(vemTextField.getText());
            double future = past + price;

            pastBallanceLabel.setText(String.format("R$ %.2f", past));
            futureBallanceLabel.setText(String.format("R$ %.2f", future));

            pastLabel.setVisible(true);
            pastBallanceLabel.setVisible(true);
            futureLabel.setVisible(true);
            futureBallanceLabel.setVisible(true);
        } else {
            pastLabel.setVisible(false);
            pastBallanceLabel.setVisible(false);
            futureLabel.setVisible(false);
            futureBallanceLabel.setVisible(false);
        }
    }
}
