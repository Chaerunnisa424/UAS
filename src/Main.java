import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Film {
    private String filmId;
    private String namaFilm;
    private int tahun;
    private double rating;

    public Film(String filmId, String namaFilm, int tahun, double rating) {
        this.filmId = filmId;
        this.namaFilm = namaFilm;
        this.tahun = tahun;
        this.rating = rating;
    }

    public String getFilmId() {
        return filmId;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public int getTahun() {
        return tahun;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Film ID: " + filmId +
                ", Nama Film: " + namaFilm +
                ", Tahun: " + tahun +
                ", Rating: " + rating;
    }
}

class IMDBTopMovies {
    private List<Film> movies;

    public IMDBTopMovies() {
        movies = new ArrayList<>();
    }

    public void addFilm(Film film) {
        movies.add(film);
    }

    public void selectionSort() {
        int n = movies.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (movies.get(j).getRating() > movies.get(minIndex).getRating()) {
                    minIndex = j;
                }
            }
            Collections.swap(movies, i, minIndex);
        }
    }

    public void displayMovies() {
        for (Film movie : movies) {
            System.out.println(movie);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("tt1375666", "The Flash", 2023, 7.3);
        Film film2 = new Film("tt1234567", "Spider-Man: Across the Spider-Verse", 2023, 9.0);
        Film film3 = new Film("tt9876543", "Transformers: Rise of the Beasts", 2023, 6.6);
        Film film4 = new Film("tt5678901", "Avatar: The Way of Water", 2022, 7.6);
        Film film5 = new Film("tt2468135", "The Little Mermaid", 2023, 7.2);
        Film film6 = new Film("tt1375668", "Extraction", 2023, 7.2);
        Film film7 = new Film("tt1375678", "Faxt X", 2023, 6.0);

        IMDBTopMovies topMovies = new IMDBTopMovies();
        topMovies.addFilm(film1);
        topMovies.addFilm(film2);
        topMovies.addFilm(film3);
        topMovies.addFilm(film4);
        topMovies.addFilm(film5);
        topMovies.addFilm(film6);
        topMovies.addFilm(film7);

        System.out.println("Daftar Film Terlaris di IMDB :");
        topMovies.displayMovies();

        topMovies.selectionSort();

        System.out.println("\nUrutan Daftar Film Terlaris :");
        topMovies.displayMovies();
    }
}
