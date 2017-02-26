package java8inaction.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static java8inaction.stream.Menu.menu;

public class Iteration {
    public static void limitTest() {
        List<String> names = menu.stream().filter(d -> {
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
        for (Dish dish : menu) {
            names.add(dish.getName());
        }
        return names;
    }

    public List<String> getNamesUsingIterator() {
        List<String> names = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            names.add(iterator.next().getName());
        }
        return names;
    }

    public List<String> getNamesUsingInnterIteration() {
        return menu.stream().map(Dish::getName).collect(Collectors.toList());
    }
}
