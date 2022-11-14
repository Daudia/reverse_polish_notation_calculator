package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Stack;

public class Accumulator {
    private CalculatorStack stack = new CalculatorStack();
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void push(){ // Ajoute une valeur à la pile de la calculatrice
        Stack s= stack;
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


    public void action (String string){
        switch(string){
            case "↪":
                this.push();
                break;

            case "+":
                this.add();
                break;

            case "-":
                this.sub();
                break;

            case "*":
                this.multi();
                break;

            case "/":
                this.div();
                break;

            case "+/-":
                this.neg();
                break;

            case "⤄":
                this.swap();
                break;

            case "C":
                this.clear();
                break;

            case "⌫":
                this.drop();
                break;

            default:
                // Cas d'un nombre
                break;
        }
    }


    public CalculatorStack getStack() {
        return stack;
    }

    public String resString() {
        return stack.get(stack.size()-1).toString();
    }

}
