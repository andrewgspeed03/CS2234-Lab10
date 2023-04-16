import java.util.*;

public class TowerOfHanoi {
    private Map<Peg, Deque<Integer>> diskStacks = new HashMap<>();

    public TowerOfHanoi(int numDisks, Peg start){
        if(numDisks <= 0)
            throw new IllegalArgumentException();
        if(start == null)
            throw new NullPointerException();
        
            Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 1; i <= numDisks; i++)
            stack.add(i);
        diskStacks.put(start, stack);

        if(start == Peg.LEFT){
            diskStacks.put(Peg.MIDDLE, new ArrayDeque<>());
            diskStacks.put(Peg.RIGHT, new ArrayDeque<>());
        }
        else if(start == Peg.MIDDLE){
            diskStacks.put(Peg.LEFT, new ArrayDeque<>());
            diskStacks.put(Peg.RIGHT, new ArrayDeque<>());
        }
        else{
            diskStacks.put(Peg.MIDDLE, new ArrayDeque<>());
            diskStacks.put(Peg.LEFT, new ArrayDeque<>());
        }

    }

    public Deque<Integer> getDiskStack(Peg peg){
        if(peg == null)
            throw new NullPointerException();
        Deque<Integer> copy = new ArrayDeque<>(diskStacks.get(peg));
        return copy;
    }

    public void moveDisk(Move move){
        if(move == null)
            throw new NullPointerException();
        
        Deque<Integer> first = getDiskStack(move.from);
        Deque<Integer> second = getDiskStack(move.to);

        if(first.isEmpty())
            throw new IllegalArgumentException();
        Integer diskFrom = first.peekLast();
        if(!second.isEmpty()){
            Integer diskTo = second.peekLast();
            if(diskFrom > diskTo)
                throw new IllegalArgumentException();
        }

        diskFrom = first.remove();
        second.addFirst(diskFrom);
        
        diskStacks.replace(move.from, first);
        diskStacks.replace(move.to, second);
    }
    public static List<Move> solve(int numDisk, Peg start, Peg end){
        if(numDisk < 0)
            throw new IllegalArgumentException();
        if(start == null || end == null)
            throw new NullPointerException();

        List<Move> moves = new ArrayList<>();
        try{
            if (numDisk > 0) {
                Peg other = Peg.other(start, end);
                moves.addAll(solve(numDisk - 1, start, other));
                moves.add(Move.move(start, end));
                moves.addAll(solve(numDisk - 1, other, end));
            }
        }
        catch(NullPointerException | IllegalArgumentException e){
            return moves;
        }
        
    return moves;
        
        
    }
    public String toString(){
        String rtn = "  LEFT: "+ reverse(Peg.LEFT) +
        "\nMIDDLE: " + reverse(Peg.MIDDLE) +
        "\n RIGHT: " + reverse(Peg.RIGHT);

        return rtn;
    }
    private String reverse(Peg peg){
        Deque<Integer> stack = getDiskStack(peg);
        String rtn = "[";
        if(!stack.isEmpty())
            rtn+= stack.removeLast();
        while(!stack.isEmpty())
            rtn +=", " + stack.removeLast();
        return rtn + "]";
    }
}
