/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatttt;

import java.util.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class gui extends JFrame{
    JFrame f;
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    boolean player;     //the mark sign the player chooses
    int lastmove = 90;  //last move made by the computer. Used to guide the player to the correct block.
    ArrayList<Integer> Xwins = new ArrayList();
    ArrayList<Integer> Owins = new ArrayList();
    
    
    gui(boolean p)  //prints the initial board.
    {
        player = p;
        
        f=new JFrame();//creating instance of JFrame
        
        // for loop is to initialize all the buttons 
        for( int i = 0; i < 81; i++ )
        {
           buttons.add( new JButton());
        }
        
        // following 27 loops are to set the colours of the blocks dif, so that the player may differntiate between them.
        for(int i=0; i<3; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //1
        }
        for(int i=3; i<6; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //2
        }
        for(int i=6; i<9; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //3
        }
        
        for(int i=9; i<12; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //1
        }
        for(int i=12; i<15; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //2
        }
        for(int i=15; i<18; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //3
        }
        
        for(int i=18; i<21; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //1
        }
        for(int i=21; i<24; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //2
        }
        for(int i=24; i<27; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //3
        }
        
        for(int i=27; i<30; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //4
        }
        for(int i=30; i<33; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //5
        }
        for(int i=33; i<36; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //6
        }
        
        for(int i=36; i<39; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //4
        }
        for(int i=39; i<42; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //5
        }
        for(int i=42; i<45; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //6
        }
        
        for(int i=45; i<48; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //4
        }
        for(int i=48; i<51; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //5
        }
        for(int i=51; i<54; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //6
        }
        
        for(int i=54; i<57; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //7
        }
        for(int i=57; i<60; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //8
        }
        for(int i=60; i<63; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //9
        }
        
        for(int i=63; i<66; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //7
        }
        for(int i=66; i<69; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //8
        }
        for(int i=69; i<72; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //9
        }
        
        for(int i=72; i<75; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //7
        }
        for(int i=75; i<78; i++)
        {
            buttons.get(i).setBackground(Color.YELLOW);  //8
        }
        for(int i=78; i<81; i++)
        {
            buttons.get(i).setBackground(Color.lightGray);  //9
        }
        
        // loop to add all the buttons to the frame
        for( int i = 0; i < 81; i++ )
        {
           f.add(buttons.get(i));
        }

        // using grid layout for the buttons 
        f.setLayout(new GridLayout(9,9));  
        //setting grid layout of 3 rows and 3 columns  

        f.setSize(900,900);  
        f.setVisible(true);
    }
    
    void move() //main function in which all the moves are taken.
    {
        String s, c;
        if(player == true)
        {
            s = "X";
            c = "O";
        }
        else
        {
            s= "O";
            c= "X";
        }
        
        JLabel l1;  //label for if the player takes a move in an already marked button.
        l1=new JLabel("Already taken move. Try again.");  
        l1.setBounds(200,200, 200,200);
        
        JLabel l2;  //label for if the player takes move in the wrong block.
        l2=new JLabel("Take move in correct block.");  
        l2.setBounds(200,200, 200,200);
        
        JLabel l3;  //label for if the player takes move in a block that the comp has already won  
        l3=new JLabel("Computer has already won in this block.");  
        l3.setBounds(200,200, 200,200);
        
        JLabel l4;  //label to let the player know that that the move block is not available for turn.
        l4=new JLabel("You have already won the move block or there is a tie so the computer will take move at random.");  
        l4.setBounds(200,200, 500, 500);
        
        //main for loop that contains actionlistener for all the buttons.
        for(int i=0; i<81; i++)
        {
            buttons.get(i).addActionListener ( new ActionListener()  
            {  
                public void actionPerformed( ActionEvent e )  
                {
                    for(int i=0; i<81; i++)
                    {
                        if(e.getSource() == buttons.get(i)) //checks which button is pressed
                        {
                            if(winner(i, c) == false || winner(i, s) == false)
                            {
                                if(checkmove(i) == true || lastmove==90)
                                {
                                    if(buttons.get(i).getText() != "X" && buttons.get(i).getText() != "O")
                                    {
                                        buttons.get(i).setText(s);
                                    }
                                    else
                                    {
                                        JDialog d = new JDialog(f , "Error", true);
                                        d.add(l1);
                                        d.setSize(700,700);//400 width and 500 height  
                                        d.setLayout(null);//using no layout managers  
                                        d.setVisible(true);//making the frame visible
                                    }
                                    if(winner(i, s) == false && tie(i) == false)
                                        compmove(i);
                                    else
                                    {
                                        JDialog d = new JDialog(f , "Error", true);
                                        d.add(l4);
                                        d.setSize(700,700);//400 width and 500 height  
                                        d.setLayout(null);//using no layout managers  
                                        d.setVisible(true);//making the frame visible
                                        randommove();
                                    }
                                }
                                else
                                {
                                    JDialog d = new JDialog(f , "Error", true);
                                    d.add(l2);
                                    d.setSize(700,700);//400 width and 500 height  
                                    d.setLayout(null);//using no layout managers  
                                    d.setVisible(true);//making the frame visible
                                }
                            }
                            else
                            {
                                JDialog d = new JDialog(f , "Error", true);
                                d.add(l3);
                                d.setSize(700,700);//400 width and 500 height  
                                d.setLayout(null);//using no layout managers  
                                d.setVisible(true);//making the frame visible
                            }
                        }
                    }
                }  
            });
        }
    }
    
    void randommove()
    {
        String sign;
        
        if(player == true)
            sign="O";
        else
            sign="X";
        
        for(int i=0; i<81; i++)
        {
            if(buttons.get(i).getText() != "X" && buttons.get(i).getText() != "O")
            {
                buttons.get(i).setText(sign);
                lastmove = i;
                break;
            }
        }
    }
    
    boolean tie(int i)
    {
        if(i==0||i==3||i==6||i==27||i==30||i==33||i==54||i==57||i==60)  //1
        {
            if(checktie(0, 21) == true)
                return true;
        }
        else if(i==1||i==4||i==7||i==28||i==31||i==34||i==55||i==58||i==61) //2
        {
            if(checktie(3, 24) == true)
                return true;
        }
        else if(i==2||i==5||i==8||i==29||i==32||i==35||i==56||i==59||i==62)    //3
        {
            if(checktie(6, 27) == true)
                return true;
        }
        else if(i==9||i==12||i==15||i==36||i==39||i==42||i==63||i==66||i==69) //4
        {
            if(checktie(27, 48) == true)
                return true;
        }
        else if(i==10||i==13||i==16||i==37||i==40||i==43||i==64||i==67||i==70) //5
        {
           if(checktie(30, 51) == true)
               return true;
        }
        else if(i==11||i==14||i==17||i==38||i==41||i==44||i==65||i==68||i==71) //6
        {
            if(checktie(33, 54) == true)
                return true;
        }
        else if(i==18||i==21||i==24||i==45||i==48||i==51||i==72||i==75||i==78) //7
        {
            if(checktie(54, 75) == true)
                return true;
        }
        else if(i==19||i==22||i==25||i==46||i==49||i==52||i==73||i==76||i==79) //8
        {
            if(checktie(57, 78) == true)
                return true;
        }
        else if(i==20||i==23||i==26||i==47||i==50||i==53||i==74||i==77||i==80) //9
        {
            if(checktie(60, 81) == true)
                return true;
        }
        return false;
    }
    
    boolean checktie(int s, int e)
    {
        int i=s, count=0;
        
        while(i<e)
        {
            if(buttons.get(i).getText() != "X" && buttons.get(i).getText() != "O")
            {
                return false;
            }
            count++;
            if(count==3)
            {
                i=i+7;
                count=0;
            }
            else
                i++;
        }
        return true;
    }
    
    boolean checkmove(int m)
    {
        int i=lastmove;
        if(i==0||i==3||i==6||i==27||i==30||i==33||i==54||i==57||i==60)  //1
        {
            if(takenmove(0, 21, m) == true)
                return true;
        }
        else if(i==1||i==4||i==7||i==28||i==31||i==34||i==55||i==58||i==61) //2
        {
            if(takenmove(3, 24, m) == true)
                return true;
        }
        else if(i==2||i==5||i==8||i==29||i==32||i==35||i==56||i==59||i==62)    //3
        {
            if(takenmove(6, 27, m) == true)
                return true;
        }
        else if(i==9||i==12||i==15||i==36||i==39||i==42||i==63||i==66||i==69) //4
        {
            if(takenmove(27, 48, m) == true)
                return true;
        }
        else if(i==10||i==13||i==16||i==37||i==40||i==43||i==64||i==67||i==70) //5
        {
           if(takenmove(30, 51, m) == true)
               return true;
        }
        else if(i==11||i==14||i==17||i==38||i==41||i==44||i==65||i==68||i==71) //6
        {
            if(takenmove(33, 54, m) == true)
                return true;
        }
        else if(i==18||i==21||i==24||i==45||i==48||i==51||i==72||i==75||i==78) //7
        {
            if(takenmove(54, 75, m) == true)
                return true;
        }
        else if(i==19||i==22||i==25||i==46||i==49||i==52||i==73||i==76||i==79) //8
        {
            if(takenmove(57, 78, m) == true)
                return true;
        }
        else if(i==20||i==23||i==26||i==47||i==50||i==53||i==74||i==77||i==80) //9
        {
            if(takenmove(60, 81, m) == true)
                return true;
        }
        return false;
    }
    
    boolean takenmove(int s, int e, int m)
    {
        int i=s, count=0;
        
        while(i<e)
        {
            if(i==m)
            {
                return true;
            }
            count++;
            if(count==3)
            {
                i=i+7;
                count=0;
            }
            else
                i++;
        }
        return false;
    }
    
    void compmove(int i)
    {
        if(i==0||i==3||i==6||i==27||i==30||i==33||i==54||i==57||i==60)  //1
        {
            takemove(0, 21);
        }
        else if(i==1||i==4||i==7||i==28||i==31||i==34||i==55||i==58||i==61) //2
        {
            takemove(3, 24);
        }
        else if(i==2||i==5||i==8||i==29||i==32||i==35||i==56||i==59||i==62)    //3
        {
            takemove(6, 27);
        }
        else if(i==9||i==12||i==15||i==36||i==39||i==42||i==63||i==66||i==69) //4
        {
            takemove(27, 48);
        }
        else if(i==10||i==13||i==16||i==37||i==40||i==43||i==64||i==67||i==70) //5
        {
            takemove(30, 51);
        }
        else if(i==11||i==14||i==17||i==38||i==41||i==44||i==65||i==68||i==71) //6
        {
            takemove(33, 54);
        }
        else if(i==18||i==21||i==24||i==45||i==48||i==51||i==72||i==75||i==78) //7
        {
            takemove(54, 75);
        }
        else if(i==19||i==22||i==25||i==46||i==49||i==52||i==73||i==76||i==79) //8
        {
            takemove(57, 78);
        }
        else if(i==20||i==23||i==26||i==47||i==50||i==53||i==74||i==77||i==80) //9
        {
            takemove(60, 81);
        }
    }
    
    void takemove(int s, int e)
    {
        int i=s, count=0, flag=0;
        String sign;
        
        if(player == true)
            sign="O";
        else
            sign="X";
        
        while(i<e && flag==0)
        {
            if(buttons.get(i).getText() != "X" && buttons.get(i).getText() != "O")
            {
                buttons.get(i).setText(sign);
                lastmove=i;
                flag=1;
            }
            count++;
            if(count==3)
            {
                i=i+7;
                count=0;
            }
            else
                i++;
        }
    }
    
    boolean winner(int i, String p)
    {
        if(i==0||i==3||i==6||i==27||i==30||i==33||i==54||i==57||i==60)  //1
        {
            if(checkwinner(0, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(1)==false)
                        Xwins.add(1);
                }
                else
                {
                    if(Owins.contains(1)==false)
                        Owins.add(1);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            } 
        }
        else if(i==1||i==4||i==7||i==28||i==31||i==34||i==55||i==58||i==61) //2
        {
            if(checkwinner(3, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(2)==false)
                        Xwins.add(2);
                }
                else
                {
                    if(Owins.contains(2)==false)
                        Owins.add(2);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            }
        }
        else if(i==2||i==5||i==8||i==29||i==32||i==35||i==56||i==59||i==62)    //3
        {
            if(checkwinner(6, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(3)==false)
                        Xwins.add(3);
                }
                else
                {
                    if(Owins.contains(3)==false)
                        Owins.add(3);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            }
        }
        else if(i==9||i==12||i==15||i==36||i==39||i==42||i==63||i==66||i==69) //4
        {
            if(checkwinner(27, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(4)==false)
                        Xwins.add(4);
                }
                else
                {
                    if(Owins.contains(4)==false)
                        Owins.add(4);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            }
        }
        else if(i==10||i==13||i==16||i==37||i==40||i==43||i==64||i==67||i==70) //5
        {
            if(checkwinner(30, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(5)==false)
                        Xwins.add(5);
                }
                else
                {
                    if(Owins.contains(5)==false)
                        Owins.add(5);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            }
        }
        else if(i==11||i==14||i==17||i==38||i==41||i==44||i==65||i==68||i==71) //6
        {
            if(checkwinner(33, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(6)==false)
                        Xwins.add(6);
                }
                else
                {
                    if(Owins.contains(6)==false)
                        Owins.add(6);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            }
        }
        else if(i==18||i==21||i==24||i==45||i==48||i==51||i==72||i==75||i==78) //7
        {
            if(checkwinner(54, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(7)==false)
                        Xwins.add(7);
                }
                else
                {
                    if(Owins.contains(7)==false)
                        Owins.add(7);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            }
        }
        else if(i==19||i==22||i==25||i==46||i==49||i==52||i==73||i==76||i==79) //8
        {
            if(checkwinner(57, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(8)==false)
                        Xwins.add(8);
                }
                else
                {
                    if(Owins.contains(8)==false)
                        Owins.add(8);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            }
        }
        else if(i==20||i==23||i==26||i==47||i==50||i==53||i==74||i==77||i==80) //9
        {
            if(checkwinner(60, p) == true)
            {
                if(p=="X")
                {
                    if(Xwins.contains(9)==false)
                        Xwins.add(9);
                }
                else
                {
                    if(Owins.contains(9)==false)
                        Owins.add(9);
                }
                JLabel l1;  //label for if the player takes a move in an already marked button.
                l1=new JLabel("Wins of X  " + String.valueOf(Xwins.size()));  
                l1.setBounds(200,200, 200,200);
                
                JLabel l2;  //label for if the player takes a move in an already marked button.
                l2=new JLabel("Wins of O  " + String.valueOf(Owins.size()));  
                l2.setBounds(200,200, 200,200);
        
                JDialog d = new JDialog(f , "Score", true);
                d.add(l1);
                d.add(l2);
                d.setSize(700,700);//400 width and 500 height  
                d.setLayout(null);//using no layout managers  
                d.setVisible(true);//making the frame visible
                return true;
            }
        }
        return false;
    }
    
    boolean checkwinner(int s, String p)
    {
        if(buttons.get(s).getText()== p && buttons.get(s+1).getText()==p && buttons.get(s+2).getText()==p)
        {
            return true;
        }
        else if(buttons.get(s).getText()== p && buttons.get(s+9).getText()==p && buttons.get(s+18).getText()==p)
        {
            return true;
        }
        else if(buttons.get(s).getText()== p && buttons.get(s+10).getText()==p && buttons.get(s+20).getText()==p)
        {
            return true;
        }
        else if(buttons.get(s+9).getText()== p && buttons.get(s+10).getText()==p && buttons.get(s+11).getText()==p)
        {
            return true;
        }
        else if(buttons.get(s+18).getText()== p && buttons.get(s+19).getText()==p && buttons.get(s+20).getText()==p)
        {
            return true;
        }
        else if(buttons.get(s+1).getText()== p && buttons.get(s+10).getText()==p && buttons.get(s+19).getText()==p)
        {
            return true;
        }
        else if(buttons.get(s+2).getText()== p && buttons.get(s+11).getText()==p && buttons.get(s+20).getText()==p)
        {
            return true;
        }
        else if(buttons.get(s+2).getText()== p && buttons.get(s+10).getText()==p && buttons.get(s+18).getText()==p)
        {
            return true;
        }
        return false;
    }
}