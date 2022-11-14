package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Accumulator {
    private CalculatorStack stack = new CalculatorStack();
    private String resultText = "";
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void push(){ // Ajoute une valeur à la pile de la calculatrice
        if (resultText!=("")) {
            stack.push(Double.parseDouble(resultText));
            resultText = "";
        }
    }

    public void drop(){ //Efface la dernière valeur de la calculatrice
        if (resultText.equals("")){
            stack.drop();
        }
        else{
            resultText="";
        }
    }

    public void clear(){ //Efface toutes les valeurs de la calculatrice
        stack.clear();
        resultText="";
    }

    public void swap(){ // Swap les deux dernière valeurs de la calculatrice
        System.out.println("LETS GO 1");
        if (stack.size()>1) {
            System.out.println("LETS GO 2");
            Double x = (Double) stack.pop();
            System.out.println(x);
            Double y = (Double) stack.pop();
            System.out.println(y);
            stack.push(x);
            stack.push(y);
        }
    }

    public void add(){ //Additionne les deux dernière valeurs de la calculatrice
        if (stack.size()>1){
            push();
            stack.push((Double) stack.pop()+(Double) stack.pop());
        }
    }

    public void sub(){ //Soustrait la dernière valeur à l'avant dernière valeur de la calculatrice
        if (stack.size()>1){
            push();
            stack.push(-((Double) stack.pop()-(Double) stack.pop()));
        }
    }

    public void multi(){ //Multiplie les deux dernières valeurs de la calculatrice
        if (stack.size()>1){
            push();
            stack.push((Double) stack.pop()*(Double) stack.pop());
        }
    }

    public void div(){ //Divise l'avant dernière valeur par la dernières valeur de la calculatrice
        if (stack.size()>1){
            push();
            stack.push(1/((Double) stack.pop()/(Double) stack.pop()));
        }
    }

    public void neg(){ //Inverse le signe de la dernière valeur de la calculatrice
        if (!stack.isEmpty()){
            push();
            stack.push(-(Double) stack.pop());
        }
    }


    public void action (String string){
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


    public String getIndexMemoire(int n) {

        ArrayList<String> liste = new ArrayList();
        for(int i=0;i<n+1;i++) {
            if (stack.size()>i) {
                liste.add(stack.get(stack.size()-1-i).toString());
            }
            else {
                liste.add("");
            }
        }
        return liste.get(n);
    }

    public String getResultText(){
        return resultText;
    }


}
