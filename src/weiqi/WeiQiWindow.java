package weiqi;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WeiQiWindow extends JFrame{
	private Drawboard db;
	public WeiQiWindow() {
		super("WeiQiPan");
		Container c = getContentPane();
		
		setSize(1100,1100);
		c.setBackground(new Color(168,168,0));
		c.setLayout(null);
		db = new Drawboard();
		db.setBounds(25,25,950,950);
		c.add(db);
		JButton b1 = new JButton("reset");
		b1.setBounds(300,2,100,23);
		c.add(b1);
		b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	db.resetAll();
            	db.repaint();
              
            }
    });
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
