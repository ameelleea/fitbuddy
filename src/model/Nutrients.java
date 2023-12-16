package model;
public class Nutrients {

    private int calories;
    private int protein;
    private int fat;
    private int carbs;

    public Nutrients(int cal, int pro, int fat, int carbs){
        this.calories = cal;
        this.protein = pro;
        this.fat = fat;
        this.carbs = carbs;
    }

    public int getCalories(){
        return this.calories;
    }

    public int getProtein(){
        return this.protein;
    }

    public int getFat(){
        return this.fat;
    }

    public int getCarbs(){
        return this.carbs;
    }

    public void setCalories(int cal){
        this.calories = cal;
    }

    public void setProtein(int pro){
        this.protein = pro;
    }

    public void setFat(int fat){
        this.fat = fat;
    }

    public void setCarbs(int carbs){
        this.carbs = carbs;
    }

    public void setNutrients(int cal, int pro, int fat, int carbs){
        this.calories = cal;
        this.protein = pro;
        this.fat = fat;
        this.carbs = carbs;
    }
    
    public String toString(){
        return "Calorie: " + this.calories + "\nProteine: " + this.protein + "\nGrassi: " + this.fat + "\nCarboidrati: " + this.carbs;
    }

}
