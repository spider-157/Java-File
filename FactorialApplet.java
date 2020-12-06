import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.lang.Exception;


public class FactorialApplet extends Applet{
  static Label l1, l2;
  static TextField num;
  static Button compute;
  public void init(){
    l1 = new Label("Number1:");
    l2 = new Label("Factorial: ");
    num = new TextField(20);
    compute = new Button("compute");

    compute.addActionListener(new ListenerForButton());

    this.setLayout(new GridLayout(10, 1));
    this.add(l1);
    this.add(num);
    this.add(l2);
    this.add(compute);
  }

  private class ListenerForButton implements ActionListener{
    public void actionPerformed(ActionEvent e){
      try{
        Integer n = Integer.parseInt(num.getText());
        int fact = factorial(n);
        l2.setText("Factorial: "+fact);
        num.setText("");
      }catch(Exception exc){
        l2.setText("Enter a number");
        System.out.println(exc.getMessage());
      }
    }
  }

  public static int factorial(int n){
    if(n == 0 || n == 1){
      return 1;
    }else{
      return n*factorial(n-1);
    }
  }
}
