package spider.javafxlab1.taskthree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dish {
    private  String name;
    private double cost;
    private int servings;

    public Dish(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.servings = 1;
    }
    public Dish(String name, double cost, int servings) {
        this.name = name;
        this.cost = cost;
        this.servings = servings;
    }

    public double getTotalCost() {
        return cost * servings;
    }
}
