package model;
import java.sql.Date;

public class User {

    private final String name;
    private int age;
    private final Date doB;
    private int weight;
    private final int initWeight;
    private int height;
    private Nutrients dailyNutrients;

    public User(final String name, int age, Date dOB, int weight, int height){
        this.name = name;
        this.age = age;
        this.doB = dOB;
        this.weight = this.initWeight = weight;
        this.height = height;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public Date getDoB(){
        return this.doB;
    }

    public int getWeight(){
        return this.weight;
    }

    public int getInitWeight(){
        return this.initWeight;
    }

    public int getHeight(){
        return this.height;
    }

    public Nutrients getDailyNutrients(){
        return this.dailyNutrients;
    }

    public void getAge(int age){
        this.age = age;
    }

    public void getWeight(int weight){
        this.weight = weight;
    }

    public void getHeight(int height){
        this.height = height;
    }

    public void getDailyNutrients(Nutrients nutrients){
        this.dailyNutrients = nutrients;
    }

    public void calculateBMR(){}
    public void calculateTDEE(){}

}
