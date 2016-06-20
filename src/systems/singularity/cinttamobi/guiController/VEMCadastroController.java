package systems.singularity.cinttamobi.guiController;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.ObservableFaceArray;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.enums.TiposVEM;
import systems.singularity.cinttamobi.fachada.Fachada;
import systems.singularity.cinttamobi.negocio.gui.AsyncCallable;

import java.net.URL;
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

            } else {

            }
        });
    }
}
