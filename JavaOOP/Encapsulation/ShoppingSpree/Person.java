package Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw  new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;

    }

    public void buyProduct (Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", getName(), product.getName()));
        } else {
            this.products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return String.format("%s - Nothing bought", this.getName());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getName()).append(" - ");
            for (int i = 0; i < this.products.size(); i++) {
                Product product = this.products.get(i);
                sb.append(product.getName());
                if (i < this.products.size() - 1) {
                    sb.append(", ");
                }
            }
            return sb.toString();
        }
    }
}
