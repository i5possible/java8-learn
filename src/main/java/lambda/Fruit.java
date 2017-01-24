package lambda;

public class Fruit {
    int weight;
    Color color;

    public Fruit(int weight, Color color) {
        this.weight = weight;
        this.color = color;
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
}

enum Color {
    Red,
    Yellow,
    Green,
    Blue
}
