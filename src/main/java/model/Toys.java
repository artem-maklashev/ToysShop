package model;

public class Toys extends Comparable<> {
    private int id;
    private String name;
    private float weight;

    public Toys(int id, String name, float weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
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
    public int compareTo(Object o) {
        return (int) (((Toys) o).getWeight() - this.getWeight());
    }
}
