package model;
public interface LogInterface {
    
    public void updateNutrients(Nutrients foodNutrients);

    public String getName();

    public Nutrients totalNutrients(Food food, int quantity);
}
