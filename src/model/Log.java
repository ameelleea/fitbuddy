package model;

import java.sql.Date;

public abstract class Log implements LogInterface{

    private Nutrients nutrients;

    public Log(){
        this.nutrients = new Nutrients(0, 0, 0, 0);
    }

    public void updateNutrients(Nutrients foodNutrients){
        int newCalories = this.nutrients.getCalories() + foodNutrients.getCalories();
        int newPro = this.nutrients.getProtein() + foodNutrients.getProtein();
        int newFat = this.nutrients.getFat() + foodNutrients.getFat();
        int newCarb = this.nutrients.getCarbs() + foodNutrients.getCarbs();

        this.nutrients.setNutrients(newCalories, newPro, newFat, newCarb);
    }

    public Nutrients getNutrients(){
        return this.nutrients;
    }
}
