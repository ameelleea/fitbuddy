package model;

import java.util.LinkedList;
import java.util.List;

public class Data {
    private static List<Food> foodList = new LinkedList<>();
    private static List<DailyLog> diary = new LinkedList<>();

    public static void addFood(String name, int cals, int fat, int carb, int pro){
        Food newFood = new Food(name, cals, fat, carb, pro);
        foodList.add(newFood);
    }

    public static void removeFood(String name){
        foodList.forEach(item -> {
            if (item.getName() == name){
                foodList.remove(item);
            }
        });
    }

    public static Food getFood(String name){
        Food food = null;
        for(Food item : foodList){
            if (item.getName() == name)
                food = item;
        }

        return food;
    }
}
