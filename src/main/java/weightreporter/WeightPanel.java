package weightreporter;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WeightPanel extends JPanel implements Runnable
{

	private JPanel mainPanel;
	private JTextField weightInput;
	private JLabel weightLabel;
	private JButton okButton;
	private double weight;
	
	public WeightPanel()
	{

	}
	
	public void init()
	{
		final WeightPanel self = this;
		
		mainPanel = new JPanel(new FlowLayout());
		
		//Changed the size of the main panel to accomodate the drawing and control panel
		mainPanel.setPreferredSize(new Dimension(250,100));
		
		//added to the main panel
		add(mainPanel);
		
		weightInput = new JTextField(20);
		
		weightLabel = new JLabel("Enter Weight");
		
		okButton = new JButton("OK");
		okButton.addActionListener (new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					weight = Double.parseDouble(weightInput.getText());
					
					WeightSheet newSheet = new WeightSheet();
					
					newSheet.outputExcel(weight);
					
					System.exit(0);
				} 
				catch (Exception ex) 
				{
					
				}
			}
		});
		
		add(mainPanel);
		
		mainPanel.add(weightLabel);
		mainPanel.add(weightInput);
		mainPanel.add(okButton);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
