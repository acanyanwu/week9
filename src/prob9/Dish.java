package prob9;
import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    
    public static void main(String[] args) {
        System.out.println("There is Vegetarian available: " + isVegetarianMealAvailable());
        System.out.println("There is Healthy Meal less than 1000 calories: " + hasHealthyMealWithCaloriesLessThan1000());
        System.out.println("There is UnHealthy Meal 1000 calories or more: " + hasUnHealthyMealWithCaloriesGreaterOrEqualTo1000());
        System.out.println("First found meat dish: " + findFirstFoundMeatDish().get());
        System.out.println("Total calories method 1: " + calculateTotalCalories());
        System.out.println("Total calories method 2: " + calculateTotalCaloriesMethodReference());
    }
    
    public static Boolean isVegetarianMealAvailable() {
        return menu.stream().filter(dish->dish.getType() == Type.OTHER).findAny().isPresent();
    }
    
    public static Boolean hasHealthyMealWithCaloriesLessThan1000() {
        return menu.stream().filter(dish->dish.getCalories() < 1000).findAny().isPresent();
    }
    
    public static Boolean hasUnHealthyMealWithCaloriesGreaterOrEqualTo1000() {
        return menu.stream().filter(dish->dish.getCalories() >= 1000).findAny().isPresent();
    }
    
    public static Optional<Dish> findFirstFoundMeatDish() {
        return menu.stream().filter(dish->dish.getType() == Type.MEAT).findFirst();
    }
    
    public static int calculateTotalCalories() {
        return menu.stream().map(dish->dish.getCalories()).reduce((cal1, cal2)->cal1+cal2).orElse(0);
    }
    
    public static int calculateTotalCaloriesMethodReference() {
        return menu.stream().map(Dish::getCalories).reduce(Math::addExact).orElse(0);
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                           new Dish("beef", false, 700, Dish.Type.MEAT),
                           new Dish("chicken", false, 400, Dish.Type.MEAT),
                           new Dish("french fries", true, 530, Dish.Type.OTHER),
                           new Dish("rice", true, 350, Dish.Type.OTHER),
                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
                           new Dish("pizza", true, 550, Dish.Type.OTHER),
                           new Dish("prawns", false, 400, Dish.Type.FISH),
                           new Dish("salmon", false, 450, Dish.Type.FISH));
}