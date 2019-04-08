import java.io.Serializable;
import java.util.Objects;

public class actorClass implements Serializable {
    private String name;
    private String lastName;

    public actorClass(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public void setActor(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getActorName() {
        return name;
    }

    public String getActorLastName() {
        return lastName;
    }

    public String getActor() {
        return String.format("%s %s", name, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = false;

        if (obj == this) {
            res = true;
        } else if (obj == null || obj.getClass() != getClass()) {
            res = false;
        } else {
            actorClass curActor = (actorClass) obj;
            res = curActor.getActor().equals(getActor());
        }

        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }
}
