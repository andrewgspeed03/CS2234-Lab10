/*
 * @author Andrew Chen-Goodspeed
 * CS 2334 - Fall
 */
public enum Suit {
	
	CLUBS("C"),
	DIAMONDS("D"),
	HEARTS("H"),
	SPADES("S");
	private String symbol;
	
	private Suit(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
}
