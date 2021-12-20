/*
contact josoell@iu.edu if you have questions about the code
i was on second team so third team may want to delete and add their contact info
*/
public class Model {
	public String operandOne;
	public String operandTwo;
	public char operation;

	// Getters and Setters for Operand One and Two
	public String getOperandOne() {
		return operandOne;
	}

	public String getOperandTwo() {
		return operandTwo;
	}

	public void setOperandOne(String value) {
		operandOne = value;
	}

	public void setOperandTwo(String value) {
		operandTwo = value;
	}

	// Getters and Setters for the Operation
	public char getOperation() {
		return operation;
	}

	public void setOperation(char value) {
		operation = value;
	}

	// Addition method - used toBinaryString() - returns the corresponding binary
	// string
	public String add() {
		int operandOneInt = Integer.parseInt(operandOne, 2);
		int operandTwoInt = Integer.parseInt(operandTwo, 2);
		int addedOperands = operandOneInt + operandTwoInt;
		return Integer.toBinaryString(addedOperands);
	}

	// Subtraction method - used toBinaryString() - returns the corresponding binary
	// string
	public String subtract() {
		int operandOneInt = Integer.parseInt(operandOne, 2);
		int operandTwoInt = Integer.parseInt(operandTwo, 2);
		int subbedOperands = operandOneInt - operandTwoInt;
		return Integer.toBinaryString(subbedOperands);
	}

	// Method to reset variables, not really sure if needed but whateva
	public void clear() {
		operandOne = "";
		operandTwo = "";
		operation = ' ';
	}
}
