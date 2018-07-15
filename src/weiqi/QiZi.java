package weiqi;
import java.awt.*;

public class QiZi {
	//private int x;
	//private int y;
	//private boolean bw = true;
	public QiZi() {
		//this.x = x;
		//this.y = y;
	}
	public void drawblack(int x, int y,Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x-20, y-20, 40, 40);
	}
	public void drawwhite(int x, int y, Graphics g) {
		//g.drawOval(x-20, y-20, 40, 40);
		g.setColor(Color.WHITE);
		g.fillOval(x-19, y-19, 40, 40);
	}
}
