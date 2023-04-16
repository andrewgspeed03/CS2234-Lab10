import java.util.*;

public class CribbageHand {
    public static final Map<Rank, Integer> CARD_VALUES = Map.ofEntries( 
        Map.entry(Rank.ACE, 1), 
        Map.entry(Rank.TWO, 2),
        Map.entry(Rank.THREE, 3),
        Map.entry(Rank.FOUR, 4),
        Map.entry(Rank.FIVE, 5),
        Map.entry(Rank.SIX, 6),
        Map.entry(Rank.SEVEN, 7),
        Map.entry(Rank.EIGHT, 8),
        Map.entry(Rank.NINE, 9),
        Map.entry(Rank.TEN, 10),
        Map.entry(Rank.JACK, 10),
        Map.entry(Rank.QUEEN, 10),
        Map.entry(Rank.KING, 10));
    public final List<Card> cards;

    public CribbageHand(Card c1, Card c2, Card c3 , Card c4){
        if(c1 == null || c2 == null || c3 == null || c4 == null)
            throw new NullPointerException();
        Card[] hand = {c1, c2, c3, c4};
        this.cards =  Arrays.asList(hand);      
    }

    public Set<Set<Card>> fifteens(Card starter){
        Set<Set<Card>> combos = new HashSet<>(powerSet(cards));
        Set<Set<Card>> fifteen = new HashSet<>();
        Set<Set<Card>> poss = new HashSet<>();

        for(Set<Card> cmb : combos){
            Integer total = 0;
            if(cmb == null)
                break;
            for(Card x: cmb)
                total += CARD_VALUES.get(x.getRank());
            if(total == 15)
                    fifteen.add(cmb);

            total = CARD_VALUES.get(starter.getRank());
            for(Card y: cmb)
                total += CARD_VALUES.get(y.getRank());
            if(total == 15){
                cmb.add(starter);
                fifteen.add(cmb);
            }
            poss.clear();
        }

        return fifteen;
    }
    public static Set<Set<Card>> powerSet(List<Card> cards){
        if (cards.isEmpty()) {
            Set<Set<Card>> rlt = new HashSet<>();
            rlt.add(new HashSet<>());
            return rlt;
        } else {
            Card first = cards.get(0);
            List<Card> rest = cards.subList(1, cards.size());
            Set<Set<Card>> sub = powerSet(rest);
            Set<Set<Card>> rlt = new HashSet<>(sub);
            for (Set<Card> set : sub) {
                Set<Card> temp = new HashSet<>(set);
                temp.add(first);
                rlt.add(temp);
            }
            return rlt;
        }
    }
}
