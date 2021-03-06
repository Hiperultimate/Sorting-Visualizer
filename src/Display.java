import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import java.util.Scanner;

public class Display extends JComponent{
	static int[] to_sort;
	public int highlight;
	public int hightlight2;
	
	public Display() {
		setLayout(null);
		Scanner input = new Scanner(System.in);
		Random index = new Random();
		
		System.out.print("Enter the amount of elements for visualizing : ");
		int total_elements = input.nextInt();
		to_sort = new int[total_elements];
		
		for(int i = 0; i < total_elements ; i++) {
			to_sort[i] = i + 1;
		}
		
		int setindex;
		int temp;
		
		for(int i = 0; i < total_elements ; i++) {
			setindex = index.nextInt(total_elements);
			if(i == setindex) {
				continue;
			} else {
				temp = to_sort[i];
				to_sort[i] = to_sort[setindex];
				to_sort[setindex] = temp;
			}	
		}
	}
	
	public void paintComponent(Graphics g) {
		repaint();
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.WHITE);
		double gap = -1200/to_sort.length;
		for(int i = 0; i < to_sort.length; i++) {
			if(highlight == i || hightlight2 == i) {
				g2.setColor(Color.GREEN);
			} else {
				g2.setColor(Color.WHITE);
			}
			g2.fill(new Rectangle2D.Double(((double)1200/to_sort.length) + gap, 660 - (to_sort[i]*( (double)1/to_sort.length )*100)*6, (double)1200/(double)to_sort.length ,(double)(to_sort[i]*( (double)1/to_sort.length )*100)*6));
			g2.setColor(Color.GRAY);
			g2.draw(new Rectangle2D.Double(((double)1200/to_sort.length) + gap, 660 - (to_sort[i]*( (double)1/to_sort.length )*100)*6, (double)1200/(double)to_sort.length ,(double)(to_sort[i]*( (double)1/to_sort.length )*100)*6));
			gap += (double)1200/(double)to_sort.length;
		}
	}
	
	public void SelectionSort() {
		int n = to_sort.length;
		 
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (to_sort[j] < to_sort[min_idx]) {
                    min_idx = j;
                    highlight = min_idx;
                	repaint();
                	try {
        				Thread.sleep(2);
        			} catch (InterruptedException e) {
        				// Do nothing
        			};
                 }
            }
            int temp = to_sort[min_idx];
            to_sort[min_idx] = to_sort[i];
            to_sort[i] = temp;
		}
		
	}
	
	
	
	public void BubbleSort() {
		int n = to_sort.length; 
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) { 
                if (to_sort[j] > to_sort[j+1]) { 
                    int temp = to_sort[j]; 
                    to_sort[j] = to_sort[j+1]; 
                    to_sort[j+1] = temp; 
                    hightlight2 = j+1;
                    repaint();
                    try {
        	    		Thread.sleep(2);
        	    	} catch (InterruptedException e) {
        	    		// Do nothing
        	    	};
                }
            }
	        
        }
	}
	
	public void InsertionSort() 
    { 
        int n = to_sort.length; 
        for (int i = 1; i < n; ++i) { 
            int key = to_sort[i]; 
            int j = i - 1; 
            while (j >= 0 && to_sort[j] > key) { 
            	to_sort[j + 1] = to_sort[j]; 
            	hightlight2 = j+1;
                repaint();
                try {
    	    		Thread.sleep(2);
    	    	} catch (InterruptedException e) {
    	    		// Do nothing
    	    	};
                j = j - 1; 
            } 
            to_sort[j + 1] = key; 
        } 
    }
	
}
