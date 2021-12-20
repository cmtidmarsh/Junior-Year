
public class CalcModel {
    private String firstOperand = "";
    private String secondOperand = "";
    private String operator;
    private String displayValue = "0";

    public String getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(String op) {
        this.firstOperand = op;
    }

    public String getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(String op) {
        this.secondOperand = op;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String op) {
        this.operator = op;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String dis) {
        this.displayValue = displayValue;
    }
    //TODO work on perfoming the operations
    //TODO Keeping it elegant and not converting the strings to decimal or anything
    public String performOperation() {
        String result = "";
	if(getOperator() == "+") {
        result = ""+Integer.toBinaryString(Integer.parseInt(getFirstOperand(), 2) + Integer.parseInt(getSecondOperand(), 2));

    } else if(getOperator() == "-") {
	    if (Integer.parseInt(getFirstOperand(), 2) < Integer.parseInt(getSecondOperand(), 2)) {
	        result = "-"+ Integer.toBinaryString(Integer.parseInt(getSecondOperand(), 2) - Integer.parseInt(getFirstOperand(), 2));
        } else {
            result = "" + Integer.toBinaryString(Integer.parseInt(getFirstOperand(), 2) - Integer.parseInt(getSecondOperand(), 2));
        }
	} else if(getOperator() == null) {
	    System.out.println("We are ... doing nothing");
	} else {
	 System.out.println("We aren't subtracting, we aren't adding, what are we doing?");
	}
        //here we do some magic to get rid of preceding 0s
        int temp = 0;
        //while(temp == 0) {
        //    if(result.substring(0, 1).equals("0")) {
        //        result = result.substring(1);
        //    } else {
        //        temp = 1;
        //    }
        //}
//        System.out.println(result);
        return result; //TODO
    }
}
