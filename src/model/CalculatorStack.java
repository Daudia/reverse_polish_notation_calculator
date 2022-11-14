package model;

import java.util.Stack;

public class CalculatorStack extends Stack {
    public void drop() {
        if (!this.isEmpty()) {
            this.pop();
        }
    }

}
