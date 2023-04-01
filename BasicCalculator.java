import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator extends JFrame implements ActionListener {
    // Attributes
    private final JTextField textField = new JTextField();
    private final JButton[] numberButtons = new JButton[10];
    private final JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;
    public double num1 = 0, num2 = 0, result = 0;
    public char op;

    public BasicCalculator() {
         // adding the title
        super("BasicCalculator");

        // setup
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // adding components + setting visible to true
        this.add(jPanel);
        this.add(negButton);
        this.add(delButton);
        this.add(clrButton);
        this.add(textField);

        //
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new BasicCalculator();
    }
}