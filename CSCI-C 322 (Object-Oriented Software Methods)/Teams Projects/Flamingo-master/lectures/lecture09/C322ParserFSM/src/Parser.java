import java.io.*;

public class Parser {
    private static final int AP = 1;
    private static final int AQ = 2;
    private static final int BP = 3;
    private static final int BR = 4;
    private static final int CP = 5;
    private static final int CQ = 6;
    private static final int CR = 7;
    private static final int ERROR = 8;
    
    private ParserFSM fsm;

    public Parser() {
        fsm = new ParserFSM();
    }

    public void addZero() {
        fsm.addZero();
    }

    public void addOne() {
        fsm.addOne();
    }

    public boolean validState() {
        return fsm.isValid();
    }

    public boolean invalidState() {
        return fsm.isInvalid();
    }
}

abstract class ParserFSM {
    private ParserState state;

    ParserFSM() {
        state = new AP();
    }

    void setState(ParserState s) {
        state = s;
    }

    void addZero() {
        state.addZero(this);
    }

    void addOne() {
        state.addOne(this);
    }

    boolean isValid() {
        return state.validState();
    }

    boolean isInvalid() {
        return state.invalidState();
    }



    abstract class ParserState {
        abstract void addZero(ParserFSM fsm);
        abstract void addOne(ParserFSM fsm);

        boolean validState() {
            return false;
        }

        boolean invalidState() {
            return true;
        }
    }

    class AP extends ParserState {
        void addZero(ParserFSM fsm) {
            fsm.setState(new AQ());
        }

        void addOne(ParserFSM fsm) {
            fsm.setState(new BP());
        }
    }

    class AQ extends ParserState {
        void addZero(ParserFSM fsm) {
            fsm.setState(new AQ());
        }

        void addOne(ParserFSM fsm) {
            fsm.setState(new BR());
        }
    }

    class BP extends ParserState {
        void addZero(ParserFSM fsm) {
            fsm.setState(new CQ());
        }

        void addOne(ParserFSM fsm) {
            fsm.setState(new BP());
        }
    }

    class BR extends ParserState {
        void addZero(ParserFSM fsm) {
            fsm.setState(new CQ());
        }

        void addOne(ParserFSM fsm) {
            fsm.setState(new BP());
        }
    }

    class CP extends ParserState {
        void addZero(ParserFSM fsm) {
            fsm.setState(new CQ());
        }

        void addOne(ParserFSM fsm) {
            fsm.setState(new CP());
        }
    }

    class CQ extends ParserState {
        void addZero(ParserFSM fsm) {
            fsm.setState(new CQ());
        }

        void addOne(ParserFSM fsm) {
            fsm.setState(new CR());
        }
    }

    class CR extends ParserState {
        void addZero(ParserFSM fsm) {
            fsm.setState(new CQ());
        }

        void addOne(ParserFSM fsm) {
            fsm.setState(new CP());
        }
    }
}
