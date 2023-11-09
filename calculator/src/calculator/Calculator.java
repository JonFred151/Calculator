/*
 * @author JonFred151
 */
package calculator;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame implements ActionListener {
    // Creates Frame
    static JFrame f;
    // creates text field
    static JTextField l;
    
    //store operator and operands
    String s0, s1, s2 ;
    
    // default constructor
    Calculator()
    {
        s0 = s1 = s2 = ""; 
    }
    
    // main function
    public static void main(String[] args)
    {
       // Creates a frame 
        f = new JFrame("Calculator");
        
        try {
            // set looks and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        
        // create a object of class
        Calculator c = new Calculator();
        // create a textfield
        l = new JTextField(24);
        
        // set the text field to non editable
        l.setEditable(false);
        
        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
        
        // create number button
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        
        // equals button
        beq1 = new JButton("=");
        
        // Create operator button
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");
        
        //create . button
        be = new JButton(".");
        
        //create a panel
        JPanel p = new JPanel();
        
        // add action listener
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);
        
        // add elements to panel
        p.add(l); 
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(ba);
        p.add(bm);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);
        
        // set background of panel
        p.setBackground(Color.blue);
        
        // add panel to frame
        f.add(p);
        f.setSize(300,300);
        f.show();
                
          
        
    }
    public void actionPerformed(ActionEvent e)
    {
     String s = e.getActionCommand();
        
        // if the value is a number
        if ((s.charAt(0)>= '0' && s.charAt(0) <= '9') || s.charAt(0)== '.')
            {
                // if operand is present then add to second no
                if (!s1.equals(""))
                    s2 = s2 + s;
                else 
                    s0 = s0 + s;
                // set value of text 
                l.setText(s0 + s1 + s2);
            }
        else if (s.charAt(0) == 'C') 
            {
                s0 = s1 = s2 ="";
                
                l.setText(s0 + s1 + s2);
            }
        else if (s.charAt(0) == '=')
            {
            
                double te;

                //store the value in 1st
                if(s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else 
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                    
                //set the value of text
               l.setText(s0 + s1 + s2 + "=" + te);
               
               //convert it to string
               s0 = Double.toString(te);
               
               s1 = s2 = "";
               
            }
        else{
              // if there was no operand
              if (s1.equals("")|| s2.equals(""))
                  s1 = s;
              //else evalute
              else {
                     double te;
                     
                     // store the value in 1st
                     if(s.equals("+"))
                         te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                     else if (s1.equals("-"))
                         te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                     else if (s1.equals("/"))
                         te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                     else 
                         te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                     
                     // convert it to string
                     s0 = Double.toString(te);
                     
                     // place the operator
                     s1 = s;
                     
                     // make the operand blank
                     s2 = "";
                   }
              
              // set the value of text
              l.setText(s0 + s1 + s2);              
            }
    }
}
