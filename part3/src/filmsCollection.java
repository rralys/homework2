import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class filmsCollection implements Serializable {
    private String collectionName;
    private Set<filmClass> collection = new LinkedHashSet<>();

    public filmsCollection(String name, Set<filmClass> collection) {
        this.collectionName = name;
        this.collection = collection;
    }

    public void setCollectionName(String name) {
        collectionName = name;
    }

    public void setCollection(Set<filmClass> collection) {
        this.collection = collection;
    }

    public void addFilm(filmClass film) {
        collection.add(film);
    }

    public void removeFilm(filmClass film) {
        collection.remove(film);
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void renameCollection(String newName) {
        collectionName = newName;
    }

    public Set<filmClass> getCollection() {
        Set<filmClass> collectionCopy;
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
            filmsCollection curObj = (filmsCollection) obj;
            res = curObj.getCollection().equals(collection) && curObj.getCollectionName().equals(collectionName);
        }

        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectionName, collection);
    }
}
