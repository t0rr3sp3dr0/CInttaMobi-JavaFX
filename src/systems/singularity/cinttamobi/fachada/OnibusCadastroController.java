package systems.singularity.cinttamobi.fachada;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import systems.singularity.cinttamobi.negocio.Onibus;
import systems.singularity.cinttamobi.negocio.gui.StageTools;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by caesa on 19/06/2016.
 */
public class OnibusCadastroController implements Initializable {

    public TableView<Pessoa> onibusTableView;
    public TableColumn<Pessoa, String> idOnibusTableColumn;
    public TableColumn<Pessoa, String> linhaOnibusTableColumn;
    public Button addOnibusButton;
    public Button editOnibusButton;
    public Button saveOnibusButton;
    public Button deleteOnibusButton;
    public TextField idOnibusTextField;
    public TextField linhaOnibusTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
