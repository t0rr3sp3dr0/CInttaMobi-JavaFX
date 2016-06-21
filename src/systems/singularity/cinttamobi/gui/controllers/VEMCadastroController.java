package systems.singularity.cinttamobi.gui.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.enums.TiposVEM;
import systems.singularity.cinttamobi.fachada.Fachada;
import systems.singularity.cinttamobi.negocio.gui.AsyncCallable;
import systems.singularity.cinttamobi.negocio.gui.ComboBoxAutoComplete;
import systems.singularity.cinttamobi.negocio.pessoas.Estudante;
import systems.singularity.cinttamobi.negocio.pessoas.Trabalhador;

import java.net.URL;
import java.time.ZoneId;
import java.util.ResourceBundle;

/**
 * Created by phts on 02/05/2016.
 * © 2016 Singularity Systems
 */
public class VEMCadastroController implements Initializable {
    public TableView<VEM> vemTableView;
    public TableColumn<VEM, String> numberVEMTableColumn;
    public TableColumn<VEM, TiposVEM> typeVEMTableColumn;
    public TableColumn<VEM, String> ownerNameTableColumn;
    public TableColumn<VEM, String> ownerCPFTableColumn;
    public Button addVEMButton;
    public Button editVEMButton;
    public Button saveVEMButton;
    public Button deleteVEMButton;
    public TextField numberVEMTextField;
    public ComboBox<TiposVEM> typeVEMComboBox;
    public TextField ownerNameTextField;
    public DatePicker ownerBirthDatePicker;
    public TextField ownerCPFTextField;
    public TextField ownerExtraTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Fachada fachada = Fachada.getInstance();

        new AsyncCallable(() -> {
            vemTableView.setItems(FXCollections.observableArrayList(fachada.listVEM()));
            return null;
        }).start();

        numberVEMTableColumn.setCellValueFactory(new PropertyValueFactory<VEM, String>("number"));
        typeVEMTableColumn.setCellValueFactory(new PropertyValueFactory<VEM, TiposVEM>("t"));
        ownerNameTableColumn.setCellValueFactory(new PropertyValueFactory<VEM, String>("n"));
        ownerCPFTableColumn.setCellValueFactory(new PropertyValueFactory<VEM, String>("c"));

        SelectionModel selectionModel = vemTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                clearFieldsContatos();

                ownerNameTextField.setVisible(false);
                ownerBirthDatePicker.setVisible(false);
                ownerCPFTextField.setVisible(false);
                ownerExtraTextField.setVisible(false);
            } else {
                VEM vem = (VEM) newValue;
                numberVEMTextField.setText(vem.getNumber());
                TiposVEM tipoVEM = TiposVEM.valueOf(vem.getT().equals("") ? "_null" : vem.getT());
                typeVEMComboBox.setValue(tipoVEM);
                if (tipoVEM != TiposVEM.Comum) {
                    ownerNameTextField.setText(vem.getPerson().getName());
                    ownerBirthDatePicker.setValue(vem.getPerson().getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    ownerCPFTextField.setText(vem.getPerson().getCPF());

                    ownerNameTextField.setVisible(true);
                    ownerBirthDatePicker.setVisible(true);
                    ownerCPFTextField.setVisible(true);
                    if (tipoVEM == TiposVEM.Estudante) {
                        ownerExtraTextField.setText(((Estudante) vem.getPerson()).getStudentID());
                        ownerExtraTextField.setVisible(true);
                    } else if (tipoVEM == TiposVEM.Trabalhador) {
                        ownerExtraTextField.setText(((Trabalhador) vem.getPerson()).getNIS());
                        ownerExtraTextField.setVisible(true);
                    } else {
                        ownerExtraTextField.setVisible(false);
                    }
                } else {
                    ownerNameTextField.setVisible(false);
                    ownerBirthDatePicker.setVisible(false);
                    ownerCPFTextField.setVisible(false);
                }
            }
        });

        typeVEMComboBox.setItems(FXCollections.observableArrayList(TiposVEM.values()));
        typeVEMComboBox.setConverter(new StringConverter<TiposVEM>() {
            @Override
            public String toString(TiposVEM object) {
                return object.toString();
            }

            @Override
            public TiposVEM fromString(String string) {
                return null;
            }
        });
        new ComboBoxAutoComplete<TiposVEM>(typeVEMComboBox);

        SelectionModel selectionModel1 = typeVEMComboBox.getSelectionModel();
        selectionModel1.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == TiposVEM._null || newValue == TiposVEM.Comum) {
                ownerNameTextField.setVisible(false);
                ownerBirthDatePicker.setVisible(false);
                ownerCPFTextField.setVisible(false);
                ownerExtraTextField.setVisible(false);
            } else if (newValue == TiposVEM.Estudante || newValue == TiposVEM.Trabalhador) {
                ownerNameTextField.setVisible(true);
                ownerBirthDatePicker.setVisible(true);
                ownerCPFTextField.setVisible(true);
                ownerExtraTextField.setVisible(true);
            } else {
                ownerNameTextField.setVisible(true);
                ownerBirthDatePicker.setVisible(true);
                ownerCPFTextField.setVisible(true);
                ownerExtraTextField.setVisible(false);
            }
        });
    }

    private void clearFieldsContatos() {
        numberVEMTextField.setText("");
        typeVEMComboBox.setValue(TiposVEM._null);
        ownerNameTextField.setText("");
        ownerBirthDatePicker.setValue(null);
        ownerCPFTextField.setText("");
        ownerExtraTextField.setText("");
    }
}
