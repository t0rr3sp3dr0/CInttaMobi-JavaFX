package systems.singularity.cinttamobi.gui;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import systems.singularity.cinttamobi.util.gui.StageTools;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public MenuBar menuBar;
    public Menu mainMenu;
    public MenuItem aboutMenuItem;
    public Menu preferencesMenu;
    public MenuItem logMenuItem;
    public MenuItem usersMenuItem;
    public SeparatorMenuItem developerSeparator;
    public Menu developerMenu;
    public MenuItem connectionPreferencesMenuItem;
    public MenuItem quitMenuItem;
    public Menu cadastroMenu;
    public MenuItem fornecedoresCadastroMenuItem;
    public MenuItem trabalhadoresCadastroMenuItem;
    public MenuItem obrasCadastroMenuItem;
    public MenuItem comprasCadastroMenuItem;
    public MenuItem materiaisCadastroMenuItem;
    public MenuItem cargosEFuncoesCadastroMenuItem;
    public MenuItem prestadoresDeServicoCadastroMenuItem;
    public MenuItem destinosERecolhimentosCadastroMenuItem;
    public MenuItem corretorCadastroMenuItem;
    public MenuItem imobiliariaCadastroMenuItem;
    public MenuItem imoveisCadastroMenuItem;
    public MenuItem clientesCadastroMenuItem;
    public Menu estoqueMenu;
    public MenuItem entradaEstoqueMenuItem;
    public MenuItem saidaEstoqueMenuItem;
    public Menu caixaMenu;
    public Menu pagamentosMenu;
    public Menu encargosTrabalhistasMenu;
    public MenuItem recolhimentoDeFGTSPagamentosMenuItem;
    public MenuItem recolhimentoDeINSSPagamentosMenuItem;
    public MenuItem trabalhadoresPagamentosMenuItem;
    public MenuItem tributosPagamentosMenuItem;
    public MenuItem diversosPagamentosMenuItem;
    public MenuItem entradasDeCapitalCaixaMenuItem;
    public MenuItem contasAReceberCaixaMenuItem;
    public MenuItem saldoDeCapitalCaixaMenuItem;
    public MenuItem contasAPagarCaixaMenuItem;
    public MenuItem despesasFixasCaixaMenuItem;
    public Menu documentosMenu;
    public MenuItem contratosDeVendaDocumentosMenuItem;
    public MenuItem contratosDeCompraDocumentosMenuItem;
    public MenuItem autorizacoesDeVendaDocumentosMenuItem;
    public MenuItem reciboAvulsoDocumentosMenuItem;
    public MenuItem contratoDePrestacaoDeServicoDocumentosMenuItem;
    public MenuItem cartaAoTrabalhadorDocumentosMenuItem;
    public MenuItem relatorioDeEstoqueDocumentosMenuItem;
    public MenuItem relatorioDeDespesasDocumentosMenuItem;
    public TabPane tabPane;
    public Tab mainTab;
    public VBox loginBox;
    public TextField username;
    public PasswordField password;
    public Button loginButton;
    public VBox wellcomeBox;
    public Label wellcomeLabel;

    private Properties messages = new Properties();
    private StageTools stageTools = new StageTools();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            messages.loadFromXML(getClass().getResourceAsStream("/values/messages.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stageTools.setTabPane(tabPane);

//        menuBar.setUseSystemMenuBar(true);
        mainMenu.setText(mainMenu.getText().replace("{{APP_NAME}}", messages.getProperty("app_name")));
        aboutMenuItem.setText(aboutMenuItem.getText().replace("{{APP_NAME}}", messages.getProperty("app_name")));
        aboutMenuItem.setOnAction(event -> StageTools.alert(
                Alert.AlertType.INFORMATION,
                null,
                messages.getProperty("app_name"),
                String.format("© %d %s\nAll rights reserved\n\n<> Developed by %s", Year.now().getValue(), messages.getProperty("app_name"), messages.getProperty("developer_name")),
                true
        ));
        quitMenuItem.setText(quitMenuItem.getText().replace("{{APP_NAME}}", messages.getProperty("app_name")));
        quitMenuItem.setOnAction(event -> {
            Stage stage = (Stage) menuBar.getScene().getWindow();
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        });

        stageTools.setupMenuItem("fornecedoresCadastro", fornecedoresCadastroMenuItem);
        stageTools.setupMenuItem("trabalhadoresCadastro", trabalhadoresCadastroMenuItem);
        stageTools.setupMenuItem("connectionPreferences", connectionPreferencesMenuItem);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);
    }
}
