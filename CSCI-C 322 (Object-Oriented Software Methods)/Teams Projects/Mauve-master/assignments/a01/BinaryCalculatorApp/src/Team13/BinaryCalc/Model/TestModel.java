package Team13.BinaryCalc.Model;

public class TestModel {

    public static void main(String[] args) {
        boolean testsPassed = true;
        Model model;

        //test add
        model = new Model();

        model.setFirstOperand("100");
        model.setOperation(new AddOperation());
        model.setSecondOperand("001");
        testsPassed = model.getResult().equals("101");
        System.out.println("Add Test Passed: " + String.valueOf(testsPassed));

        //test subtract
        model = new Model();

        model.setFirstOperand("100");
        model.setOperation(new SubtractOperation());
        model.setSecondOperand("001");
        testsPassed = model.getResult().equals("11");
        System.out.println("Subtract Test Passed: " + String.valueOf(testsPassed));

        //test clear
        model = new Model();

        model.setFirstOperand("100");
        model.setOperation(new SubtractOperation());
        model.setSecondOperand("001");
        model.clear();
        try{
            model.getResult();
        } catch (NullPointerException e){
            testsPassed = true;
        }
        System.out.println("Clear Test Passed: " + String.valueOf(testsPassed));
    }
}
