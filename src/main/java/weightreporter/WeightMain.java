package weightreporter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WeightMain {

	public static void main(String[] args)
	{
		WeightPanel panel = new WeightPanel();
		
		panel.init();
		
		JFrame mainWindow = new JFrame();
		
		mainWindow.getContentPane().add(panel);
		
		mainWindow.addWindowListener
	    (new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
			System.exit(0);
		    }
		});
		
		mainWindow.setTitle ("Weight Reporter");
		mainWindow.pack();
		mainWindow.setVisible(true);
	}

}
