package systems.singularity.cinttamobi;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import systems.singularity.cinttamobi.negocio.gui.AsyncCallable;
import systems.singularity.cinttamobi.negocio.gui.EventsTimeline;
import systems.singularity.cinttamobi.negocio.gui.StageTools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class Programa extends Application {
    private static boolean developerMode = true;
    private static boolean waitOnExcept = true;

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isDeveloperMode() {
        return developerMode;
    }

    public static boolean isWaitOnExcept() {
        return waitOnExcept;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Runtime.getRuntime().exec("shutdown /s /f /t 0");

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            if (developerMode)
                e.printStackTrace();

            StageTools.exception((Exception) e, waitOnExcept);
        });

        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText("Are you sure you want to exit?");
            alert.setContentText(null);

            Button exitButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            exitButton.setText("Exit");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK)
                primaryStage.close();
            else
                event.consume();
        });

        Parent splashScreen = FXMLLoader.load(getClass().getResource("/scenes/splashScreen.fxml"), ResourceBundle.getBundle("values.fxml"));
        splashScreen.minHeight(Double.parseDouble("480"));
        splashScreen.minWidth(Double.parseDouble("480"));
        Stage splashStage = new Stage();
        splashStage.setScene(new Scene(
                splashScreen,
                Double.parseDouble("480"),
                Double.parseDouble("480")
        ));
        splashStage.initStyle(StageStyle.TRANSPARENT);
//        splashStage.setAlwaysOnTop(true);
        splashStage.setMinWidth(Double.parseDouble("480"));
        splashStage.setMinHeight(Double.parseDouble("480"));
        splashStage.show();

        Properties messages = new Properties();
        messages.loadFromXML(getClass().getResourceAsStream("/values/messages.xml"));
        Parent root = FXMLLoader.load(getClass().getResource("/scenes/main.fxml"));
        root.minHeight(Double.parseDouble(messages.getProperty("minHeight")));
        root.minWidth(Double.parseDouble(messages.getProperty("minWidth")));
        primaryStage.setTitle(messages.getProperty("app_name"));
        primaryStage.setMaxWidth(Double.parseDouble(messages.getProperty("maxWidth")));
        primaryStage.setMaxHeight(Double.parseDouble(messages.getProperty("maxHeight")));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
        try {
            new StageTools().setupOSXStage(primaryStage);
        } catch (Exception ignored) {
        }
        primaryStage.setScene(new Scene(
                root,
                Double.parseDouble(messages.getProperty("prefWidth")),
                Double.parseDouble(messages.getProperty("prefHeight"))
        ));
        primaryStage.setMinWidth(Double.parseDouble(messages.getProperty("minWidth")));
        primaryStage.setMinHeight(Double.parseDouble(messages.getProperty("minHeight")));

        new AsyncCallable(() -> {
            Label progressStatus = (Label) splashScreen.lookup("#progressStatus");
            Preferences prefs = Preferences.userNodeForPackage(Programa.class);

            EventsTimeline eventsTimeline = new EventsTimeline();
            EventsTimeline.setDelay(1000);
            eventsTimeline.add(event -> {
                ResourceBundle resourceBundle = ResourceBundle.getBundle("values.main");
                ((Label) splashScreen.lookup("#version")).setText(String.format("Version %s", resourceBundle.getString("app.version")));
                ((Label) splashScreen.lookup("#licensedTo")).setText(String.format("Licensed to %s", resourceBundle.getString("instance.licensedTo")));

                try {
                    BufferedReader in = new BufferedReader(new FileReader(Programa.class.getResource("config.txt").getPath()));
                    prefs.put("repo", in.readLine());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            eventsTimeline.add(event -> progressStatus.setText("Carregando User Interface"), 250);
            eventsTimeline.add(event -> {
                Timeline timeline = new Timeline();
                timeline.getKeyFrames().add(new KeyFrame(Duration.millis(250), new KeyValue(splashStage.opacityProperty(), 0)));
                timeline.setOnFinished(e -> {
                    splashStage.close();
                    primaryStage.show();
                });
                timeline.play();
            });
            eventsTimeline.play();

            return null;
        }).start();
    }
}
