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
import systems.singularity.cinttamobi.gui.javafx.AsyncCallable;
import systems.singularity.cinttamobi.gui.javafx.EventsTimeline;
import systems.singularity.cinttamobi.gui.javafx.StageTools;
import systems.singularity.cinttamobi.gui.javafx.controllers.MainController;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class Programa extends Application {
    private static final boolean developerMode = true;
    private static final boolean waitOnExcept = false;

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isWaitOnExcept() {
        return waitOnExcept;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            if (developerMode)
                e.printStackTrace();

            StageTools.exception((Exception) e, waitOnExcept);
        });

        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText("Você tem certeza que deseja sair?");
            alert.setContentText(null);

            Button exitButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            exitButton.setText("Sair");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK)
                primaryStage.close();
            else
                event.consume();
        });

        Parent splashScreen = FXMLLoader.load(getClass().getResource("/scenes/splashScreen.fxml"));
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

        new AsyncCallable(() -> {
            Label progressStatus = (Label) splashScreen.lookup("#progressStatus");
            EventsTimeline eventsTimeline = new EventsTimeline();
            EventsTimeline.setDelay(1000);
            eventsTimeline.add(event -> progressStatus.setText("Testando Métodos"), 250);
            eventsTimeline.add(event -> Testes.main(new String[]{}));
            eventsTimeline.add(event -> progressStatus.setText("Carregando User Interface"), 250);
            eventsTimeline.add(event -> {
                try {
                    Properties messages = new Properties();
                    messages.loadFromXML(getClass().getResourceAsStream("/values/messages.xml"));
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/main.fxml"));
                    Parent root = fxmlLoader.load();
                    root.minHeight(Double.parseDouble(messages.getProperty("minHeight")));
                    root.minWidth(Double.parseDouble(messages.getProperty("minWidth")));
                    Scene scene = new Scene(
                            root,
                            Double.parseDouble(messages.getProperty("prefWidth")),
                            Double.parseDouble(messages.getProperty("prefHeight"))
                    );
                    primaryStage.setScene(scene);
                    primaryStage.setTitle(messages.getProperty("app_name"));
                    primaryStage.setMaxWidth(Double.parseDouble(messages.getProperty("maxWidth")));
                    primaryStage.setMaxHeight(Double.parseDouble(messages.getProperty("maxHeight")));
                    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
                    try {
                        new StageTools().setupOSXStage(primaryStage);
                    } catch (Exception ignored) {
                    }
                    primaryStage.setMinWidth(Double.parseDouble(messages.getProperty("minWidth")));
                    primaryStage.setMinHeight(Double.parseDouble(messages.getProperty("minHeight")));
                    ((MainController) fxmlLoader.getController()).onMovement(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
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
