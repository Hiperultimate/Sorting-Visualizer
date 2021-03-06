import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class SortingVisualizerV2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorting Visualizer");
		frame.setSize(1220,700);
		frame.getContentPane().setBackground( Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);				// Middle window
		Display d = new Display();
		frame.add(d);
		frame.setVisible(true);

		Scanner inp = new Scanner(System.in);
		System.out.println("Choose a sorting method\nSelection Sort -> 1\nBubble Sort -> 2\nInsertion Sort -> 3");
		int choose;
		choose = inp.nextInt();
		

		
		if(choose == 1) {
			d.SelectionSort();
		} else if(choose == 2){
			d.BubbleSort();
		} else if (choose == 3) {
			d.InsertionSort();
		}
		
		
		inp.close();
		
	}

}
