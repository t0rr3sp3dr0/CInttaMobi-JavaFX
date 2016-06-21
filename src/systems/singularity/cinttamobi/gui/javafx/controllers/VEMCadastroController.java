package systems.singularity.cinttamobi.gui.javafx.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.enums.TiposVEM;
import systems.singularity.cinttamobi.fachada.Fachada;
import systems.singularity.cinttamobi.gui.javafx.AsyncCallable;
import systems.singularity.cinttamobi.gui.javafx.ComboBoxAutoComplete;
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
    public Label numberVEMLabel;
    public TextField numberVEMTextField;
    public Label typeVEMLabel;
    public ComboBox<TiposVEM> typeVEMComboBox;
    public Label ownerNameLabel;
    public TextField ownerNameTextField;
    public Label ownerBirthLabel;
    public DatePicker ownerBirthDatePicker;
    public Label ownerCPFLabel;
    public TextField ownerCPFTextField;
    public Label ownerExtraLabel;
    public TextField ownerExtraTextField;
    public ImageView vemImageView;

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
                clearFields();

                ownerNameTextField.setVisible(false);
                ownerNameLabel.setVisible(false);
                ownerBirthDatePicker.setVisible(false);
                ownerBirthLabel.setVisible(false);
                ownerCPFTextField.setVisible(false);
                ownerCPFLabel.setVisible(false);
                ownerExtraTextField.setVisible(false);
                ownerExtraLabel.setVisible(false);
            } else {
                VEM vem = (VEM) newValue;
                numberVEMTextField.setText(vem.getNumber());
                TiposVEM tipoVEM = vem.getT();
                typeVEMComboBox.setValue(tipoVEM);
                if (tipoVEM != TiposVEM.Comum) {
                    ownerNameTextField.setText(vem.getPerson().getName());
                    ownerBirthDatePicker.setValue(vem.getPerson().getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    ownerCPFTextField.setText(vem.getPerson().getCPF());
                    if (tipoVEM == TiposVEM.Estudante)
                        ownerExtraTextField.setText(((Estudante) vem.getPerson()).getStudentID());
                    else if (tipoVEM == TiposVEM.Trabalhador)
                        ownerExtraTextField.setText(((Trabalhador) vem.getPerson()).getNIS());
                } else {
                    ownerNameTextField.setVisible(false);
                    ownerNameLabel.setVisible(false);
                    ownerBirthDatePicker.setVisible(false);
                    ownerBirthLabel.setVisible(false);
                    ownerCPFTextField.setVisible(false);
                    ownerCPFLabel.setVisible(false);
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
        typeVEMComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == TiposVEM._null || newValue == TiposVEM.Comum) {
                ownerNameTextField.setVisible(false);
                ownerNameLabel.setVisible(false);
                ownerBirthDatePicker.setVisible(false);
                ownerBirthLabel.setVisible(false);
                ownerCPFTextField.setVisible(false);
                ownerCPFLabel.setVisible(false);
                ownerExtraTextField.setVisible(false);
                ownerExtraLabel.setVisible(false);
                if (newValue == TiposVEM.Comum)
                    vemImageView.setImage(new Image(getClass().getResourceAsStream("/images/VEMComum.png")));
                else
                    vemImageView.setImage(null);
            } else if (newValue == TiposVEM.Estudante || newValue == TiposVEM.Trabalhador) {
                ownerNameTextField.setVisible(true);
                ownerNameLabel.setVisible(true);
                ownerBirthDatePicker.setVisible(true);
                ownerBirthLabel.setVisible(true);
                ownerCPFTextField.setVisible(true);
                ownerCPFLabel.setVisible(true);
                ownerExtraTextField.setVisible(true);
                ownerExtraLabel.setVisible(true);
                if (newValue == TiposVEM.Estudante) {
                    ownerExtraLabel.setText("Carteira Estudantil");
                    vemImageView.setImage(new Image(getClass().getResourceAsStream("/images/VEMEstudante.png")));
                } else {
                    ownerExtraLabel.setText("NIS");
                    vemImageView.setImage(new Image(getClass().getResourceAsStream("/images/VEMTrabalhador.png")));
                }
            } else {
                ownerNameTextField.setVisible(true);
                ownerNameLabel.setVisible(true);
                ownerBirthDatePicker.setVisible(true);
                ownerBirthLabel.setVisible(true);
                ownerCPFTextField.setVisible(true);
                ownerCPFLabel.setVisible(true);
                ownerExtraTextField.setVisible(false);
                ownerExtraLabel.setVisible(false);
                if (newValue == TiposVEM.Infantil)
                    vemImageView.setImage(new Image(getClass().getResourceAsStream("/images/VEMInfantil.png")));
                else if (newValue == TiposVEM.Idoso)
                    vemImageView.setImage(new Image(getClass().getResourceAsStream("/images/VEMIdoso.png")));
            }
        });
        new ComboBoxAutoComplete<TiposVEM>(typeVEMComboBox);

        addVEMButton.setOnAction(event -> {
        });
        editVEMButton.setOnAction(event -> {
        });
        saveVEMButton.setOnAction(event -> {
        });
        deleteVEMButton.setOnAction(event -> {
        });
    }

    private void clearFields() {
        numberVEMTextField.setText("");
        typeVEMComboBox.setValue(TiposVEM._null);
        ownerNameTextField.setText("");
        ownerBirthDatePicker.setValue(null);
        ownerCPFTextField.setText("");
        ownerExtraTextField.setText("");
    }
}
