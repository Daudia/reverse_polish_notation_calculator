package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Accumulator;

public class GUI implements IView {

    private final Stage stage;
    private final Controller controller;
    private final Accumulator accumulator;

    public GUI(Stage stage, Controller controller) {
        this.stage = stage;
        this.controller = controller;
        this.accumulator = controller.getAccumulator();
    }

    public void show() {

        //Create the box including all the children (buttons and labels) of the window
        VBox overallBox = new VBox();
        overallBox.setStyle("-fx-font: 40px Arial"); //On définit la police et la taille des écritures

        //Create the box including the labels which shows the result and the previous numbers
        VBox displayBox = new VBox();
        displayBox.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, null, null)));

        //Create the grid including all the buttons of the calculator
        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setBackground(new Background(new BackgroundFill(Color.PINK, null, null)));
        buttonsGrid.setVgap(10);
        buttonsGrid.setHgap(10);

        //Add the grid and the label box in the overall box
        overallBox.getChildren().add(displayBox);
        overallBox.getChildren().add(buttonsGrid);

        //Create the label showing the current result and the memory ones
        Label resultLabel = new Label(" ");
        resultLabel.setTextFill(Color.BLACK);

        Label stackMemory1 = new Label(" ");
        stackMemory1.setTextFill(Color.GREY);
        Label stackMemory2 = new Label(" ");
        stackMemory1.setTextFill(Color.GREY);
        Label stackMemory3 = new Label(" ");
        stackMemory1.setTextFill(Color.GREY);

        //Add the label to the display box
        displayBox.getChildren().add(stackMemory1);
        displayBox.getChildren().add(stackMemory2);
        displayBox.getChildren().add(stackMemory3);
        displayBox.getChildren().add(resultLabel);

        //Buttons creation
        Button pushButton = createButton("↪", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 0, 1);
        Button swapButton = createButton("⤄", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 1, 1);
        Button clearButton = createButton("C", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 2, 1);
        Button backButton = createButton("⌫", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 3, 1);
        Button sevenButton = createButton("7", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 0, 2);
        Button eightButton = createButton("8", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 1, 2);
        Button nineButton = createButton("9", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 2, 2);
        Button divButton = createButton("/", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 3, 2);
        Button fourButton = createButton("4", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 0, 3);
        Button fiveButton = createButton("5", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 1, 3);
        Button sixButton = createButton("6", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 2, 3);
        Button multButton = createButton("*", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 3, 3);
        Button oneButton = createButton("1", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 0, 4);
        Button twoButton = createButton("2", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 1, 4);
        Button threeButton = createButton("3", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 2, 4);
        Button minButton = createButton("-", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 3, 4);
        Button dotButton = createButton(".", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 0, 5);
        Button zeroButton = createButton("0", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 1, 5);
        Button negButton = createButton("+/-", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 2, 5);
        Button addButton = createButton("+", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, buttonsGrid, 3, 5);

        //Number buttons configuration
        numberButtonConfig(zeroButton, resultLabel);
        numberButtonConfig(oneButton, resultLabel);
        numberButtonConfig(twoButton, resultLabel);
        numberButtonConfig(threeButton, resultLabel);
        numberButtonConfig(fourButton, resultLabel);
        numberButtonConfig(fiveButton, resultLabel);
        numberButtonConfig(sixButton, resultLabel);
        numberButtonConfig(sevenButton, resultLabel);
        numberButtonConfig(eightButton, resultLabel);
        numberButtonConfig(nineButton, resultLabel);

        //Operator buttons configuration
        operatorButtonConfig(swapButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(clearButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(backButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(divButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(multButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(minButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(dotButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(negButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(addButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);

        //Push button configuration
        pushButton.setOnAction(e -> {
            controller.action(pushButton.getText());
            stackMemory2.setText(resultLabel.getText());
            resultLabel.setText(accumulator.getEcran());
            stackMemory1.setText(accumulator.getIndexMemoire(2));
            stackMemory2.setText(accumulator.getIndexMemoire(1));
            stackMemory3.setText(accumulator.getIndexMemoire(0));
        });

        Scene scene = new Scene(overallBox);
        stage.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/512/1363/1363376.png"));
        stage.setTitle("RPN Calculator"); // Window title
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    //Button overall creation method, avoiding the repetition of many methods for each button. Allow to select the text, the colors, and the grid location
    private Button createButton(String text, Color colorBackground, Color colorBackgroundClicked, Color colorText, GridPane buttonsGrid, int columnIndex, int rowIndex) {
        Button newButton = new Button(text);
        newButton.setTextAlignment(TextAlignment.CENTER);
        newButton.setBackground(new Background(new BackgroundFill(colorBackground, new CornerRadii(100), null)));
        newButton.setTextFill(colorText);
        newButton.setMinWidth(100);
        buttonsGrid.add(newButton, columnIndex, rowIndex);
        //Animation of the button when it interacts with the mouse cursor
        DropShadow shadow = new DropShadow();
        newButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> newButton.setEffect(shadow));
        newButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> newButton.setEffect(null));
        newButton.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> newButton.setBackground(new Background(new BackgroundFill(colorBackgroundClicked, new CornerRadii(100), null))));
        newButton.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> newButton.setBackground(new Background(new BackgroundFill(colorBackground, new CornerRadii(100), null))));

        return newButton;
    }

    //Operators configuration method
    private void operatorButtonConfig(Button button, Label resultLabel, Label stackMemory1, Label stackMemory2, Label stackMemory3) {
        button.setOnAction(e -> {
            controller.action(button.getText());
            resultLabel.setText(accumulator.getEcran());
            stackMemory1.setText(accumulator.getIndexMemoire(2));
            stackMemory2.setText(accumulator.getIndexMemoire(1));
            stackMemory3.setText(accumulator.getIndexMemoire(0));
        });
    }

    //Number configuration method
    private void numberButtonConfig(Button button, Label resultLabel) {
        button.setOnAction(e -> {
            controller.action(button.getText());
            resultLabel.setText(accumulator.getEcran());
        });
    }
}
