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
import systems.singularity.cinttamobi.gui.javafx.StageTools;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by caesa on 19/06/2016.
 * © 2016 Singularity Systems
 */
public class OnibusCadastroController implements Initializable {

    public TableView<Onibus> onibusTableView;
    public TableColumn<Onibus, String> idOnibusTableColumn;
    public TableColumn<Onibus, TiposVEM> linhaOnibusTableColumn;
    public Button addOnibusButton;
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

        idOnibusTableColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        linhaOnibusTableColumn.setCellValueFactory(new PropertyValueFactory<>("line"));

        SelectionModel selectionModel = onibusTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                clearFields();

                deleteOnibusButton.setDisable(true);
            } else {
                deleteOnibusButton.setDisable(false);

                numberOnibusTextField.setDisable(true);

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
        new ComboBoxAutoComplete<>(linhaOnibusComboBox);

        addOnibusButton.setOnAction(event -> {
            clearFields();
            onibusTableView.setItems(FXCollections.observableArrayList(fachada.listOnibus()));
            onibusTableView.getSelectionModel().clearSelection();
        });
        saveOnibusButton.setOnAction(event -> {
            Linhas linha = linhaOnibusComboBox.getValue();

            if (numberOnibusTextField.getText().equals(""))
                StageTools.alert(Alert.AlertType.WARNING, null, "Número do Ônibus é um campo obrigatório!", null, true);
            else if (linha == null || linha == Linhas._null)
                StageTools.alert(Alert.AlertType.WARNING, null, "Linha de Ônibus é um campo obrigatório!", null, true);
            else {
                try {
                    Onibus onibus = new Onibus(numberOnibusTextField.getText(), linha);
                    if (selectionModel.getSelectedItem() != null)
                        fachada.atualizarOnibus(onibus);
                    else
                        fachada.cadastrarOnibus(onibus);

                    clearFields();
                    onibusTableView.setItems(FXCollections.observableArrayList(fachada.listOnibus()));
                    onibusTableView.getSelectionModel().clearSelection();
                } catch (Exception e) {
                    StageTools.exception(e, true);
                }
            }
        });
        deleteOnibusButton.setOnAction(event -> {
            try {
                fachada.removeOnibus((Onibus) selectionModel.getSelectedItem());
            } catch (Exception e) {
                StageTools.exception(e, true);
            }

            onibusTableView.setItems(FXCollections.observableArrayList(fachada.listOnibus()));
            onibusTableView.getSelectionModel().clearSelection();
        });
    }

    private void clearFields() {
        numberOnibusTextField.setDisable(false);

        numberOnibusTextField.setText("");
        linhaOnibusComboBox.setValue(Linhas._null);
    }
}
