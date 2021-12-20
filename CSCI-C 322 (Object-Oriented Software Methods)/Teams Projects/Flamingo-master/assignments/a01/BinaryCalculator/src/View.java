import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JComponent {
	int width = 500;
	int height = 500;

	String firstOperand = "";
	String secondOperand = "";
	char operation = ' ';

	JButton calculateButton = new JButton("=");
	JButton plusButton = new JButton("+");
	JButton minusButton = new JButton("-");
	JButton oneButton = new JButton("1");
	JButton zeroButton = new JButton("0");
	JButton clearButton = new JButton("AC");

	JLabel display = new JLabel("0");

	// uncomment below if using Mac
	// JScrollPane scrollPane = new JScrollPane(display);

	public View(int width, int height) {
		// ----------------------------------------------
		// This is the code that works on Windows
		this.width = width;
		this.height = height;
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setSize(width, height);
		frame.setVisible(true);

		JPanel displayPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		displayPanel.add(display);

		buttonsPanel.setLayout(new GridLayout(3, 2));
		buttonsPanel.add(oneButton);
		buttonsPanel.add(zeroButton);
		buttonsPanel.add(minusButton);
		buttonsPanel.add(plusButton);
		buttonsPanel.add(calculateButton);
		buttonsPanel.add(clearButton);

		frame.add(displayPanel, BorderLayout.NORTH);
		frame.add(buttonsPanel, BorderLayout.CENTER);
		// ----------------------------------------------

		// ----------------------------------------------
		// This is the pretty layout that works on Mac
		/*
		 * this.width = width; this.height = height; JFrame frame = new JFrame();
		 * frame.add(this); frame.setSize(width, height);
		 * 
		 * JPanel panel = new JPanel();
		 * 
		 * panel.add(scrollPane); panel.add(oneButton); panel.add(zeroButton);
		 * panel.add(minusButton); panel.add(plusButton); panel.add(calculateButton);
		 * panel.add(clearButton);
		 * 
		 * frame.add(panel); frame.setVisible(true);
		 * 
		 * scrollPane.setBounds(0, 10, width, 50); oneButton.setBounds(0, 250, 70, 50);
		 * zeroButton.setBounds(0, 300, 140, 50); minusButton.setBounds(210, 150, 70,
		 * 50); plusButton.setBounds(210, 200, 70, 50); calculateButton.setBounds(210,
		 * 250, 70, 100); clearButton.setBounds(0, 100, 70, 50);
		 */
		// ----------------------------------------------

		// adds a "1" to the display when the button is pressed
		oneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (display.getText() == "0") {
					display.setText("1");
				} else {
					display.setText(display.getText() + "1");
				}
			}
		});

		// adds a "0" to the display when the button is pressed
		zeroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText(display.getText() + "0");
			}
		});

		// adds either a "+" or change from "-" to "+" when pressed
		plusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// split string into up to 3 parts: firstOp, operator, secondOp
				String[] array = display.getText().split(" ");
				if (array.length > 1) {
					// swap out operators
					if (array[1].equals("-")) {
						array[1] = "+";
					}
					String output = "";
					// turn array back into string for display
					for (int i = 0; i < array.length; i++) {
						if (i == 0) {
							output += array[i];
						} else {
							output += " " + array[i];
						}
					}
					display.setText(output);
				} else {
					// just add "+" if there's only the firstOp
					display.setText(display.getText() + " + ");
				}
			}
		});

		// adds either a "-" or change from "+" to "-" when pressed
		minusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// split string into up to 3 parts: firstOp, operator, secondOp
				String[] array = display.getText().split(" ");
				if (array.length > 1) {
					// swap out operators
					if (array[1].equals("+")) {
						array[1] = "-";
					}
					String output = "";
					// turn array back into string for display
					for (int i = 0; i < array.length; i++) {
						if (i == 0) {
							output += array[i];
						} else {
							output += " " + array[i];
						}
					}
					display.setText(output);
				} else {
					// just add "-" if there's only the firstOp
					display.setText(display.getText() + " - ");
				}
			}
		});

		// clears entire display when pressed
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText("0");
			}
		});
	}

	// getters so the controller can access the operands and operation to do the
	// calculations
	public String getFirstOperand() {
		return firstOperand;
	}

	public String getSecondOperand() {
		return secondOperand;
	}

	public char getOperation() {
		return operation;
	}

	public void setOps() {
		String[] array = display.getText().split(" ");
		if (array.length == 3) {
			firstOperand = array[0];
			operation = array[1].charAt(0);
			secondOperand = array[2];
		} else if (array.length == 1) {
			// fixes a weird bug that happens after adding/subbing, then concating numbers,
			// and hitting enter
			// keeps pressed numbers concated to result instead of deleting
			firstOperand = array[0];
			operation = '+';
			secondOperand = "0";
		}
	}

	// adds the calculate listener defined in the controller to the equal button
	// allows the controller to be notified when model adds and subtracts need
	// to be called
	public void addCalculateListener(ActionListener calculateButtonListener) {
		calculateButton.addActionListener(calculateButtonListener);
	}

	// changed name to setResult instead of getResult so method name would be
	// somewhat accurate
	// had to change this to take a param: result
	// should change the name of the method but this is what design team called it
	public void setResult(String result) {
		// set the text of the display to result
		display.setText(result);
	}
}
