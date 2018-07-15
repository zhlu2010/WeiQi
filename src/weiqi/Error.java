package weiqi;
import java.awt.*;
import javax.swing.*;

public class Error extends JFrame{
	public Error() {
		super("Error");
		setSize(300,150);
		setLocation(600,400);
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel l1 = new JLabel("Illegal Move!");
		l1.setBounds(110,40,160,30);
		c.add(l1);
		
	}
}
