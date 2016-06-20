package systems.singularity.cinttamobi.guiController;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.enums.TiposVEM;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by phts on 02/05/2016.
 * © 2016 Singularity Systems
 */
public class VEMCadastroController implements Initializable {
    public TableView<VEM> vemTableView;
    public TableColumn<VEM, String> numberVEMTableColumn;
    public TableColumn<VEM, String> typeVEMTableColumn;
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

    }
}
