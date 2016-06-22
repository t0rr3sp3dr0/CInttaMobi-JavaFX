package systems.singularity.cinttamobi.gui.javafx.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.fachada.Fachada;
import systems.singularity.cinttamobi.gui.javafx.ComboBoxAutoComplete;
import systems.singularity.cinttamobi.gui.javafx.StageTools;
import systems.singularity.cinttamobi.negocio.Onibus;
import systems.singularity.cinttamobi.negocio.vem.VEMComum;
import systems.singularity.cinttamobi.negocio.vem.VEMEstudante;
import systems.singularity.cinttamobi.negocio.vem.VEMIdoso;
import systems.singularity.cinttamobi.negocio.vem.VEMInfantil;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by phts on 02/05/2016.
 * © 2016 Singularity Systems
 */
public class VEMTerminalController implements Initializable {
    public Label pastLabel;
    public Label pastBallanceLabel;
    public Label futureLabel;
    public Label futureBallanceLabel;
    public ComboBox<Onibus> onibusComboBox;
    public ComboBox<VEM> vemComboBox;
    public Button validateButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Fachada fachada = Fachada.getInstance();

        pastLabel.setVisible(false);
        pastBallanceLabel.setVisible(false);
        futureLabel.setVisible(false);
        futureBallanceLabel.setVisible(false);

        onibusComboBox.setItems(FXCollections.observableArrayList(fachada.listOnibus()));
        onibusComboBox.setConverter(new StringConverter<Onibus>() {
            @Override
            public String toString(Onibus object) {
                return String.format("%04d\t- (%04d) %s", Integer.valueOf(object.getNumber()), Integer.valueOf(object.getLine().getNumber()), object.getLine().getName());
            }

            @Override
            public Onibus fromString(String string) {
                return null;
            }
        });
        onibusComboBox.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        new ComboBoxAutoComplete<>(onibusComboBox);

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

        validateButton.setOnAction(event -> {
            if (onibusComboBox.getValue() == null)
                StageTools.alert(Alert.AlertType.WARNING, "", "Por favor selecione um Ônibus", "", true);
            else if (vemComboBox.getValue() == null)
                StageTools.alert(Alert.AlertType.WARNING, "", "Por favor selecione um VEM", "", true);
            else {
                try {
                    fachada.debitarVEM(vemComboBox.getValue().getNumber(), onibusComboBox.getValue());

                    onibusComboBox.setValue(null);
                    vemComboBox.setValue(null);

                    StageTools.alert(Alert.AlertType.INFORMATION, "", "Passagem Validada com Sucesso", "", true);
                } catch (Exception e) {
                    StageTools.exception(e, true);
                }
            }
        });
    }

    public void calculate() {
        if (onibusComboBox.getValue() != null && vemComboBox.getValue() != null) {
            VEM vem = vemComboBox.getValue();
            if (vem instanceof VEMInfantil || vem instanceof VEMIdoso) {
                pastLabel.setVisible(false);
                pastBallanceLabel.setVisible(false);
                futureLabel.setVisible(false);
                futureBallanceLabel.setVisible(false);
            } else {
                double past = vem.getBalance();

                double price = onibusComboBox.getValue().getLine().getRing().getPrice();
                if (vem instanceof VEMEstudante)
                    price /= 2;

                double future = past - price;

                pastBallanceLabel.setText(String.format("R$ %.2f", past));
                futureBallanceLabel.setText(String.format("R$ %.2f", future));

                if (future < 0)
                    futureBallanceLabel.setTextFill(Color.RED);
                else
                    futureBallanceLabel.setTextFill(Color.BLACK);

                pastLabel.setVisible(true);
                pastBallanceLabel.setVisible(true);
                futureLabel.setVisible(true);
                futureBallanceLabel.setVisible(true);
            }
        } else {
            pastLabel.setVisible(false);
            pastBallanceLabel.setVisible(false);
            futureLabel.setVisible(false);
            futureBallanceLabel.setVisible(false);
        }
    }
}
