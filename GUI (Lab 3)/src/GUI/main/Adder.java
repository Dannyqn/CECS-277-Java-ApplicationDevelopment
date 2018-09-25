package GUI.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Adder extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 150;
	
	private static final int DEFAULT_VALUE = 0;
	
	private JTextField addEnd1TextField,addEnd2TextField,sumTextField;
	private JLabel addEnd1Label, addEnd2Label, sumLabel;
	private JPanel AdderPanel;
	private JButton addButton;
	private int sum;
	
	public Adder(){
		createAddEnd1TextField();
		createAddEnd2TextField();
		createSumTextField();
		createAddButton();
		createPanel();
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
	}
	public void createPanel(){
		AdderPanel = new JPanel();
		add(AdderPanel);
		AdderPanel.add(addEnd1Label);
		AdderPanel.add(addEnd1TextField);
		AdderPanel.add(addEnd2Label);
		AdderPanel.add(addEnd2TextField);
		AdderPanel.add(sumLabel);
		AdderPanel.add(sumTextField);
		AdderPanel.add(addButton);
	}
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int num1 = Integer.parseInt(addEnd1TextField.getText());
			int num2 = Integer.parseInt(addEnd2TextField.getText());
			sum = num1 + num2;
			sumTextField.setText("" + sum);
		}
	}
	public void createAddEnd1TextField(){
		
		addEnd1Label = new JLabel("Addend1");
		
		final int FIELD_WIDTH = 60;
		
		addEnd1TextField = new JTextField(FIELD_WIDTH);
		addEnd1TextField.setText("" + DEFAULT_VALUE);
	}
	public void createAddEnd2TextField(){
		
		addEnd2Label = new JLabel("Addend2");
		
		final int FIELD_WIDTH = 60;
		
		addEnd2TextField = new JTextField(FIELD_WIDTH);
		addEnd2TextField.setText("" + DEFAULT_VALUE);
	}
	public void createSumTextField(){
		
		sumLabel = new JLabel("Sum");
		
		final int FIELD_WIDTH = 60;
		
		sumTextField = new JTextField(FIELD_WIDTH);
		sumTextField.setText("" + DEFAULT_VALUE);
	}
	public void createAddButton(){
		addButton = new JButton("Add");
		
		ActionListener listener = new AddListener();
		addButton.addActionListener(listener);
	}

}
