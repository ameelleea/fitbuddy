package model;
public class Food {

    private final String name;
    private Nutrients nutrients;

    public Food(final String name, int cal, int fat, int carb, int pro){
        this.name = name;
        this.nutrients = new Nutrients(cal, pro, fat, carb);
    }

    public String getName(){
        return this.name;
    }

    public Nutrients getNutrients(){
        return this.nutrients;
    }
}

