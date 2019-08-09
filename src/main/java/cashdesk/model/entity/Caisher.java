package cashdesk.model.entity;

import java.util.Objects;

public class Caisher {
    private int id;
    private String name;
    private String lastName;

    public Caisher(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Caisher() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caisher caisher = (Caisher) o;
        return id == caisher.id &&
                Objects.equals(name, caisher.name) &&
                Objects.equals(lastName, caisher.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName);
    }

    @Override
    public String toString() {
        return "Caisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
