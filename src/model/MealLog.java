package model;
import java.util.LinkedList;
import java.util.List;
public class MealLog extends Log{

    private final String name;
    private List<Pair<Food, Integer>> foodsEaten;

    public MealLog(final String name){
        super();
        this.name = name;

        this.foodsEaten  = new LinkedList<>();
    }

    public String getName(){
        return this.name;
    }

    public void addFood(Food food, int quantity){
        Pair<Food, Integer> newPair = new Pair<>(food, quantity);
        this.foodsEaten.add(newPair);
        Nutrients newNutrients = totalNutrients(food, quantity);
        super.updateNutrients(newNutrients);
    }

    public void removeFood(Food food){
        foodsEaten.forEach(item -> {
            if (item.getX() == food){
                foodsEaten.remove(item);
            }
        });
    }

    public Nutrients totalNutrients(Food food, int quantity){
        int totalCalories = (food.getNutrients().getCalories() * 100) / quantity; 
        int totalPro = (food.getNutrients().getProtein() * 100) / quantity;
        int totalFat = (food.getNutrients().getFat() * 100) / quantity;
        int totalCarbs = (food.getNutrients().getCarbs() * 100) / quantity;

        return new Nutrients(totalCalories, totalPro, totalFat, totalCarbs);
    }

    public String toString(){
        String meal = "";

        for(Pair<Food, Integer> food : foodsEaten){
            meal += food.getX().getName() + food.getY() + "\n";
        }

        return meal;
    }
}
