package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Accumulator {
    private final CalculatorStack stack = new CalculatorStack();
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private String resultText = "";

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void push() { //Push the typed value
        if (!resultText.equals("")) {
            CalculatorStack s = stack;
            stack.push(Double.parseDouble(resultText));
            resultText = "";
            pcs.firePropertyChange("stack-accu", s, this.stack);
        }
    }

    public void drop() { //Delete the number currently typed or the last registered value
        CalculatorStack s = stack;
        if (resultText.equals("")) {
            stack.drop();
            pcs.firePropertyChange("stack-accu", s, this.stack);
        } else {
            resultText = "";
            pcs.firePropertyChange("stack-accu", s, this.stack);
        }
    }

    public void clear() { //Clear the stack
        CalculatorStack s = stack;
        stack.clear();
        resultText = "";
        pcs.firePropertyChange("stack-accu", s, this.stack);
    }

    public void swap() { //Swap the two last registered values
        if (stack.size() > 1) {
            CalculatorStack s = stack;
            Double x = (Double) stack.pop();
            Double y = (Double) stack.pop();
            stack.push(x);
            stack.push(y);
            pcs.firePropertyChange("stack-accu", s, this.stack);
        }
    }

    public void add() { //Add the two last registered values
        if (stack.size() > 1) {
            CalculatorStack s = stack;
            stack.push((Double) stack.pop() + (Double) stack.pop());
            pcs.firePropertyChange("stack-accu", s, this.stack);
        }
    }

    public void sub() { //Sub the two last registered values
        if (stack.size() > 1) {
            CalculatorStack s = stack;
            stack.push(-((Double) stack.pop() - (Double) stack.pop()));
            pcs.firePropertyChange("stack-accu", s, this.stack);
        }
    }

    public void multi() { //Multiply the two last registered values
        if (stack.size() > 1) {
            CalculatorStack s = stack;
            stack.push((Double) stack.pop() * (Double) stack.pop());
            pcs.firePropertyChange("stack-accu", s, this.stack);
        }
    }

    public void div() { //Divide the two last registered values
        if (stack.size() > 1) {
            CalculatorStack s = stack;
            stack.push(1 / ((Double) stack.pop() / (Double) stack.pop()));
            pcs.firePropertyChange("stack-accu", s, this.stack);
        }
    }

    public void neg() { //Multiply by minus 1 the last registered value
        if (!stack.isEmpty()) {
            CalculatorStack s = stack;
            stack.push(-(Double) stack.pop());
            pcs.firePropertyChange("stack-accu", s, this.stack);
        }
    }

    public void action(String string) {
        switch (string) {
            case "push" -> this.push();
            case "add" -> this.add();
            case "min" -> this.sub();
            case "multi" -> this.multi();
            case "div" -> this.div();
            case "neg" -> this.neg();
            case "swap" -> this.swap();
            case "clear" -> this.clear();
            case "back" -> this.drop();
            default -> resultText += string;
        }
    }

    public String getMemory(int n) {
        ArrayList<String> memoryList = new ArrayList();
        for (int i = 0; i < n + 1; i++) {
            if (stack.size() > i) {
                memoryList.add(stack.get(stack.size() - 1 - i).toString());
            } else {
                memoryList.add("");
            }
        }
        return memoryList.get(n);
    }

    public String getResultText() {
        return resultText;
    }

    public CalculatorStack getStack() {
        return stack;
    }
}
