package basicfunctional;

public class Apple {
    private String color;
    private int weight;

    public Apple() {}

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isGreenApple() {
        return "green".equals(color);
    }

//    public static boolean isRedApple(Apple apple) {
//        return "green".equals(apple.color);
//    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
