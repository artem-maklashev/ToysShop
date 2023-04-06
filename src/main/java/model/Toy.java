package model;

public class Toy implements Comparable<Toy> {
    private int idCounter = 1;
    private int id;
    private String name;
    private int weight;

    public Toy(String name, int weight) {
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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy o) {
        return (o.getId()-this.getId());
    }
}
