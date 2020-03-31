/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatttt;

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;

/**
 *
 * @author aizan
 */
public class Dialogbox {
    private static JDialog d;  
    boolean player;
    
    Dialogbox() 
    {  
        JFrame f= new JFrame();  
        d = new JDialog(f , "tic tac toe", true);  
        d.setLayout(new FlowLayout());  
        
        JButton x=new JButton("X");//creating instance of JButton  
        x.setBounds(270, 170, 100, 80);  
        
        JButton o=new JButton("O");//creating instance of JButton  
        o.setBounds(270, 270, 100, 80);
        
        x.addActionListener (new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                 player = true;
                 Dialogbox.d.setVisible(false);
            }  
        });  
        
        o.addActionListener (new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                 player = false;
                 Dialogbox.d.setVisible(false);
            }  
        });

        d.add(x);//adding button in JFrame 
        d.add(o);//adding button in JFrame  

        d.setSize(700,700);//400 width and 500 height  
        d.setLayout(null);//using no layout managers  
        d.setVisible(true);//making the frame visible  
    } 
}
