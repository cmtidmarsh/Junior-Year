import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class C322ParserFSM{
    private ParserFSM fsm;

    public C322ParserFSM() {
        this.fsm = new ParserFSM();
    }

    public void nextInt(int x){
        this.fsm.nextInt(x);
    }


    public static void main(String[] args) throws IOException {
        String t1 = "00001";
        String t2 = "00011001";
        String t3 = "11111";
        BufferedReader in1 = new BufferedReader(new StringReader(t1));
        BufferedReader in2 = new BufferedReader(new StringReader(t2));
        BufferedReader in3 = new BufferedReader(new StringReader(t3));
        boolean check = true;
        C322ParserFSM ourFSM = new C322ParserFSM();

        while(in1.ready()){
            int ch = in1.read();
            ourFSM.nextInt(ch);
        }

        System.out.println("done");

    }
}


class ParserFSM{
    private ParserState state;

    ParserFSM(){
        state = new stateAP();
    }

    void setState(ParserState s){
        state = new stateAP();
    }


    void nextInt(int x){
        this.state.nextInt(x);
    };

    abstract class ParserState{
       void nextInt(int x){};
    }

    class stateAP extends ParserState{
        void nextInt(int x){
            if(x == 0){
                setState(new stateAQ());
            }
            else{
                setState(new stateBP());
            }

        };
    }
    class stateAQ extends ParserState{
        void nextInt(int x){
            if(x == 0){
                setState(new stateAQ());
            }
            else{
                setState(new stateBR());
            }
        };
    }

    class stateBP extends ParserState{
        void nextInt(int x){
            if(x == 0){
                setState(new stateCQ());
            }
            else{
                setState(new stateBP());
            }
        };
    }

    class stateBR extends ParserState{
        void nextInt(int x){
            if(x == 0){
                setState(new stateCQ());
            }
            else{
                setState(new stateBP());
            }
        };
    }

    class stateCQ extends ParserState{
        void nextInt(int x){
            if(x == 0){
                setState(new stateCQ());
            }
            else{
                setState(new stateCR());
            }
        };
    }

    class stateCP extends ParserState{
        void nextInt(int x){
            if(x == 0){
                setState(new stateCQ());
            }
            else{
                setState(new stateCP());
            }
        };
    }

    class stateCR extends ParserState{
        void nextInt(int x){
            if(x == 0){
                setState(new stateCQ());
            }
            else{
                setState(new stateCP());
            }
        };
    }
}