package controller;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Accumulator;
import view.GUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller extends Application implements PropertyChangeListener, EventHandler{
    private final Accumulator accumulator = new Accumulator();

    @Override
    public void start(Stage primaryStage) {

        accumulator.addPropertyChangeListener(this);

        GUI window = new GUI(primaryStage, this);
        window.show();

    }
    public void action(String str) {
        accumulator.action(str);
    }

    public Accumulator getAccumulator(){
        return accumulator;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        launch(args);
    }
}