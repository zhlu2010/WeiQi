package weiqi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class LegalMove {
	private int[] x;
	private boolean bw;
	private int size;
	public LegalMove() {
		size = 19;
		x = new int[size*size];
		reset();
	}
	public void reset() {
		bw = true;
		for(int i = 0; i<size; i++) {
			for(int j = 0; j< size; j++)
				x[i+j*size] = 0;
		}
	}
	public int size() {
		return size;
	}
	public int getColor(int i,int j) {
		return x[i+j*size];
	}
	public void nextQizi(int i, int j) {
		if(bw) {
			bw = !bw;
			setBlack(i, j);
		}else {
			bw = !bw;
			setWhite(i, j);
		}
		judgeTizi(i, j);
		
	}
	public void setBlack(int i, int j) {
		x[i+j*size] = 1;
	}
	public void setWhite(int i, int j) {
		x[i+j*size] = -1;
	}
	public void judgeTizi(int i, int j) {
		if(i>0) tizi(i-1, j);
		if(i<size-1) tizi(i+1, j);
		if(j>0) tizi(i,j-1);
		if( j < size -1) tizi(i, j+1);
		tizi(i,j);
	}
	
	public void tizi(int i, int j) {
		if(x[i+j*size] == 0) return;
		Stack<Integer> stack = new Stack<>();
		HashSet<Integer> hs = new HashSet<>();
		stack.push(i + j*size);
		while(!stack.isEmpty()) {
			int pos = stack.pop();
			hs.add(pos);
			//deadone.add(pos);
			int xpos = pos%19;
			int ypos = pos/19;
			if(xpos != 0) {
				int left = pos - 1;
				if(x[left] == x[pos] && !hs.contains(left)) {
					stack.push(left);				
				}else if(x[left] == 0) {
					return;
				}
			}
			if(xpos != size-1) {
				int right = pos +1;
				if(x[right] == x[pos] && !hs.contains(right)) {
					stack.push(right);				
				}else if(x[right] == 0) {
					return;
				}
			}
			if(ypos != 0) {
				int up = pos - 19;
				if(x[up] == x[pos] && !hs.contains(up)) {
					stack.push(up);				
				}else if(x[up] == 0) {
					return;
				}
			}
			if( ypos != size - 1) {
				int down = pos + 19;
				if(x[down] == x[pos] && !hs.contains(down)) {
					stack.push(down);				
				}else if(x[down] == 0) {
					return;
				}
			}
		}
		Iterator<Integer> iterator = hs.iterator();
		while(iterator.hasNext()) {
			x[iterator.next()] = 0;
		}
	}
	
}
