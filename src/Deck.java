/*
 * @author Andrew Chen-Goodspeed
 * CS 2334 - Fall
 */
import java.util.*;
public class Deck {
	
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
		for(Suit s : suits)
			for(Rank r : ranks)
				cards.add(new Card(r, s));
		
		Collections.sort(cards);
	}
	
	public int size() {
		return cards.size();
	}
	public String toString() {
		return cards.toString();
	}
	public Card draw() {	
		if(cards.size() == 0)
			return null;
		return cards.remove(0);
	}
	public List<Card> draw(int count){
		List<Card> draw = new ArrayList<>();
		
		if(cards.size() == 0);
		else if(count >= cards.size()){
			draw = new ArrayList<>(cards);
			cards.removeAll(cards);
		}
		else if(count <= 0);
		else
			for(int i = 0; i < count; i++)
				draw.add(cards.remove(0));
		
		return draw;
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}
	public List<Card> getCardsByRank(Rank rank){
		List<Card> match = new ArrayList<>();
		List<Card> deck = new ArrayList<>(cards);
		
		for(Card c : deck)
			if(c.getRank() == rank)
				match.add(c);
		
		return match;
	}
}
