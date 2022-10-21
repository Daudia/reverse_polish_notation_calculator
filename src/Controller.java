import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener ;

public class Controller implements java.beans.PropertyChangeListener, java.awt.event.ActionListener, java.awt.event.KeyListener, java.awt.event.WindowListener{
    public Controller() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        String property = event.getPropertyName();
        if("stack_accu".equals(property)){
            /* Si le contrôleur reçoit un event nommé "stack_accu" il sait que c'est un type stack
            venant de l'accumulateur et va l'afficher sur l'interface*/

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}