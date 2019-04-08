import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class filmClass implements Serializable {
    private String filmName;
    private Set<actorClass> actorsList = new LinkedHashSet<actorClass>();

    public filmClass(String film, Set<actorClass> actors) {
        this.filmName = film;
        this.actorsList = actors;
    }

    public void setFilm(String newFilm) {
        this.filmName = newFilm;
    }

    public String getFilm() {
        return filmName;
    }

    public Set<actorClass> getActorsList() {
        return actorsList;
    }

    public void addActor(actorClass actor) {
        actorsList.add(actor);
    }

    public void removeActor(actorClass actor) {
        actorsList.remove(actor);
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = false;

        if (this == obj) {
            res = true;
        } else if (obj == null || obj.getClass() != getClass()) {
            res = false;
        } else {
            filmClass curObj = (filmClass) obj;
            res = curObj.getFilm().equals(filmName) && curObj.getActorsList().equals(actorsList);
        }

        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, actorsList);
    }
}
