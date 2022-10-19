import java.util.Stack;

public class CalculatorStack extends Stack {

    public CalculatorStack() {
    }

    public void drop(){
        if (!this.isEmpty()) {
            this.pop();
        }
    }

}
