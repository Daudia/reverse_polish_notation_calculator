package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Stack;

public class Accumulator {
    private CalculatorStack stack;
    public final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Accumulator() {
        this.stack = new CalculatorStack();
    }

    public void push(Double E){ // Ajoute une valeur à la pile de la calculatrice
        Stack s= stack;
        stack.push(E);
        pcs.firePropertyChange("stack_accu",s,this.stack);
    }

    public void drop(){ //Efface la dernière valeur de la calculatrice
        Stack s= stack;
        stack.drop();
        pcs.firePropertyChange("stack_accu",s,this.stack);
    }

    public void clear(){ //Efface toutes les valeurs de la calculatrice
        Stack s= stack;
        stack.clear();
        pcs.firePropertyChange("stack_accu",s,this.stack);
    }

    public void swap(){ // Swap les deux dernière valeurs de la calculatrice
        if (stack.size()>1) {
            Stack s= stack;
            Double x = (Double) stack.pop();
            Double y = (Double) stack.pop();
            stack.push(x);
            stack.push(y);
            pcs.firePropertyChange("stack_accu",s,this.stack);
        }
    }

    public void add(){ //Additionne les deux dernière valeurs de la calculatrice
        if (stack.size()>1){
            Stack s= stack;
            stack.push((Double) stack.pop()+(Double) stack.pop());
            pcs.firePropertyChange("stack_accu",s,this.stack);
        }
    }

    public void sub(){ //Soustrait la dernière valeur à l'avant dernière valeur de la calculatrice
        if (stack.size()>1){
            Stack s= stack;
            stack.push(-((Double) stack.pop()-(Double) stack.pop()));
            pcs.firePropertyChange("stack_accu",s,this.stack);
        }
    }

    public void multi(){ //Multiplie les deux dernières valeurs de la calculatrice
        if (stack.size()>1){
            Stack s= stack;
            stack.push((Double) stack.pop()*(Double) stack.pop());
            pcs.firePropertyChange("stack_accu",s,this.stack);
        }
    }

    public void div(){ //Divise l'avant dernière valeur par la dernières valeur de la calculatrice
        if (stack.size()>1){
            Stack s= stack;
            stack.push(1/((Double) stack.pop()/(Double) stack.pop()));
            pcs.firePropertyChange("stack_accu",s,this.stack);
        }
    }

    public void neg(){ //Inverse le signe de la dernière valeur de la calculatrice
        if (!stack.isEmpty()){
            Stack s= stack;
            stack.push(-(Double) stack.pop());
            pcs.firePropertyChange("stack_accu",s,this.stack);
        }
    }

    public void square(){ // Effectue la racine carrée de la dernière valeur de la calculatrice
        if (!stack.isEmpty()){
            Stack s= stack;
            stack.push(Math.pow((Double) stack.pop(),2));
            pcs.firePropertyChange("stack_accu",s,this.stack);
        }

    }

    public Stack getStack() {
        return stack;
    }


}
