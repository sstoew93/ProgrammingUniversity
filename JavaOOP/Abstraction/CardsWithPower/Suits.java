package Abstraction.CardsWithPower;

public enum Suits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int powerSuit;

    public int getPowerSuit() {
        return powerSuit;
    }

    Suits(int powerSuit) {
        this.powerSuit = powerSuit;
    }
}
