package systems.singularity.cinttamobi.util.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import systems.singularity.cinttamobi.Main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by pedro on 5/2/16.
 * © 2016 Singularity Systems
 */
public class StageTools {
    private static Properties messages = new Properties();
    private static TabPane tabPane;

    public StageTools() {
        try {
            messages.loadFromXML(getClass().getResourceAsStream("/values/messages.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(Alert.AlertType type, String title, String header, String content, boolean wait) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        if (wait)
            alert.showAndWait();
        else
            alert.show();
    }

    public static void exception(Exception e, boolean wait) {
        if (Main.isWaitOnExcept())
            e.printStackTrace();

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception");
        alert.setHeaderText(e.toString().split(":")[0]);
        alert.setContentText(e.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String exceptionText = sw.toString();

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);

        alert.getDialogPane().setExpandableContent(expContent);

        if (wait)
            alert.showAndWait();
        else
            alert.show();
    }

    public static <T> void reloadTableView(TableView<T> tableView) {
        TableView.TableViewSelectionModel<T> tTableViewSelectionModel = tableView.getSelectionModel();
        tTableViewSelectionModel.select(0);
        tTableViewSelectionModel.clearSelection();
        ObservableList<T> scr = tableView.getItems();
        ObservableList<T> dest = FXCollections.observableArrayList(scr);
        tableView.getItems().removeAll(scr);
        tableView.getItems().addAll(dest);
    }

    public void newTab(String id, TabPane tabPane) {
        SelectionModel selectionModel = tabPane.getSelectionModel();
        for (Tab e : tabPane.getTabs())
            if (e.getId().equals(id)) {
                selectionModel.select(e);
                return;
            }
        try {
            Tab tab = new Tab();
            tab.setId(id);
            tab.setText(messages.getProperty(id));
            tab.setClosable(true);
            tab.setContent(FXMLLoader.load(getClass().getResource(String.format("/scenes/%s.fxml", id))));
            tabPane.getTabs().add(tab);
            selectionModel.select(tab);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void newTab(String id) {
        newTab(id, tabPane);
    }

    public void setTabPane(TabPane tabPane) {
        this.tabPane = tabPane;
    }

    public void setupMenuItem(String id, MenuItem menuItem, TabPane tabPane) {
        menuItem.setText(messages.getProperty(id));
        menuItem.setOnAction(event -> new StageTools().newTab(id, tabPane));
    }

    public void setupMenuItem(String id, MenuItem menuItem) {
        setupMenuItem(id, menuItem, tabPane);
    }

    public void setupOSXStage(Stage stage) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.setProperty("apple.awt.graphics.EnableQ2DX", "true");
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", messages.getProperty("app_name"));
        System.setProperty("dock:name", messages.getProperty("app_name"));

        Image fxIcon = stage.getIcons().get(0);
        BufferedImage swingIcon = new BufferedImage((int) fxIcon.getWidth(), (int) fxIcon.getHeight(), BufferedImage.TYPE_INT_ARGB);
        SwingFXUtils.fromFXImage(stage.getIcons().get(0), swingIcon);

        Class<?> applicationClass = Class.forName("com.apple.eawt.Application");
        Method getApplicationMethod = applicationClass.getMethod("getApplication");
        Method setDockIconMethod = applicationClass.getMethod("setDockIconImage", java.awt.Image.class);
        setDockIconMethod.invoke(getApplicationMethod.invoke(null), swingIcon);
    }
}
