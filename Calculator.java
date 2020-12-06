import javax.swing.*;
import javax.script.*;
import java.awt.*;
import java.awt.event.*;

class Calculator extends JFrame{

  static JTextField l;
  static JButton[] operators, buttons;
  static ScriptEngineManager manager = new ScriptEngineManager();
  static ScriptEngine engine = manager.getEngineByName("js");
  // String s0, s1, s2;

  public Calculator(){
    l = new JTextField(20);
    l.setEditable(false);

    ListenForButton lForButton = new ListenForButton();

    buttons = new JButton[10];
    for(int i=0; i<10; i++){
      buttons[i] = new JButton(Integer.toString(i));
      buttons[i].addActionListener(lForButton);
    }

    String[] opers = {"+", "-", "*", "/", "=", "C", "."};
    operators = new JButton[7];
    for(int i=0; i<7; i++){
      operators[i] = new JButton(opers[i]);
      operators[i].addActionListener(lForButton);
    }

    JPanel p = new JPanel();
    JPanel p0 = new JPanel();

    p.setLayout(new GridLayout(5,5));
    p0.add(l);
    for(JButton button : buttons){
      p.add(button);
    }
    for(JButton button : operators){
      p.add(button);
    }

    BoxLayout bl = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
    this.setLayout(bl);
    this.add(p0);
    this.add(p);
    this.setSize(250, 200);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("calculator");
  }

  //implement listeners
  private class ListenForButton implements ActionListener{
      public void actionPerformed(ActionEvent e){
        if(e.getSource() == operators[4]){
          try{
            System.out.println("\n"+engine.eval(l.getText()).toString());
            l.setText(engine.eval(l.getText()).toString());
          }catch(ScriptException exc){
            System.err.println(exc.getMessage());
          }
        }else if(e.getSource() == operators[5]){
          l.setText("");
        }else{
          Object o = e.getSource();
          JButton btn = null;
          if(o instanceof JButton){
            btn = (JButton)o;
          }

          if(btn != null){
            System.out.print(btn.getText());
            l.setText(l.getText()+btn.getText());
          }
        }
      }
  }

  public static void main(String[] args){
    new Calculator();
  }
}
