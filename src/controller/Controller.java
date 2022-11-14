package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Accumulator;
import model.CalculatorStack;
import view.GUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller extends Application implements PropertyChangeListener {
    private final Accumulator accumulator = new Accumulator();
    CalculatorStack stack;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        accumulator.addPropertyChangeListener(this);
        stack = accumulator.getStack();

        GUI window = new GUI(primaryStage, this);
        window.show();

    }

    public void action(String str) {
        System.out.println(str);
        accumulator.action(str);
    }

    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.stack = (CalculatorStack) evt.getNewValue();
    }
}