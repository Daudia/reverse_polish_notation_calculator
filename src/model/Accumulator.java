package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Stack;

public class Accumulator {
    private CalculatorStack stack = new CalculatorStack();
    private String ecran = "";
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
            case "push":
                this.push();
                break;

            case "add":
                this.add();
                break;

            case "min":
                this.sub();
                break;

            case "multi":
                this.multi();
                break;

            case "div":
                this.div();
                break;

            case "neg":
                this.neg();
                break;

            case "swap":
                this.swap();
                break;

            case "clear":
                this.clear();
                break;

            case "back":
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

    public String getIndexMemoire(int n) { //Nous permet de récuperer les valeurs à stocker et afficher dans la pile

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

    public String getEcran(){
        //Permet de faire le lien entre la partie modèle et la partie vue en récupérant
        //ce qui est stocké dans l'attribut écran
        return ecran;
    }

    public String resString() {
        //Pour récupérer le résultat sous forme de String pour l'afficher dans le label
        return stack.get(stack.size()-1).toString();
        //On récupère le dernier élément
    }

}
