import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SimpleCalculator {
    private JFrame frame;
    private JTextField number1Field;
    private JTextField number2Field;
    private JTextArea resultArea;

    public SimpleCalculator() {
        frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Angka Pertama:");
        number1Field = new JTextField(10);
        JLabel label2 = new JLabel("Angka Kedua:");
        
        number2Field = new JTextField(10);
        JButton addButton = new JButton("Tambah");
        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumbers();
            }
        });

        frame.add(label1);
        frame.add(number1Field);
        frame.add(label2);
        frame.add(number2Field);
        frame.add(addButton);
        frame.add(new JScrollPane(resultArea));

        frame.setVisible(true);
    }

    private void addNumbers() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            double sum = num1 + num2;
            resultArea.setText("Hasil: " + sum);
        } catch (NumberFormatException e) {
            resultArea.setText("Masukkan angka yang valid!");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}