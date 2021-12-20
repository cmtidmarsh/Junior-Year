import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class LanguageParser {
    private LanguageParserFSM fsm;

    public LanguageParser() {
        fsm = new LanguageParserFSM();
    }

    boolean accept(BufferedReader input) throws IOException {
        fsm.reset();
        while (input.ready() && !(fsm.getState() instanceof LanguageParserFSM.ErrorState)) {
           int ch = input.read();
           switch (ch) {
               case '1':
                   accept1();
                   break;
               case '0':
                   accept0();
                   break;
               case -1:
                   return fsm.getState() instanceof LanguageParserFSM.BRState;
               default:
                   acceptOther();
           }
        }

        return false;
    }

    void accept1() {
        fsm.accept1();
    }

    void accept0() {
        fsm.accept0();
    }

    void acceptOther() {
        fsm.acceptOther();
    }

    public static void main(String[] args) {
        LanguageParser parser = new LanguageParser();

        String t1 = "00001";
        String t2 = "00011001";
        String t3 = "11111";
        BufferedReader in1 = new BufferedReader(new StringReader(t1));
        BufferedReader in2 = new BufferedReader(new StringReader(t2));
        BufferedReader in3 = new BufferedReader(new StringReader(t3));

        boolean check = true;
        try {
            if (!parser.accept(in1)) {
                System.out.println(t1 + " was not accepted but is a valid string . ");
                check = false;
            }
            if (parser.accept(in2)) {
                System.out.println(t2 + " was accepted but is not a valid string . ");
                check = false;
            }
            if (parser.accept(in3)) {
                System.out.println(t3 + " was accepted but is not a valid string . ");
                check = false;
            }
        } catch (IOException ex) {
            System.err.println(" Error reading input ");
        }
        if (check) {
            System.out.println(" All tests passed ! ");
        }
    }
}

class LanguageParserFSM {
    private ParserState state;

    public LanguageParserFSM() {
       state = new APState();
    }

    void accept1() {
        state.accept1(this);
    }

    void accept0() {
        state.accept0(this);
    }

    void acceptOther() {
        state.acceptOther(this);
    }

    void setState(ParserState state) {
       this.state = state;
    }

    ParserState getState() {
        return state;
    }

    void reset() {
        state = new APState();
    }

    abstract class ParserState {
        abstract void accept1(LanguageParserFSM fsm);

        abstract void accept0(LanguageParserFSM fsm);

        public void acceptOther(LanguageParserFSM fsm) {
            fsm.setState(new ErrorState());
        }
    }

    class APState extends ParserState {
        public void accept1(LanguageParserFSM fsm) {
            fsm.setState(new BPState());
        }

        public void accept0(LanguageParserFSM fsm) {
            fsm.setState(new AQState());
        }

    }

    class AQState extends ParserState {
        public void accept1(LanguageParserFSM fsm) {
            fsm.setState(new BRState());
        }

        public void accept0(LanguageParserFSM fsm) {
            fsm.setState(new AQState());
        }

    }

    class BPState extends ParserState {
        public void accept1(LanguageParserFSM fsm) {
            fsm.setState(new BPState());
        }

        public void accept0(LanguageParserFSM fsm) {
            fsm.setState(new CQState());
        }

    }
    class BRState extends ParserState {
        public void accept1(LanguageParserFSM fsm) {
            fsm.setState(new BPState());
        }

        public void accept0(LanguageParserFSM fsm) {
            fsm.setState(new CQState());
        }

    }
    class CPState extends ParserState {
        public void accept1(LanguageParserFSM fsm) {
            fsm.setState(new CPState());
        }

        public void accept0(LanguageParserFSM fsm) {
            fsm.setState(new CQState());
        }

    }
    class CQState extends ParserState {
        public void accept1(LanguageParserFSM fsm) {
            fsm.setState(new CRState());
        }

        public void accept0(LanguageParserFSM fsm) {
            fsm.setState(new CQState());
        }

    }
    class CRState extends ParserState {
        public void accept1(LanguageParserFSM fsm) {
            fsm.setState(new CPState());
        }

        public void accept0(LanguageParserFSM fsm) {
            fsm.setState(new CQState());
        }

    }
    class ErrorState extends ParserState {
        public void accept1(LanguageParserFSM fsm) {
            fsm.setState(new ErrorState());
        }

        public void accept0(LanguageParserFSM fsm) {
            fsm.setState(new ErrorState());
        }
    }
}