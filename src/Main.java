import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.GUI;

public class Main extends Application {

    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("LA CALCULATRICE COOL");
        GUI gui = new GUI(new BorderPane());
        primaryStage.setScene(gui);
        primaryStage.show();

    }
}