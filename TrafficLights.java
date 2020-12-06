import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrafficLights extends JFrame{
  JRadioButton red, green, yellow;
  // Box G;
  ButtonGroup G;
  JLabel message;

  TrafficLights(){
    red = new JRadioButton("Red");
    red.addActionListener(new ListenForRadio());
    green = new JRadioButton("Green");
    green.addActionListener(new ListenForRadio());
    yellow = new JRadioButton("Yellow");
    yellow.addActionListener(new ListenForRadio());
    message = new JLabel("message: ");
    Box B = Box.createVerticalBox();

    G = new ButtonGroup();
    G.add(red);
    G.add(green);
    G.add(yellow);

    JPanel p1 = new JPanel();
    p1.add(message);

    B.add(red);
    B.add(green);
    B.add(yellow);

    this.setLayout(new GridLayout(2,1));
    this.add(B);
    this.add(p1);
    this.setSize(400, 400);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private class ListenForRadio implements ActionListener{
    public void actionPerformed(ActionEvent e){
      JRadioButton btn = (JRadioButton)e.getSource();
      String txt = btn.getText();

      if(txt.equals("Red")){
        message.setText("<html><h1>Stop</h1><div style=\"width:'100';height:'100';background:'red'\"></div></html>");
      }else if(txt.equals("Green")){
        message.setText("<html><h1>Go</h1><div style=\"width:'100';height:'100';background:'green'\"></div></html>");
      }else{
        message.setText("<html><h1>Ready</h1><div style=\"width:'100';height:'100';background:'yellow'\"></div></html>");
      }
    }
  }

  public static void main(String[] args){
    new TrafficLights();
  }
}
