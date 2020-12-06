import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Color;


class Table extends JFrame{

  JFileChooser fileChooser;
  JPanel tablePanel;
  JLabel path;
  JButton openFile;
  JFrame frame;

  Table(){
    frame = this;
    fileChooser = new JFileChooser();
    path = new JLabel("");
    tablePanel = new JPanel();
    openFile = new JButton("open file");
    openFile.addActionListener(new ListenForButton());
    //fileChooser.showOpenDialog(this);
    JPanel p0 = new JPanel();
    p0.setLayout(new FlowLayout(FlowLayout.LEFT));
    p0.add(openFile);
    p0.add(path);

    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.setSize(700, 700);
    this.add(p0);
    this.add(tablePanel);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("table");
  }

  //both class java.awt.List in java.awt and interface java.util.List in java.util match

  private class ListenForButton implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(e.getSource() == openFile){
        int result = fileChooser.showOpenDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION){
          File file = fileChooser.getSelectedFile();
          path.setText(file.getAbsolutePath());

          try{
            Scanner sc = new Scanner(file);
            ArrayList<String[]> textFile = new ArrayList<String[]>();
            while(sc.hasNextLine()){
              String[] arr = sc.nextLine().split(",");
              textFile.add(arr);
              for(String s : arr){
                System.out.print(s+" ");
              }
              System.out.println("");
            }
            System.out.println(textFile.size());
            tablePanel.setLayout(new GridLayout(textFile.size(),textFile.get(0).length));
            for(String[] arr : textFile){
              for(String str : arr){
                JLabel l = new JLabel(str);
                Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
                l.setBorder(border);
                tablePanel.add(l);
              }
            }
          }catch(FileNotFoundException exc){
            System.out.println(exc.getMessage());
          }

        }
      }
    }
  }

  public static void main(String[] args){
    new Table();
  }
}
