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
import systems.singularity.cinttamobi.gui.javafx.StageTools;
import systems.singularity.cinttamobi.negocio.pessoas.Crianca;
import systems.singularity.cinttamobi.negocio.pessoas.Estudante;
import systems.singularity.cinttamobi.negocio.pessoas.Idoso;
import systems.singularity.cinttamobi.negocio.pessoas.Trabalhador;
import systems.singularity.cinttamobi.negocio.vem.*;

import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
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

        numberVEMTableColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        typeVEMTableColumn.setCellValueFactory(new PropertyValueFactory<>("t"));
        ownerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("n"));
        ownerCPFTableColumn.setCellValueFactory(new PropertyValueFactory<>("c"));

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
                numberVEMTextField.setDisable(true);
                typeVEMComboBox.setDisable(true);
                ownerBirthDatePicker.setDisable(true);
                ownerCPFTextField.setDisable(true);

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
        new ComboBoxAutoComplete<>(typeVEMComboBox);

        addVEMButton.setOnAction(event -> {
            clearFields();
            vemTableView.setItems(FXCollections.observableArrayList(fachada.listVEM()));
            vemTableView.getSelectionModel().clearSelection();
        });


        saveVEMButton.setOnAction(event -> {
            VEM vem = null;

            if (numberVEMTextField.getText().equals(""))
                StageTools.alert(Alert.AlertType.WARNING, null, "Número do VEM é um campo obrigatório!", null, true);
            else {
                TiposVEM tipoVEM = typeVEMComboBox.getValue();
                if (tipoVEM == null || tipoVEM == TiposVEM._null) {
                    StageTools.alert(Alert.AlertType.WARNING, null, "Tipo do VEM é um campo obrigatório!", null, true);
                } else if (tipoVEM == TiposVEM.Comum) {
                    try {
                        vem = new VEMComum(numberVEMTextField.getText());

                        StageTools.alert(Alert.AlertType.WARNING, null, "VEM cadastrado com sucesso!", null, true);
                    } catch (Exception e) {
                        StageTools.exception(e, true);
                    }
                } else if (ownerBirthDatePicker.getValue() == null) {
                    StageTools.alert(Alert.AlertType.WARNING, null, "Data de Nascimento é um campo obrigatório!", null, true);
                } else {
                    if (tipoVEM == TiposVEM.Estudante) {
                        try {
                            vem = new VEMEstudante(
                                    numberVEMTextField.getText(),
                                    new Estudante(
                                            ownerNameTextField.getText(),
                                            Date.from(Instant.from(ownerBirthDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()))),
                                            ownerCPFTextField.getText(),
                                            ownerExtraTextField.getText()
                                    ));
                            StageTools.alert(Alert.AlertType.WARNING, null, "VEM cadastrado com sucesso!", null, true);
                        } catch (Exception e) {
                            StageTools.exception(e, true);
                        }
                    } else if (tipoVEM == TiposVEM.Idoso) {
                        try {
                            vem = new VEMIdoso(
                                    numberVEMTextField.getText(),
                                    new Idoso(
                                            ownerNameTextField.getText(),
                                            Date.from(Instant.from(ownerBirthDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()))),
                                            ownerCPFTextField.getText()
                                    ));
                            StageTools.alert(Alert.AlertType.WARNING, null, "VEM cadastrado com sucesso!", null, true);
                        } catch (Exception e) {
                            StageTools.exception(e, true);
                        }
                    } else if (tipoVEM == TiposVEM.Infantil) {
                        try {
                            vem = new VEMInfantil(
                                    numberVEMTextField.getText(),
                                    new Crianca(
                                            ownerNameTextField.getText(),
                                            Date.from(Instant.from(ownerBirthDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()))),
                                            ownerCPFTextField.getText()
                                    ));
                            StageTools.alert(Alert.AlertType.WARNING, null, "VEM cadastrado com sucesso!", null, true);
                        } catch (Exception e) {
                            StageTools.exception(e, true);
                        }
                    } else if (tipoVEM == TiposVEM.Trabalhador) {
                        try {
                            vem = new VEMTrabalhador(
                                    numberVEMTextField.getText(),
                                    new Trabalhador(
                                            ownerNameTextField.getText(),
                                            Date.from(Instant.from(ownerBirthDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()))),
                                            ownerCPFTextField.getText(),
                                            ownerExtraTextField.getText()
                                    ));
                            StageTools.alert(Alert.AlertType.WARNING, null, "VEM cadastrado com sucesso!", null, true);
                        } catch (Exception e) {
                            StageTools.exception(e, true);
                        }
                    }
                }
            }

            try {
                if (selectionModel.getSelectedItem() != null)
                    fachada.atualizarVEM(vem);
                else{
                    fachada.cadastrarVEM(vem);

                }

                clearFields();
                vemTableView.setItems(FXCollections.observableArrayList(fachada.listVEM()));
                vemTableView.getSelectionModel().clearSelection();
            } catch (Exception e) {
                StageTools.exception(e, true);
            }
        });


        deleteVEMButton.setOnAction(event -> {
            try {
                fachada.removerVEM((VEM) selectionModel.getSelectedItem());
            } catch (Exception e) {
                StageTools.exception(e, true);
            }

            vemTableView.setItems(FXCollections.observableArrayList(fachada.listVEM()));
            vemTableView.getSelectionModel().clearSelection();
        });
    }

    private void clearFields() {
        numberVEMTextField.setDisable(false);
        typeVEMComboBox.setDisable(false);
        ownerBirthDatePicker.setDisable(false);
        ownerCPFTextField.setDisable(false);

        numberVEMTextField.setText("");
        typeVEMComboBox.setValue(TiposVEM._null);
        ownerNameTextField.setText("");
        ownerBirthDatePicker.setValue(null);
        ownerCPFTextField.setText("");
        ownerExtraTextField.setText("");
    }
}
