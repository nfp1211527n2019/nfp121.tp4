package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class IHMQuestion2_1 extends JFrame {

    private JButton boutonA = new JButton("A");
    
    private JButton boutonB = new JButton("B");
    
    private JButton boutonC = new JButton("C");
    
    private JButtonObserver jbo1;
    
    private JButtonObserver jbo2;
    
    private JButtonObserver jbo3;
    
    private TextArea contenu = new TextArea(30, 80);

 
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();show();
        

        jbo1 = new JButtonObserver("jbo1", contenu);
        
        jbo2 = new JButtonObserver("jbo2", contenu);
        
        jbo3 = new JButtonObserver("jbo3", contenu);
        
        
        
        boutonC.addActionListener(jbo1);
        
        
        
        
        boutonB.addActionListener(jbo1);
        
        boutonB.addActionListener(jbo2);
        
        
        
        
        boutonA.addActionListener(jbo1);
        
        boutonA.addActionListener(jbo2);
        
        boutonA.addActionListener(jbo3);
       }
    
    public static void main(String[] args){
        new IHMQuestion2_1();
    }

}
