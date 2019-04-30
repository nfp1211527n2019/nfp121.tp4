package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Diana Kanaan
 */

public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    
    private PileModele<Integer> pile;
    
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        newActionListener AL = new newActionListener();
        boutons.add(push);  push.addActionListener(AL);
        boutons.add(add);   add.addActionListener(AL);
        boutons.add(sub);   sub.addActionListener(AL);
        boutons.add(mul);   mul.addActionListener(AL);
        boutons.add(div);   div.addActionListener(AL);
        boutons.add(clear); clear.addActionListener(AL);
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        
        if(pile.taille() <= 1  )
        {
            
            add.setEnabled(false);
            
            mul.setEnabled(false);
            
            sub.setEnabled(false);
            
            div.setEnabled(false);
                                     } 
        
        else 
        
        {
            add.setEnabled(true);
            
            mul.setEnabled(true);
            
            sub.setEnabled(true);
            
            div.setEnabled(true);
                                     }
        
        if(pile.estPleine()) 
        
        {
            push.setEnabled(false);
                                     }
       
        else 
        
        {
            push.setEnabled(true);
                                     }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

   
    class newActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
      {
        String aC = e.getActionCommand();
        
        if(aC.equals("[]"))
        {
            while(!pile.estVide())
            {
                try
                {
                    pile.depiler();
                }
                catch(PileVideException pve)
                {pve.printStackTrace();
                }
            }
        } 
        
        else 
        
        if(aC.equals("push"))
        
        {
            try
            {
                pile.empiler(operande());
            } catch(NumberFormatException nfe)
            {
            }
            catch(PilePleineException ppe) 
            {
                ppe.printStackTrace();
            }
        } 
        
        else 
        
        if (aC.equals("+") || aC.equals("*") || aC.equals("-") || aC.equals ("/") )
        
        {
            boolean badOp = false;
            
            int sp1,sp2,equal;
            
            sp1=0;
            
            sp2=0;
            
            equal=0;
            
            try{
                sp1 = pile.depiler();
                sp2 = pile.depiler();
            }
            catch(PileVideException pve)
            {
                pve.printStackTrace();
            }
                
            if(aC.equals("+")) 
            equal = sp2 + sp1;
            
            else 
            
            if(aC.equals("*"))
            
            equal = sp2 * sp1;
            
            else 
            
            if(aC.equals("-")) 
            
            equal = sp2 - sp1;
            
            else 
            
            if(aC.equals("/")) 
            {
                
                if(sp1 == 0) badOp = true;
                
                else equal = sp2 / sp1;
                
            }
            
            try
            {
                
                if(badOp)
                {
                    pile.empiler(sp2);
                    
                    pile.empiler(sp1);
                }
                else 
                pile.empiler(equal);
            }
            catch (PilePleineException ppe)
            {
                ppe.printStackTrace();}
        }
              actualiserInterface();
        }
    }

}
