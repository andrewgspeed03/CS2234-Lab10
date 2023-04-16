import java.util.ArrayList;
public enum Peg{

    LEFT(),
    MIDDLE(),
    RIGHT();

    public static Peg other(Peg p1, Peg p2){
        if(p1 == null || p2 == null)
            throw new NullPointerException();
        if(p1 == p2)
            throw new IllegalArgumentException();
        ArrayList<Peg> temp = new ArrayList<>();
        temp.add(LEFT);
        temp.add(MIDDLE);
        temp.add(RIGHT);

        temp.remove(p1);
        temp.remove(p2);

        return temp.get(0);
    }
}