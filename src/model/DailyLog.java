package model;

import java.sql.Date;

public class DailyLog extends Log {

    private MealLog[] meals = new MealLog[4];
    private Date date;

    public DailyLog(Nutrients userNutrients){
        super();
        meals[0] = new MealLog("Colazione");
        meals[1] = new MealLog("Pranzo");
        meals[2] = new MealLog("Cena");
        meals[3] = new MealLog("Spuntini");
    }

    public void logMeal(int index, Food newFood, int quantity){
        meals[index].addFood(newFood, quantity);
        super.updateNutrients(newFood.getNutrients());
    }

    public Date getDate(){
        return this.date;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public Nutrients totalNutrients(Food food, int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalNutrients'");
    }
}
