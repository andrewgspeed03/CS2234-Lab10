public enum Move {
    
    LEFT_TO_MIDDLE(Peg.LEFT, Peg.MIDDLE),
    LEFT_TO_RIGHT(Peg.LEFT, Peg.RIGHT),
    MIDDLE_TO_LEFT(Peg.MIDDLE, Peg.LEFT),
    MIDDLE_TO_RIGHT(Peg.MIDDLE, Peg.RIGHT),
    RIGHT_TO_LEFT(Peg.RIGHT, Peg.LEFT),
    RIGHT_TO_MIDDLE(Peg.RIGHT, Peg.MIDDLE);

    public final Peg from;
    public final Peg to;

    private Move(Peg from, Peg to){
        this.from = from;
        this.to = to;
    }
    public static Move move(Peg from, Peg to){
        if(from == null || to == null)
            throw new NullPointerException();
        if(from == to)
            throw new IllegalArgumentException();
            
        if(from == Peg.LEFT)
            if(to == Peg.MIDDLE)
                return LEFT_TO_MIDDLE;
            else
                return LEFT_TO_RIGHT;
        else if(from == Peg.MIDDLE)
            if(to == Peg.LEFT)
                return MIDDLE_TO_LEFT;
            else
                return MIDDLE_TO_RIGHT;
        else
            if(to == Peg.LEFT)
                return RIGHT_TO_LEFT;
            else
                return RIGHT_TO_MIDDLE;
    }
}
