// LeetCode 2353 - Design a Food Rating System (Medium)
// Approach: map food -> (cuisine, rating); per cuisine keep a TreeSet ordered by
// rating desc, then name asc. changeRating removes and re-inserts the food.
// Time: O(log n) per operation  Space: O(n)
import java.util.*;

class FoodRatings {
    private static class Food {
        String name;
        int rating;
        Food(String name, int rating) { this.name = name; this.rating = rating; }
    }

    private final Map<String, Food> foodMap = new HashMap<>();
    private final Map<String, String> foodCuisine = new HashMap<>();
    private final Map<String, TreeSet<Food>> cuisineSet = new HashMap<>();

    private static final Comparator<Food> CMP = (a, b) ->
            a.rating != b.rating ? b.rating - a.rating : a.name.compareTo(b.name);

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], ratings[i]);
            foodMap.put(foods[i], f);
            foodCuisine.put(foods[i], cuisines[i]);
            cuisineSet.computeIfAbsent(cuisines[i], k -> new TreeSet<>(CMP)).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f = foodMap.get(food);
        TreeSet<Food> set = cuisineSet.get(foodCuisine.get(food));
        set.remove(f);
        f.rating = newRating;
        set.add(f);
    }

    public String highestRated(String cuisine) {
        return cuisineSet.get(cuisine).first().name;
    }

    public static void main(String[] args) {
        FoodRatings fr = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(fr.highestRated("korean") + " (expected kimchi)");
        System.out.println(fr.highestRated("japanese") + " (expected ramen)");
        fr.changeRating("sushi", 16);
        System.out.println(fr.highestRated("japanese") + " (expected sushi)");
        fr.changeRating("ramen", 16);
        System.out.println(fr.highestRated("japanese") + " (expected ramen - tie, alphabetical)");
    }
}
