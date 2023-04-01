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

        // textField
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);

        // JButtons
        // functionButtons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("delete");
        clrButton = new JButton("clear");
        negButton = new JButton("(-)");

        //
        JButton[] functionButtons = new JButton[9];
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        //
        for (JButton functionButton : functionButtons) {
            functionButton.addActionListener(this);
            functionButton.setFocusable(false);
        }

        //
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        //
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // JPanel
        JPanel jPanel = new JPanel();
        jPanel.setBounds(50, 100, 300, 300);
        jPanel.setLayout(new GridLayout(4, 4, 10, 10));

        //
        jPanel.add(numberButtons[1]);
        jPanel.add(numberButtons[2]);
        jPanel.add(numberButtons[3]);
        jPanel.add(addButton);

        jPanel.add(numberButtons[4]);
        jPanel.add(numberButtons[5]);
        jPanel.add(numberButtons[6]);
        jPanel.add(subButton);

        jPanel.add(numberButtons[7]);
        jPanel.add(numberButtons[8]);
        jPanel.add(numberButtons[9]);
        jPanel.add(mulButton);

        jPanel.add(decButton);
        jPanel.add(numberButtons[0]);
        jPanel.add(equButton);
        jPanel.add(divButton);

        // adding components + setting visible to true
        this.add(jPanel);
        this.add(negButton);
        this.add(delButton);
        this.add(clrButton);
        this.add(textField);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        Object source = e.getSource();

        if (decButton.equals(source)) {
            textField.setText(textField.getText().concat("."));
        } else if (addButton.equals(source)) {
            num1 = Double.parseDouble(textField.getText());
            op = '+';
            textField.setText("");
        } else if (mulButton.equals(source)) {
            num1 = Double.parseDouble(textField.getText());
            op = '*';
            textField.setText("");
        } else if (subButton.equals(source)) {
            num1 = Double.parseDouble(textField.getText());
            op = '-';
            textField.setText("");
        } else if (divButton.equals(source)) {
            num1 = Double.parseDouble(textField.getText());
            op = '/';
            textField.setText("");
        } else if (equButton.equals(source)) {
            num2 = Double.parseDouble(textField.getText());

            switch (op) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 * num2;
                case '*' -> result = num1 - num2;
                case '/' -> result = num1 / num2;
            }

            textField.setText(String.valueOf(result));

            num1 = result;
        } else if (clrButton.equals(source)) {
            textField.setText("");
        } else if (delButton.equals(source)) {
            if (!textField.getText().equals("")) {
                textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            }
        } else if (negButton.equals(source)) {
            Double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }

    public static void main(String[] args) {
        new BasicCalculator();
    }
}