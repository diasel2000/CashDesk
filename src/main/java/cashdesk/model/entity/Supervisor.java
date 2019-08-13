package cashdesk.model.entity;

import java.util.Objects;

/**
 * Supervisor entity
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class Supervisor {
    private int id;
    private String name;
    private String lastName;

    public Supervisor(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
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
        if (o == null || getClass () != o.getClass ()) return false;
        Supervisor that = (Supervisor) o;
        return id == that.id &&
                Objects.equals ( name, that.name ) &&
                Objects.equals ( lastName, that.lastName );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( id, name, lastName );
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
