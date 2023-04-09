package model;

public class Toy implements Comparable<Toy> {
    private static int idCounter = 1;
    private final int id;
    private String name;
    private float weight;

    public Toy(String name, float weight) {
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy o) {
        return this.getId() - o.getId();
    }
}