package view;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    private Stage stage;
    private Controller controller;
    private Accumulator accumulator;

    public GUI(Stage stage, Controller controller) throws Exception {
        this.stage = stage;
        this.controller = controller;
        this.accumulator = controller.getAccumulator();
    }

    public void show() {

        VBox overallBox = new VBox();
        overallBox.setStyle("-fx-font: 40px Arial"); //On définit la police et la taille des écritures

        VBox displayBox = new VBox();
        displayBox.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, null, null)));

        GridPane buttonsGrid = new GridPane();
        buttonsGrid.setBackground(new Background(new BackgroundFill(Color.PINK, null, null)));
        buttonsGrid.setVgap(10);
        buttonsGrid.setHgap(10);

        overallBox.getChildren().add(displayBox);
        overallBox.getChildren().add(buttonsGrid);

        Label resultLabel = new Label(" ");
        resultLabel.setTextFill(Color.BLACK);

        Label stackMemory1 = new Label(" ");
        stackMemory1.setTextFill(Color.GREY);
        Label stackMemory2 = new Label(" ");
        stackMemory1.setTextFill(Color.GREY);
        Label stackMemory3 = new Label(" ");
        stackMemory1.setTextFill(Color.GREY);

        displayBox.getChildren().add(stackMemory1);
        displayBox.getChildren().add(stackMemory2);
        displayBox.getChildren().add(stackMemory3);
        displayBox.getChildren().add(resultLabel);

        //Buttons creation
        Button pushButton = createButton("↪", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 0, 1);
        Button swapButton = createButton("⤄", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 1, 1);
        Button clearButton = createButton("C", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 2, 1);
        Button backButton = createButton("⌫", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 3, 1);
        Button sevenButton = createButton("7", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 0, 2);
        Button eightButton = createButton("8", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 1, 2);
        Button nineButton = createButton("9", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 2, 2);
        Button divButton = createButton("/", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 3, 2);
        Button fourButton = createButton("4", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 0, 3);
        Button fiveButton = createButton("5", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 1, 3);
        Button sixButton = createButton("6", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 2, 3);
        Button multButton = createButton("*", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 3, 3);
        Button oneButton = createButton("1", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 0, 4);
        Button twoButton = createButton("2", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 1, 4);
        Button threeButton = createButton("3", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 2, 4);
        Button minButton = createButton("-", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 3, 4);
        Button dotButton = createButton(".", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 0, 5);
        Button zeroButton = createButton("0", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 1, 5);
        Button negButton = createButton("+/-", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 2, 5);
        Button addButton = createButton("+", Color.HOTPINK, Color.DEEPPINK, Color.WHITE, overallBox, buttonsGrid, 3, 5);

        numberButtonConfig(zeroButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(oneButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(twoButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(threeButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(fourButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(fiveButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(sixButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(sevenButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(eightButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        numberButtonConfig(nineButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);

        operatorButtonConfig(swapButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(clearButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(backButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(divButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(multButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(minButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(dotButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(negButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);
        operatorButtonConfig(addButton, resultLabel, stackMemory1, stackMemory2, stackMemory3);

        pushButton.setOnAction (new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e){
                controller.action(pushButton.getText());
                stackMemory2.setText(resultLabel.getText());
                resultLabel.setText(accumulator.getEcran());
                stackMemory1.setText(accumulator.getIndexMemoire(2));
                stackMemory2.setText(accumulator.getIndexMemoire(1));
                stackMemory3.setText(accumulator.getIndexMemoire(0));
            }
        });

        Scene scene = new Scene(overallBox);
        stage.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/512/1363/1363376.png"));
        stage.setTitle("RPN Calculator"); // Window title
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    //Button overall creation method, avoiding the repetition of many methods for each button
    private Button createButton(String text, Color colorBackground, Color colorBackgroundClicked, Color colorText, VBox calculator, GridPane buttonsGrid, int columnIndex, int rowIndex) {
        Button newButton = new Button(text);
        newButton.setTextAlignment(TextAlignment.CENTER);
        newButton.setBackground(new Background(new BackgroundFill(colorBackground, new CornerRadii(100), null)));
        newButton.setTextFill(colorText);
        newButton.setMinWidth(100);
        buttonsGrid.add(newButton, columnIndex, rowIndex);
        DropShadow shadow = new DropShadow();
        newButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                newButton.setEffect(shadow);
            }
        });
        newButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                newButton.setEffect(null);
            }
        });
        newButton.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                newButton.setBackground(new Background(new BackgroundFill(colorBackgroundClicked, new CornerRadii(100), null)));
            }
        });
        newButton.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                newButton.setBackground(new Background(new BackgroundFill(colorBackground, new CornerRadii(100), null)));
            }
        });

        return newButton;
    }

    private void operatorButtonConfig(Button button, Label resultLabel, Label stackMemory1, Label stackMemory2, Label stackMemory3) {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.action(button.getText());
                resultLabel.setText(accumulator.getEcran());
                stackMemory1.setText(accumulator.getIndexMemoire(2));
                stackMemory2.setText(accumulator.getIndexMemoire(1));
                stackMemory3.setText(accumulator.getIndexMemoire(0));
            }
        });
    }

    private void numberButtonConfig(Button button, Label resultLabel, Label stackMemory1, Label stackMemory2, Label stackMemory3) {
        button.setOnAction (new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e){
                controller.action(button.getText());
                resultLabel.setText(accumulator.getEcran());
            }
        });
    }
}
