
import java.io.Serializable;
import java.util.Arrays;

public class Movie implements Serializable {
    private final String title;
    private final String director;
    private final String[] actors;
    private final int releaseDate;

    public Movie(String title, String director, String[] actors, int releaseDate) {
        this.title = title;
        this.director = director;
        this.actors = actors;
        this.releaseDate = releaseDate;
    }

   @Override
    public String toString() {
        return title + " (" + releaseDate + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Movie m1 = (Movie) obj;

        return this.title.equals(m1.title)
                && this.director.equals(m1.director)
                && Arrays.equals(this.actors, m1.actors)
                && this.releaseDate == m1.releaseDate;
    }
}
