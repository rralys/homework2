import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Film implements Serializable {
    private String filmName;
    private Set<Actor> actorsList = new LinkedHashSet<Actor>();

    public Film(String film, Set<Actor> actors) {
        this.filmName = film;
        this.actorsList = actors;
    }

    public void setFilm(String newFilm) {
        this.filmName = newFilm;
    }

    public String getFilm() {
        return filmName;
    }

    public Set<Actor> getActorsList() {
        return actorsList;
    }

    public void addActor(Actor actor) {
        actorsList.add(actor);
    }

    public void removeActor(Actor actor) {
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
            Film curObj = (Film) obj;
            res = curObj.getFilm().equals(filmName) && curObj.getActorsList().equals(actorsList);
        }

        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, actorsList);
    }
}
