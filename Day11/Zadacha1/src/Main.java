import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main {
    public static void main(String[] args) {
        String[] actors = {"Al Pachino", "Robert De Niro"};
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", actors, 1972);
        System.out.println(movie);

        createFileFromObject(movie, "movie.txt");
        printObjectEqual(movie, createObjectFromFile("movie.txt"));
        printObjectFromFile("movie.txt");
    }

    public static void printObjectFromFile(String fileName) {
        Movie movie = createObjectFromFile(fileName);
        if (movie != null) {
            System.out.println(movie);
        } else {
            System.out.println("The file is empty");
        }
    }
    public static void printObjectEqual(Object o1, Object o2) {
        if (o1.equals(o2)) {
            System.out.println("The objects are equal");
        } else {
            System.out.println("The objects are not equal");
        }
    }

    public static void createFileFromObject(Movie movie, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(movie);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static Movie createObjectFromFile(String fileName) {
        Movie movie = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            movie = (Movie) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return movie;
    }
}