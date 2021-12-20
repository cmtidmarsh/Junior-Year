import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
contact josoell@iu.edu if you have questions about the code
i was on second team so third team may want to delete and add their contact info
*/
public class Controller {
	public Model binaryModel;
	public View binaryView;

	public Controller(View binaryView, Model binaryModel) {
		this.binaryView = binaryView;
		this.binaryModel = binaryModel;
		// passes the equals button listener to the view so the view can add it to
		// equals buttons
		this.binaryView.addCalculateListener(new EqualsListener());
	}

	// these getters and setters seem pretty much useless but original team had them
	// so we made them
	// i wouldn't use them and only use the ones in the model and view so a team can
	// eventually delete these with no problem
	public String getOperandOne() {
		return binaryModel.getOperandOne();
	}

	public String getOperandTwo() {
		return binaryModel.getOperandTwo();
	}

	public void setOperandOne(String value) {
		binaryModel.setOperandOne(value);
	}

	public void setOperandTwo(String value) {
		binaryModel.setOperandTwo(value);
	}

	public void setOperation(char value) {
		binaryModel.setOperation(value);
	}

	// listens to the equals button in the view and when it is pressed
	// the listener calls the model to compute the result and passes it back to the
	// view
	// needs to be in the controller because only the controller
	// should be able to access the model
	class EqualsListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// sets the operands and operation in the view to variables that
			// the controller can access with view getters
			binaryView.setOps();
			String firstOperand = binaryView.getFirstOperand();
			String secondOperand = binaryView.getSecondOperand();
			char operation = binaryView.getOperation();

			binaryModel.setOperandOne(firstOperand);
			binaryModel.setOperandTwo(secondOperand);

			// expand this to a switch or if/elses to add multiplcation, division, etc.
			String result = operation == '+' ? binaryModel.add() : binaryModel.subtract();

			System.out
					.println(binaryModel.operandOne + " " + operation + " " + binaryModel.operandTwo + " = " + result);

			// gives the result of operation back to the view so it can display and stuff
			binaryView.setResult(result);
			// do we really need this?
			// i dont think so, but why not
			binaryModel.clear();
		}
	}

	public static void main(String[] args) {
		Model testModel = new Model();
		View testView = new View(500, 500);

		new Controller(testView, testModel);
	}
}
