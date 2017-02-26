package java8inaction.stream.Dishes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Iteration {
    public static void limitTest() {
        List<String> names = Menu.menu.stream().filter(d -> {
            System.out.println("filter + " + d.getName());
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println("mapping + " + d.getName());
            return d.getName();
        }).limit(3).collect(Collectors.toList());

        System.out.println(names);
    }

    public static void main(String[] args) {
        limitTest();
    }

    public List<String> getNamesUsingOutterIteration() {
        List<String> names = new ArrayList<>();
        for (Dish dish : Menu.menu) {
            names.add(dish.getName());
        }
        return names;
    }

    public List<String> getNamesUsingIterator() {
        List<String> names = new ArrayList<>();
        Iterator<Dish> iterator = Menu.menu.iterator();
        while (iterator.hasNext()) {
            names.add(iterator.next().getName());
        }
        return names;
    }

    public List<String> getNamesUsingInnterIteration() {
        return Menu.menu.stream().map(Dish::getName).collect(Collectors.toList());
    }
}
