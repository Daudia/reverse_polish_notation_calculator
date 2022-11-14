package controller;

/*
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;

public class Controller implements java.beans.PropertyChangeListener, java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.WindowListener{
    public Controller() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        String property = event.getPropertyName();
        if("stack_accu".equals(property)){
            /* Si le contrôleur reçoit un event nommé "stack_accu" il sait que c'est un type stack venant de l'accumulateur et va l'afficher sur l'interface
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
*/


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Accumulator;
import model.CalculatorStack;
import view.GUI;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller extends Application implements PropertyChangeListener, EventHandler{

    private GUI window;
    private final Accumulator accumulator = new Accumulator();

    @Override
    public void start(Stage primaryStage) throws Exception {

        accumulator.addPropertyChangeListener(this);

        CalculatorStack stack = accumulator.getStack();
        stack.addPropertyChangeListener(this);

        GUI window = new GUI(primaryStage, this);
        window.show();

    }
    public void action(String str) {
        accumulator.action(str);
    }

    public Accumulator getAccumulator(){
        return accumulator;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}