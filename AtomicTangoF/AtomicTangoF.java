import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class AtomicTangoF extends JFrame {

     public static void main(String[] args) {

       JOptionPane.showMessageDialog(null, "Please enter your starting position");

       String start = position();

       JFrame frame = new JFrame("Position");
       JButton nextMove = new JButton();
       frame.setVisible(true);

       if(new File("pictures/" + start + ".JPG").exists()){
         frame.add(new JLabel(new ImageIcon("pictures/" + start + ".JPG")));
         frame.setSize(250, 325);
         frame.setLocationRelativeTo(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       } else {
         JLabel label = new JLabel("The Image was not found", SwingConstants.CENTER);
         frame.setSize(250, 325);
         frame.add(label);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       }

        frame.revalidate();
                nextMove.setSize(50, 25);
                nextMove.setVisible(true);
                nextMove.setText("Go to next move");



               JPanel buttonCenter = new JPanel( new FlowLayout(FlowLayout.CENTER) );
               buttonCenter.add(nextMove);
               frame.add(buttonCenter, BorderLayout.SOUTH);

               nextMove.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                       frame.setVisible(false);
                       newPosition(start);
                    }
                });



    }

    public static void newPosition(String start){
      Random rand = new Random();
      int r = rand.nextInt(7);

      String newPos = nextPos(r, start);
      System.out.println(newPos);
      JFrame frame = new JFrame("Position");

      if(new File("pictures/" + newPos + ".JPG").exists()){
        frame.add(new JLabel(new ImageIcon("pictures/" + newPos + ".JPG")));
        frame.setSize(250, 325);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      } else {
        JLabel label = new JLabel("The Image was not found", SwingConstants.CENTER);
        frame.setSize(250, 325);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }

      char [] a = newPos.toCharArray();

     System.out.println("You can go to this position:" +
              " Facing: " + f(Character.getNumericValue(a[0])) +
              " Weighted Foot: " + wF(Character.getNumericValue(a[1])) +
              " Unweighted Foot: " + uF(Character.getNumericValue(a[2])) +
              " Leaning: " + l(Character.getNumericValue(a[3])) +
              " Foot Contact: " + fC(Character.getNumericValue(a[4])) +
              " Thigh Contact: " + tC(Character.getNumericValue(a[5])) +
              " Height: " + h(Character.getNumericValue(a[6])));

     frame.setVisible(true);

     JButton restart = new JButton();
     restart.setSize(50, 25);
     restart.setVisible(true);
     restart.setText("Click to Restart");
     JPanel buttonCenter = new JPanel( new FlowLayout(FlowLayout.CENTER) );
     buttonCenter.add(restart);
     frame.add(buttonCenter, BorderLayout.SOUTH);

     restart.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
          {
             frame.setVisible(false);
             String [] args = new String[1];
             args[0] = "";
             main(args);
          }
      });

    }


    public static String nextPos(int i, String s){

      char[] digits = s.toCharArray();
      int numOfOptions = 0;

      switch (i) {
        case 0: numOfOptions = 4;
          break;
        case 1: numOfOptions = 3;
          break;
        case 2: numOfOptions = 10;
          break;
        case 3: numOfOptions = 3;
          break;
        case 4: numOfOptions = 5;
          break;
        case 5: numOfOptions = 4;
          break;
        case 6: numOfOptions = 2;
        break;
      }

      int num = Character.getNumericValue(digits[i]);
      int newNum = ((num + 1) + numOfOptions) % numOfOptions;
      digits[i] = Character.forDigit(newNum, 10);

      return new String(digits);

    }

    public static String position(){
      //String[] p = {p(0), p(1), p(2), p(3), p(4), p(5), p(6), p(7)};
      String[] f = {f(0), f(1), f(2), f(3)};
      String[] wF = {wF(0), wF(1), wF(2)};
      String[] uF = {uF(0), uF(1), uF(2), uF(3), uF(4), uF(5), uF(6), uF(7), uF(8), uF(9)};
      String[] l = {l(0), l(1), l(2)};
      String[] fC = {fC(0), fC(1), fC(2), fC(3), fC(4)};
      String[] tC = {tC(0), tC(1), tC(2), tC(3)};
      String[] h = {h(0), h(1)};

      //Object position = JOptionPane.showInputDialog(null, "Position", "Selection", JOptionPane.DEFAULT_OPTION, null, p, "0");
      Object facing = JOptionPane.showInputDialog(null, "Facing", "Selection", JOptionPane.DEFAULT_OPTION, null, f, "0");
      Object weightedFoot = JOptionPane.showInputDialog(null, "Weighted Foot", "Selection", JOptionPane.DEFAULT_OPTION, null, wF, "0");
      Object unweightedFoot = JOptionPane.showInputDialog(null, "Unweighted Foot", "Selection", JOptionPane.DEFAULT_OPTION, null, uF, "0");
      Object leaning = JOptionPane.showInputDialog(null, "Leaning", "Selection", JOptionPane.DEFAULT_OPTION, null, l, "0");
      Object footContact = JOptionPane.showInputDialog(null, "Foot Contact", "Selection", JOptionPane.DEFAULT_OPTION, null, fC, "0");
      Object thighContact = JOptionPane.showInputDialog(null, "Thigh Contact", "Selection", JOptionPane.DEFAULT_OPTION, null, tC, "0");
      Object height = JOptionPane.showInputDialog(null, "Height", "Selection", JOptionPane.DEFAULT_OPTION, null, h, "0");

      StringBuilder sb = new StringBuilder();
      //sb.append(Character.getNumericValue(position.toString().charAt(0)) - 1);
      sb.append(Character.getNumericValue(facing.toString().charAt(0)) - 1);
      sb.append(Character.getNumericValue(weightedFoot.toString().charAt(0)) - 1);
      if(Character.getNumericValue(unweightedFoot.toString().charAt(1)) == 0){ //this is because otherwise, both the first and last case will read as 0
        sb.append(9);
      } else {
        sb.append(Character.getNumericValue(unweightedFoot.toString().charAt(0)) - 1);
      }
      sb.append(Character.getNumericValue(leaning.toString().charAt(0)) - 1);
      sb.append(Character.getNumericValue(footContact.toString().charAt(0)) - 1);
      sb.append(Character.getNumericValue(thighContact.toString().charAt(0)) - 1);
      sb.append(Character.getNumericValue(height.toString().charAt(0)) - 1);

      return sb.toString();
    }

    /* Always North for this project
    public static String p(int n){
      switch(n){
        case 0: return "1. North";
        case 1: return "2. NorthEast";
        case 2: return "3. East";
        case 3: return "4. SouthEast";
        case 4: return "5. South";
        case 5: return "6. SouthWest";
        case 6: return "7. West";
        case 7: return "8. NorthWest";
      }
      return "";
    }
    */


    public static String f(int n){
      switch(n){
        case 0: return "1. Towards";
        case 1: return "2. Clockwise";
        case 2: return "3. Away";
        case 3: return "4. CounterClockwise";

      }
      return "";
    }
    public static  String wF(int n){
      switch(n){
      case 0: return "1. right";
      case 1: return "2. left";
      case 2: return "3. none";
    }
    return "";
    }
    public  static  String uF(int n){
      switch(n){
      case 0: return "1. collected";
      case 1: return "2. crossed left forward";
      case 2: return "3. crossed right forward";
      case 3: return "4. forward";
      case 4: return "5. backward";
      case 5: return "6. in air forward";
      case 6: return "7. in air back";
      case 7: return "8. slid out";
      case 8: return "9. back boleo";
      case 9: return "10. front boleo";

    } return "";
    }
    public  static  String l(int n){

      switch(n){
        case 0: return "1. netural";
        case 1: return "2. away";
        case 2: return "3. towards";
    }
    return "";

    }
    public  static  String fC(int n){
      switch(n){
       case 0: return "1. none";
       case 1: return "2. man foot inside female foot";
       case 2: return "3. man foot outside female foot";
       case 3: return "4. right man to right women";
       case 4: return "5. left man to left women";
      }
      return "";
    }
    public  static  String tC(int n){
      switch (n) {
        case 0: return "1. none";
        case 1: return "2. leg man back to leg woman back";
        case 2: return "3. leg man front to leg woman back";
        case 3: return "4. leg man back to leg woman front";
      }
      return "";

    }
    public  static  String h(int n){
      switch (n){
      case 0: return "1. High";
      case 1: return "2. Low";
    } return "";
    }

    public static String toString(String pos){
      char [] a = pos.toCharArray();

      return f(a[0]) + " " + wF(a[1]) + " " + uF(a[2]) + " " + l(a[3]) + " " + fC(a[4]) + " " + tC(a[5]) + " " + h(a[6]);
    }
}
