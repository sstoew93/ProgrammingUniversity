package Inheritance.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    public Object getRandomElement() {
        int idx = new Random().nextInt(super.size());
        return super.remove(idx);
    }
}
