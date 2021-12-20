
public class Parser {
    private ParserFSM fsm;

    public Parser() {
        fsm = new ParserFSM();
    }

    public void setString(String str){ fsm.setString(str);}


    public boolean isValid() {
        return fsm.isValid();
    }

}
class ParserFSM {
    private ParserState state;

    ParserFSM() {
        state = new APState();
    }

    void setState(ParserState s) {
        state = s;
    }


    void reset() {
        state.reset(this);
    }

    boolean isValid() {
        return state.valid();
    }

    public void setString(String str)
    {
        char[] charArray = str.toCharArray();
        int index = 0;
        state = new APState();
        state.giveData(this, charArray, index);
    }



    abstract class ParserState {


        abstract void reset(ParserFSM fsm);



        abstract boolean valid();

        public abstract void giveData(ParserFSM fsm, char[] charArray, int index);
    }

    class APState extends ParserState
    {

        void reset(ParserFSM fsm) {
        }


        @Override
        boolean valid() {
            return false;
        }

        @Override
        public void giveData(ParserFSM fsm, char[] charArray, int index)
        {
            if(index == charArray.length) {
                return;
            }
            char current = charArray[index];
            if(current == '0')
            {
                index = index + 1;

                fsm.state = new AQState();
                fsm.state.giveData(fsm, charArray, index);
            }
            if(current == '1')
            {
                index = index + 1;
                fsm.state = new BPState();
                fsm.state.giveData(fsm, charArray, index);
            }

        }

    }

    class AQState extends ParserState
    {
        void reset(ParserFSM fsm) {
        }


        @Override
        boolean valid() {
            return false;
        }

        @Override
        public void giveData(ParserFSM fsm, char[] charArray, int index)
        {
            if(index == charArray.length) {
                return;
            }
            char current = charArray[index];
            if(current == '0')
            {
                index = index + 1;
                fsm.state = new AQState();
                fsm.state.giveData(fsm, charArray, index);
            }
            if(current == '1')
            {
                index = index + 1;
                fsm.state = new BRState();
                fsm.state.giveData(fsm, charArray, index );
            }
        }


    }

    class BRState extends ParserState {

        void reset(ParserFSM fsm) {
            fsm.setState(new APState());
        }

        @Override
        boolean valid() {
            return true;
        }

        @Override
        public void giveData(ParserFSM fsm, char[] charArray, int index)
        {
            if(index == charArray.length) {
                return;
            }
            char current = charArray[index];
            if(current == '0')
            {
                index = index + 1;
                fsm.state = new CQState();
                fsm.state.giveData(fsm, charArray, index);
            }
            if(current == '1')
            {
                index = index + 1;
                fsm.state = new BPState();
                fsm.state.giveData(fsm, charArray, index);
            }
        }

    }
    class BPState extends ParserState {

        void reset(ParserFSM fsm) {
            fsm.setState(new APState());
        }

        @Override
        boolean valid() {
            return false;
        }

        @Override
        public void giveData(ParserFSM fsm, char[] charArray, int index) {

        }

    }
    class CPState extends ParserState {


        void reset(ParserFSM fsm) {
            fsm.setState(new APState());
        }

        @Override
        boolean valid() {
            return false;
        }

        @Override
        public void giveData(ParserFSM fsm, char[] charArray, int index) {
            if(index == charArray.length) {
                return;
            }
            char current = charArray[index];
            if(current == '0')
            {
                index = index + 1;
                fsm.state = new CQState();
                fsm.state.giveData(fsm, charArray, index);
            }
            if(current == '1')
            {
                index = index + 1;
                fsm.state = new BPState();
                fsm.state.giveData(fsm, charArray, index);
            }
        }

    }
    class CQState extends ParserState {


        void reset(ParserFSM fsm) {
            fsm.setState(new APState());
        }

        @Override
        boolean valid() {
            return false;
        }

        @Override
        public void giveData(ParserFSM fsm, char[] charArray, int index) {
            if(index == charArray.length) {
                return;
            }
            char current = charArray[index];
            if(current == '0')
            {
                index = index + 1;
                fsm.state = new CQState();
                fsm.state.giveData(fsm, charArray, index);
            }
            if(current == '1')
            {
                index = index + 1;
                fsm.state = new CRState();
                fsm.state.giveData(fsm, charArray, index);
            }
        }


    }
    class CRState extends ParserState {


        void reset(ParserFSM fsm) {
            fsm.setState(new APState());
        }



        @Override
        boolean valid() {
            return false;
        }

        @Override
        public void giveData(ParserFSM fsm, char[] charArray, int index) {
            if(index == charArray.length) {
                return;
            }
            char current = charArray[index];
            if(current == '0')
            {
                index = index + 1;
                fsm.state = new CQState();
                fsm.state.giveData(fsm, charArray, index);
            }
            if(current == '1')
            {
                index = index + 1;
                fsm.state = new CPState();
                fsm.state.giveData(fsm, charArray, index);
            }
        }


    }
}
