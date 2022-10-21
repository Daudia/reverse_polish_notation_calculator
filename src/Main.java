import model.Accumulator;

public class Main {
    public static void main(String[] args) {

        Controller control = new Controller();
        Accumulator acc = new Accumulator();
        acc.push(3.0);
        acc.push(5.0);
        acc.push(6.0);
        acc.neg();
        acc.swap();
        acc.add();
        System.out.println(acc.getStack().peek());
        //acc.pcs.addPropertyChangeListener(control);

        System.out.println(acc.getStack());
    }
}