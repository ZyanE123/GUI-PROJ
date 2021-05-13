import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    // THIS IS THE PUBLIC STATIC VOID MAIN!!!!!!!!!!!
    public static void main(String[] args) {
        //dimenstions of jframe
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(352, 332));
        frame.setMinimumSize(new Dimension(352, 332));
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null); //center of screen

        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());

        try {
            rootPanel.add(new Furnace(), BorderLayout.CENTER);
            frame.add(rootPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
        frame.pack();
    }

}
