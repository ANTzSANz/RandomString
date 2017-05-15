import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {
	private JTextField number1;
	private JTextField number2;
	private JTextField resultField;

	public Window() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocation(20, 20);

		setVisible(true);

		setResizable(true);

		setSize(680, 350);
		getContentPane().setLayout(null);

		JLabel inpLbl1 = new JLabel(
				"\u0412\u0412\u0415\u0414\u0418\u0422\u0415 \u041F\u0415\u0420\u0412\u041E\u0415 \u0427\u0418\u0421\u041B\u041E:");
		inpLbl1.setHorizontalAlignment(SwingConstants.CENTER);
		inpLbl1.setBackground(Color.CYAN);
		inpLbl1.setBounds(126, 23, 180, 40);
		getContentPane().add(inpLbl1);

		JLabel inpLabel2 = new JLabel(
				"\u0412\u0412\u0415\u0414\u0418\u0422\u0415 \u0412\u0422\u041E\u0420\u041E\u0415 \u0427\u0418\u0421\u041B\u041E:");
		inpLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		inpLabel2.setBackground(Color.CYAN);
		inpLabel2.setBounds(126, 74, 180, 40);
		getContentPane().add(inpLabel2);

		number1 = new JTextField();
		number1.setHorizontalAlignment(SwingConstants.CENTER);
		number1.setBounds(339, 33, 100, 20);
		getContentPane().add(number1);
		number1.setColumns(10);

		number2 = new JTextField();
		number2.setHorizontalAlignment(SwingConstants.CENTER);
		number2.setColumns(10);
		number2.setBounds(339, 84, 100, 20);
		getContentPane().add(number2);

		JButton plusBtn = new JButton("plus (+)");
		plusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean numbersChecked = checkNumbers();
				
				if(!numbersChecked){
					resultField.setText("Input numbers");
				}else{

				int num1 = Integer.valueOf(number1.getText());
				int num2 = Integer.valueOf(number2.getText());
				int result = getResult(num1, num2, "+");
				resultField.setText(String.valueOf(result));
				getContentPane().repaint();

			}
			}
		});
		plusBtn.setBounds(10, 144, 135, 40);
		getContentPane().add(plusBtn);

		JButton minusBtn = new JButton("minus (-)");
		minusBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int num1 = Integer.valueOf(number1.getText());
				int num2 = Integer.valueOf(number2.getText());
				int result = getResult(num1, num2, "-");
				resultField.setText(String.valueOf(result));
				getContentPane().repaint();
			}
		});
		minusBtn.setBounds(171, 144, 135, 40);
		getContentPane().add(minusBtn);

		JButton multiplyBtn = new JButton("multiply (*)");
		multiplyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int num1 = Integer.valueOf(number1.getText());
				int num2 = Integer.valueOf(number2.getText());
				int result = getResult(num1, num2, "*");
				resultField.setText(String.valueOf(result));
				getContentPane().repaint();
			}
		});
		multiplyBtn.setBounds(339, 144, 135, 40);
		getContentPane().add(multiplyBtn);

		JButton divideBtn = new JButton("divide (/)");
		divideBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int num1 = Integer.valueOf(number1.getText());
				int num2 = Integer.valueOf(number2.getText());
				int result = getResult(num1, num2, "/");
				resultField.setText(String.valueOf(result));
				getContentPane().repaint();
			}
		});
		divideBtn.setBounds(506, 144, 135, 40);
		getContentPane().add(divideBtn);

		JLabel resultLbl = new JLabel("\u0420\u0415\u0417\u0423\u041B\u042C\u0422\u0410\u0422:");
		resultLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultLbl.setBackground(Color.CYAN);
		resultLbl.setBounds(126, 225, 180, 40);
		getContentPane().add(resultLbl);

		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setHorizontalAlignment(SwingConstants.CENTER);
		resultField.setColumns(10);
		resultField.setBounds(339, 235, 100, 20);
		getContentPane().add(resultField);
		getContentPane().repaint();

	}

	public boolean checkNumbers() {
		boolean numbersChecked = false;

		char[] symbols1 = number1.getText().toCharArray();
		for (char symbol1 : symbols1) {
			if (!Character.isDigit(symbol1)) {
				numbersChecked = false;
			}
		}
		if (numbersChecked) {
			char[] symbols2 = number2.getText().toCharArray();
			for (char symbol2 : symbols2) {
				if (!Character.isDigit(symbol2)) {
					numbersChecked = false;
				}
			}

		}

		return numbersChecked;

	}

	public int getResult(int num1, int num2, String string) {
		
		
		
		int result = 0;
		if (string.equals("+")) {
			result = num1 + num2;
		}
		if (string.equals("-")) {
			result = num1 - num2;
		}
		if (string.equals("*")) {
			result = num1 * num2;
		}
		if (string.equals("/")) {
			result = num1 / num2;
		}

		return result;
	}
}
