/*
 * @author Andrew Chen-Goodspeed
 * CS 2334 - Fall
 */
import java.util.Objects;

public class Card implements Comparable<Card>{
	
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		if(rank == null || suit == null)
			throw new NullPointerException();
		this.rank = rank;
		this.suit = suit;
		
	}
	
	@Override
	public int compareTo(Card card) {
		Suit suit = getSuit();
		Suit otherSuit = card.getSuit();
		Rank rank = getRank();
		Rank otherRank = card.getRank();
		
		int compRank = rank.compareTo(otherRank);
		int compSuit = suit.compareTo(otherSuit);
		
		if(compSuit == 0)
			if(compRank == 0)
				return 0;
			else if(compRank < 0)
				return -1;
			else
				return 1;
		else if(compSuit < 0)
			return -1;
		else
			return 1;
	}
	@Override
	public boolean equals(Object obj){
		if( !(obj instanceof Card))
			return false;
		
		Card check = (Card) obj;

		return this.compareTo(check) == 0;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}
	
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}

	public String toString() {
		return rank.toString() + suit.toString();
	}
}
