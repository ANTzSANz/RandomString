import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

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
		
		JLabel lblNewLabel = new JLabel("\u0412\u0412\u0415\u0414\u0418\u0422\u0415 \u041F\u0415\u0420\u0412\u041E\u0415 \u0427\u0418\u0421\u041B\u041E:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(171, 23, 135, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u0412\u0412\u0415\u0414\u0418\u0422\u0415 \u0412\u0422\u041E\u0420\u041E\u0415 \u0427\u0418\u0421\u041B\u041E:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.CYAN);
		label.setBounds(171, 74, 135, 40);
		getContentPane().add(label);
		
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
		plusBtn.setBounds(10, 144, 135, 40);
		getContentPane().add(plusBtn);
		
		JButton minusBtn = new JButton("minus (-)");
		minusBtn.setBounds(171, 144, 135, 40);
		getContentPane().add(minusBtn);
		
		JButton multiplyBtn = new JButton("multiply (*)");
		multiplyBtn.setBounds(339, 144, 135, 40);
		getContentPane().add(multiplyBtn);
		
		JButton divideBtn = new JButton("divide (/)");
		divideBtn.setBounds(506, 144, 135, 40);
		getContentPane().add(divideBtn);
		
		JLabel label_1 = new JLabel("\u0420\u0415\u0417\u0423\u041B\u042C\u0422\u0410\u0422:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(Color.CYAN);
		label_1.setBounds(171, 225, 135, 40);
		getContentPane().add(label_1);
		
		resultField = new JTextField();
		resultField.setEditable(false);
		resultField.setHorizontalAlignment(SwingConstants.CENTER);
		resultField.setColumns(10);
		resultField.setBounds(339, 235, 100, 20);
		getContentPane().add(resultField);
		
	}
}
