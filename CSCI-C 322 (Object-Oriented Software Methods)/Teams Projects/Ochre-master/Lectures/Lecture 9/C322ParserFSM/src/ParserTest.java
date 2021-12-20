

public class ParserTest {
    public static void main(String[] args) {
        Parser p = new Parser();
        System.out.println(" Initial state : " + parserState(p));
        testAP(p, "");
        testAQ(p, "000");
        testBR(p, "001");
        testBP(p, "111");
        testCQ(p, "100");
        testCR(p, "101");
        testCP(p, "1011");
        testString1(p, "00001");
        testString2(p, "00011001");
        testString3(p, "11111");
    }

    private static void testString1(Parser p, String s)
    {
        p.setString(s);
        System.out.println("testString1" + checkAgainstValidity(p, true));
    }

    private static void testString2(Parser p, String s)
    {
        p.setString(s);
        System.out.println("testString2" + checkAgainstValidity(p, false));
    }
    private static void testString3(Parser p, String s)
    {
        p.setString(s);
        System.out.println("testString3" + checkAgainstValidity(p, false));
    }


    private static void testAQ(Parser p, String s)
    {
        p.setString(s);
        System.out.println("testAQ" + checkAgainstValidity(p, false));
    }

    private static void testBR(Parser p, String s)
    {
        p.setString(s);
        System.out.println("testBR" + checkAgainstValidity(p, true));    }
    private static void testBP(Parser p, String s)
    {
        p.setString(s);
        System.out.println("testBP" + checkAgainstValidity(p, false));    }
    private static void testCQ(Parser p, String s)
    {
        p.setString(s);
        System.out.println("testCQ" + checkAgainstValidity(p, false));    }
    private static void testCR(Parser p, String s)
    {
        p.setString(s);
        System.out.println("testCR" + checkAgainstValidity(p, false));    }

    private static void testCP(Parser p, String s)
    {
        p.setString(s);
        System.out.println("TestCP" + checkAgainstValidity(p, false));    }
    private static void testAP(Parser p, String s)
    {
        p.setString(s);
        System.out.println("TestCP" + checkAgainstValidity(p, false));    }


    private static String checkAgainstValidity(Parser p, boolean wantedValidity)
    {
        return "Passed :" + (p.isValid() == wantedValidity);
    }

    private static String parserState(Parser p) {
        return " valid : " + p.isValid();
    }
}
