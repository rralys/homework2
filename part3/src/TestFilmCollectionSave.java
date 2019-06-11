import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestFilmCollectionSave {
    private FilmsSet testCollection;
    @Before
    public void prepareData() {
        Actor actor1 = new Actor("Hugh","Grant");
        Actor actor2 = new Actor("Meryl", "Streep");
        Set<Actor> actors = new LinkedHashSet<>();
        actors.add(actor1);
        actors.add(actor2);
        Film film = new Film("The best film ever", actors);
        Set<Film>filmSet = new LinkedHashSet<>();
        filmSet.add(film);
        testCollection = new FilmsSet("Greatest collection", filmSet);
    }

@Test
    public void testWriteAndReadFilmsCollection() throws IOException {
    FilmsSetSave.filmsCollectionWrite(testCollection, "C:\\GIT\\RRalys\\homework2\\part3\\src\\writeoutput.txt");
    FilmsSet readCollection = FilmsSetSave.filmsCollectionRead("C:\\GIT\\RRalys\\homework2\\part3\\src\\writeoutput.txt");

    assertEquals(readCollection,testCollection);

}

}
