package lambda;

enum Color {
    Red,
    Yellow,
    Green,
    Blue
}

public class Fruit {
    int weight;
    Color color;
    String taste;

    public Fruit(int weight, Color color, String taste) {
        this.weight = weight;
        this.color = color;
        this.taste = taste;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
