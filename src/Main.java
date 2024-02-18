import mvc.Controller;
import mvc.Model;
import mvc.View;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::setWindow);
    }

    private static void setWindow() {
        // Frame setting
        JFrame jFrame = new JFrame("Pentamino");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        // jFrame.setAlwaysOnTop(true);
        // MVC init
        Model model = new Model();
        View view = new View(model);
        new Controller(model, view);
        // Frame init
        jFrame.setContentPane(view);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

}