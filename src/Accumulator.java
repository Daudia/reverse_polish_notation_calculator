import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Stack;

public class Accumulator {
    private CalculatorStack stack;
    private final PropertyChangeSupport pcs;

    public Accumulator() {
        this.stack = new CalculatorStack();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public void push(Double E){
        stack.push(E);
    }

    public void drop(){
        stack.drop();
    }

    public void clear(){
        stack.clear();
    }
    public void swap(){
        if (stack.size()>1) {
            Double x = (Double) stack.pop();
            Double y = (Double) stack.pop();
            stack.push(x);
            stack.push(y);
        }
    }

    public void add(){
        if (stack.size()>1){
            stack.push((Double) stack.pop()+(Double) stack.pop());
        }
    }

    public void sub(){
        if (stack.size()>1){
            stack.push(-((Double) stack.pop()-(Double) stack.pop()));
        }
    }

    public void multi(){
        if (stack.size()>1){
            stack.push((Double) stack.pop()*(Double) stack.pop());
        }
    }

    public void div(){
        if (stack.size()>1){
            stack.push(1/((Double) stack.pop()/(Double) stack.pop()));
        }
    }

    public void neg(){
        if (!stack.isEmpty()){
            stack.push(-(Double) stack.pop());
        }
    }

    public void square(){
        if (!stack.isEmpty()){
            stack.push(Math.pow((Double) stack.pop(),2));
        }

    }

    public Stack getStack() {
        return stack;
    }


}
