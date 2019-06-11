import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class FilmsSet implements Serializable {
    private String collectionName;
    private Set<Film> collection = new LinkedHashSet<>();

    public FilmsSet(String name, Set<Film> collection) {
        this.collectionName = name;
        this.collection = collection;
    }

    public void setCollectionName(String name) {
        collectionName = name;
    }

    public void setCollection(Set<Film> collection) {
        this.collection = collection;
    }

    public void addFilm(Film film) {
        collection.add(film);
    }

    public void removeFilm(Film film) {
        collection.remove(film);
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void renameCollection(String newName) {
        collectionName = newName;
    }

    public Set<Film> getCollection() {
        Set<Film> collectionCopy;
        collectionCopy = collection;
        return collectionCopy;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = false;

        if (obj == this) {
            res = true;
        } else if (obj == null || obj.getClass() != getClass()) {
            res = false;
        } else {
            FilmsSet curObj = (FilmsSet) obj;
            res = curObj.getCollection().equals(collection) && curObj.getCollectionName().equals(collectionName);
        }

        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectionName, collection);
    }
}
