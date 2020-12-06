import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MouseEvents extends JFrame{
  JFrame frame;
  JLabel xPos, yPos, message;

  MouseEvents(){
    frame = this;
    xPos = new JLabel("X : ");
    yPos = new JLabel("Y : ");
    message = new JLabel("message : ");
    JPanel p0 = new JPanel();
    p0.setLayout(new FlowLayout(FlowLayout.LEFT));
    p0.add(xPos);
    p0.add(yPos);

    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout(FlowLayout.CENTER));
    p1.add(message);

    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.add(p0);
    this.add(p1);
    this.addMouseListener(new ListenForMouse());
    this.addMouseMotionListener(new ListenForMouseMotion());
    this.setSize(350, 350);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Mouse Events");
  }

  private class ListenForMouseMotion extends MouseMotionAdapter{
    public void mouseMoved(MouseEvent e){
      xPos.setText("X : "+e.getX());
      yPos.setText("Y : "+e.getY());
    }
  }

  private class ListenForMouse extends MouseAdapter{
    public void mouseClicked(MouseEvent e){
      message.setText("message : mouse clicked");
    }

    public void mouseEntered(MouseEvent e){
      message.setText("message : mouse entered");
    }

    public void mouseExited(MouseEvent e){
      message.setText("message : mouse exited");
    }

    public void mousePressed(MouseEvent e){
      message.setText("message : mouse pressed");
    }

    public void mouseReleased(MouseEvent e){
      message.setText("message : mouse released");
    }
  }


  public static void main(String[] args){
    new MouseEvents();
  }
}
