package weiqi;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Drawboard extends JPanel{
	private LegalMove legalmove;
	public Drawboard() {
		setSize(950,950);
		setBackground(new Color(195,195,0));
		
		legalmove = new LegalMove();
		XiaQi xiaqi = new XiaQi();
		addMouseListener(xiaqi);
		
		setVisible(true);
	}
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 25;i<=925;i+=50) {
			g.drawLine(i, 25, i, 925);
		    g.drawLine(25, i, 925, i);
		}
		g.fillOval(215, 215, 20, 18);
		g.fillOval(215, 715, 20, 18);
		g.fillOval(715, 215, 20, 18);
		g.fillOval(715, 715, 20, 18);
		
		QiZi qizi = new QiZi();
		int xloc, yloc;
		for(int i = 0; i< legalmove.size(); i++) {
			for(int j =0; j< legalmove.size(); j++) {
			xloc = 25+i*50;
			yloc = 25+j*50;
			if(legalmove.getColor(i,j) == 1) {
				qizi.drawblack(xloc,yloc,g);
			}else if (legalmove.getColor(i,j) == -1) {
				qizi.drawwhite(xloc,yloc,g);
			}
			}
		}
			
	}
	private class XiaQi implements MouseListener,MouseMotionListener{
		private int xloc;
		private int yloc;
		private Error error;
		
		public XiaQi() {
			error = new Error();
			error.setVisible(false);
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent e) {
			error.setVisible(false);
			xloc = e.getX()/50;
			yloc = e.getY()/50;
			if(legalmove.getColor(xloc,yloc) == 0) {
				legalmove.nextQizi(xloc, yloc);
			} else {
				error.setVisible(true);
			}
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {}

		@Override
		public void mouseDragged(MouseEvent arg0) {}

		@Override
		public void mouseMoved(MouseEvent arg0) {}
		
	}
	public void resetAll() {
		legalmove.reset();
	}
	
}
