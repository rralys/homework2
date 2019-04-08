import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class testFilmCollectionSave {
    filmsCollection testCollection;
    @Before
    public void prepareData() {
        actorClass actor1 = new actorClass("Hugh","Grant");
        actorClass actor2 = new actorClass("Meryl", "Streep");
        Set<actorClass> actors = new LinkedHashSet<>();
        actors.add(actor1);
        actors.add(actor2);
        filmClass film = new filmClass("The best film ever", actors);
        Set<filmClass >filmSet = new LinkedHashSet<>();
        filmSet.add(film);
        testCollection = new filmsCollection("Greatest collection", filmSet);
    }

@Test
    public void testWriteAndReadFilmsCollection() throws IOException {
    filmsCollectionSave.filmsCollectionWrite(testCollection, "C:\\GIT\\RRalys\\homework2\\part3\\src\\writeoutput.txt");
    filmsCollection readCollection = filmsCollectionSave.filmsCollectionRead("C:\\GIT\\RRalys\\homework2\\part3\\src\\writeoutput.txt");

    assert(readCollection.equals(testCollection));

}

}
