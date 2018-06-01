package ch07;

/**
 * Created by wsn on 2018/5/20.
 */
class NoteX {
    public static final int MIDDLE_C = 0;
    public static final NoteX n = new NoteX();
}

class Instrument {
    public void play(int NoteX) {
        System.out.println("Instrument.play(int NoteX)");
    }
}

class WindX extends Instrument {
    public void play(NoteX n) {
        System.out.println("WindX.play(NoteX n)");
    }
}
public class WindErrorDemo {
    public static void tune(Instrument instrument) {
        instrument.play(NoteX.MIDDLE_C);
    }

    public static void main(String[] args) {
        WindX flute = new WindX();
        tune(flute);
    }
}
