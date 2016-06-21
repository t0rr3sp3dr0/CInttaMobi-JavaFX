package systems.singularity.cinttamobi.gui.javafx.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import systems.singularity.cinttamobi.enums.Linhas;
import systems.singularity.cinttamobi.enums.TiposVEM;
import systems.singularity.cinttamobi.fachada.Fachada;
import systems.singularity.cinttamobi.gui.javafx.AsyncCallable;
import systems.singularity.cinttamobi.gui.javafx.ComboBoxAutoComplete;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by caesa on 19/06/2016.
 */
public class OnibusCadastroController implements Initializable {

    public TableView<Onibus> onibusTableView;
    public TableColumn<Onibus, String> idOnibusTableColumn;
    public TableColumn<Onibus, TiposVEM> linhaOnibusTableColumn;
    public Button addOnibusButton;
    public Button editOnibusButton;
    public Button saveOnibusButton;
    public Button deleteOnibusButton;
    public TextField numberOnibusTextField;
    public ComboBox<Linhas> linhaOnibusComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Fachada fachada = Fachada.getInstance();

        new AsyncCallable(() -> {
            onibusTableView.setItems(FXCollections.observableArrayList(fachada.listOnibus()));
            return null;
        }).start();

        idOnibusTableColumn.setCellValueFactory(new PropertyValueFactory<Onibus, String>("number"));
        linhaOnibusTableColumn.setCellValueFactory(new PropertyValueFactory<Onibus, TiposVEM>("line"));

        SelectionModel selectionModel = onibusTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                clearFields();
            } else {
                Onibus onibus = (Onibus) newValue;
                numberOnibusTextField.setText(onibus.getNumber());
                linhaOnibusComboBox.setValue(onibus.getLine());
            }
        });

        linhaOnibusComboBox.setItems(FXCollections.observableArrayList(Linhas.values()));
        linhaOnibusComboBox.setConverter(new StringConverter<Linhas>() {
            @Override
            public String toString(Linhas object) {
                return object.toString();
            }

            @Override
            public Linhas fromString(String string) {
                return null;
            }
        });
        new ComboBoxAutoComplete<Linhas>(linhaOnibusComboBox);
    }

    private void clearFields() {
        numberOnibusTextField.setText("");
        linhaOnibusComboBox.setValue(Linhas._null);
    }
}
