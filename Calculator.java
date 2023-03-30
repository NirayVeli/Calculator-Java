import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton, subtractButton, multiplyButton, divideButton;
	JButton decimalButton, equalsButton, deleteButton, clearButton;
	JPanel panel;
	
	double num1=0;
	double num2=0;
	double result=0;
	char operation;
	
	
	Calculator(){
		
		frame = new JFrame("Java Calculator");
		frame.setSize(550, 700);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(90, 30, 350, 60);
		textField.setEditable(false);
		
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		multiplyButton = new JButton("*");
		divideButton = new JButton("/");
		decimalButton = new JButton(".");
		equalsButton = new JButton("=");
		deleteButton = new JButton("Delete");
		clearButton = new JButton("Clear");
		
		
		functionButtons[0] = addButton;
		functionButtons[1] = subtractButton;
		functionButtons[2] = multiplyButton;
		functionButtons[3] = divideButton;
		functionButtons[4] = decimalButton;
		functionButtons[5] = equalsButton;
		functionButtons[6] = deleteButton;
		functionButtons[7] = clearButton;
		
		for(int i=0; i<8; i++) {
			functionButtons[i].addActionListener(this);
		}
		
		// add the numbers(0-9)
		
		for(int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
		}
		
		deleteButton.setBounds(80, 550, 150, 50);
		clearButton.setBounds(300, 550, 150, 50);
		
		// Panel for operations
		
		panel = new JPanel();
		panel.setBounds(62, 120, 400, 400);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		//first row
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		//second row
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subtractButton);
		
		//third row
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multiplyButton);
		
		//fourth row
		panel.add(decimalButton);
		panel.add(numberButtons[0]);
		panel.add(equalsButton);
		panel.add(divideButton);
		
// --------------------------------------------------
		frame.add(panel);
		frame.add(deleteButton);
		frame.add(clearButton);
		frame.add(textField);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// numbers
		for(int i = 0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()== decimalButton) {
			textField.setText(textField.getText().concat(String.valueOf(".")));
			
			// fix bug with infinite decimals
		}
		
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operation = '+';
			textField.setText("");
		}
		
		if(e.getSource() == subtractButton) {
			num1 = Double.parseDouble(textField.getText());
			operation = '-';
			textField.setText("");
		}

		if(e.getSource() == multiplyButton) {
			num1 = Double.parseDouble(textField.getText());
			operation = '*';
			textField.setText("");
		}

		if(e.getSource() == divideButton) {
			num1 = Double.parseDouble(textField.getText());
			operation = '/';
			textField.setText("");
		}

		if(e.getSource() == equalsButton) {
			num2 = Double.parseDouble(textField.getText());
			
			switch (operation) {
			case '+': 
				result = num1 + num2;
				break;
			case '-': 
				result = num1 - num2;
				break;
			case '*': 
				result = num1 * num2;
				break;
			case '/': 
				result = num1 / num2;
				break;
			}
			
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource() == clearButton) {
			textField.setText("");
			}
		
		if(e.getSource() == deleteButton) {
			String delNum = textField.getText();
			textField.setText("");
			for(int i = 0; i<delNum.length()-1; i++) {
				textField.setText(textField.getText()+delNum.charAt(i));
				}
			}
		}
}
