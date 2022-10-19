import model.Accumulator;

public class Main {
    public static void main(String[] args) {

        Controller control = new Controller();
        Accumulator acc = new Accumulator();
        acc.push(3.0);
        acc.push(5.0);
        acc.push(6.0);
        acc.drop();
        acc.neg();
        acc.swap();
        acc.square();
        acc.div();
        System.out.println(acc.getStack().peek());
    }
}