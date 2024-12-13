package gameMain;

import javax.swing.JFrame;

public class main { 

    public static void main(String[] args) {
       JFrame window = new JFrame(); 
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setResizable(false); //determines weither user can change the frame 
       window.setTitle("Game Resume");
       Panel gamePanel = new Panel (); 
       window.add(gamePanel); 
       window.pack(); //sizes the window 
       window.setVisible(true);
       window.setSize(800, 800);
       
       gamePanel.startGameThread(); 
    }
}
