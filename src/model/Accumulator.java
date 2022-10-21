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

    public void push(Double E){
        Stack s= stack;
        stack.push(E);
        pcs.firePropertyChange("stack",s,this.stack);
    }

    public void drop(){
        Stack s= stack;
        stack.drop();
        pcs.firePropertyChange("stack",s,this.stack);
    }

    public void clear(){
        Stack s= stack;
        stack.clear();
        pcs.firePropertyChange("stack",s,this.stack);
    }

    public void swap(){
        if (stack.size()>1) {
            Stack s= stack;
            Double x = (Double) stack.pop();
            Double y = (Double) stack.pop();
            stack.push(x);
            stack.push(y);
            pcs.firePropertyChange("stack",s,this.stack);
        }
    }

    public void add(){
        if (stack.size()>1){
            Stack s= stack;
            stack.push((Double) stack.pop()+(Double) stack.pop());
            pcs.firePropertyChange("stack",s,this.stack);
        }
    }

    public void sub(){
        if (stack.size()>1){
            Stack s= stack;
            stack.push(-((Double) stack.pop()-(Double) stack.pop()));
            pcs.firePropertyChange("stack",s,this.stack);
        }
    }

    public void multi(){
        if (stack.size()>1){
            Stack s= stack;
            stack.push((Double) stack.pop()*(Double) stack.pop());
            pcs.firePropertyChange("stack",s,this.stack);
        }
    }

    public void div(){
        if (stack.size()>1){
            Stack s= stack;
            stack.push(1/((Double) stack.pop()/(Double) stack.pop()));
            pcs.firePropertyChange("stack",s,this.stack);
        }
    }

    public void neg(){
        if (!stack.isEmpty()){
            Stack s= stack;
            stack.push(-(Double) stack.pop());
            pcs.firePropertyChange("stack",s,this.stack);
        }
    }

    public void square(){
        if (!stack.isEmpty()){
            Stack s= stack;
            stack.push(Math.pow((Double) stack.pop(),2));
            pcs.firePropertyChange("stack",s,this.stack);
        }

    }

    public Stack getStack() {
        return stack;
    }


}
