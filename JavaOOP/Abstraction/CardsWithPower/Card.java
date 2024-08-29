package Abstraction.CardsWithPower;

public class Card {
    private RankPowers rank;
    private Suits suit;

    public Card(RankPowers rank, Suits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public RankPowers getRank() {
        return rank;
    }

    public void setRank(RankPowers rank) {
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public int getPower() {
        return this.rank.getPower() + this.suit.getPowerSuit();
    }
}

