import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class DivideNums extends JFrame{
  JTextField num1, num2;
  JLabel l1, l2, l3;
  JButton divide;

  DivideNums(){

    num1 = new JTextField(20);
    num2 = new JTextField(20);
    l1 = new JLabel("Num1: ");
    l2 = new JLabel("Num2: ");
    l3 = new JLabel("Result: ");
    divide = new JButton("divide");

    JPanel p1 = new JPanel();
    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
    p1.add(l1);
    p1.add(num1);
    JPanel p2 = new JPanel();
    p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
    p2.add(l2);
    p2.add(num2);

    JPanel p3 = new JPanel();
    p3.setLayout(new GridLayout(5, 1));
    p3.add(p1);
    p3.add(p2);

    this.setLayout(new BorderLayout());
    this.add(p3, BorderLayout.NORTH);
    this.add(divide, BorderLayout.SOUTH);
    divide.addActionListener(new ListenForButton());
    this.add(l3, BorderLayout.CENTER);
    this.setSize(250, 250);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("divider");
  }

  private class ListenForButton implements ActionListener{
    public void actionPerformed(ActionEvent e){
      try{
        Integer n1 = Integer.parseInt(num1.getText());
        Integer n2 = Integer.parseInt(num2.getText());
        num1.setText("");
        num2.setText("");
        n1 = n1/n2;
        l3.setText("Result: "+n1);
      }catch(Exception exc){
        num1.setText("");
        num2.setText("");
        l3.setText("");

        // JFrame error = new JFrame("Exception");
        JLabel err_label = new JLabel(exc.getMessage());
        // error.add(err_label);
        // error.setVisible(true);
        JDialog msg = new JDialog();
        msg.add(err_label);
        msg.setTitle("Error Message");
        msg.setSize(200, 200);
        msg.setVisible(true);
      }
    }
  }

  public static void main(String[] args){
    new DivideNums();
  }
}
