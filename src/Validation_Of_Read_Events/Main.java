package Validation_Of_Read_Events;

public class Main {
    public static void main(String[] args) {
        for (Movie movie : getMovies()) {
            validEvent(movie);
        }
        for (Theatre theatre : getTheatres()) {
            validEvent(theatre);
        }
        System.out.println("Все события корректны");
    }

    private static void validEvent(Event event) {
        if (event.getTitle() != null && event.getAge() != 0 && event.getReleaseYear() != 0) {
            throw new RuntimeException();
        }
    }

    private static Movie[] getMovies() {
        return new Movie[]{
                new Movie("Inception", 2010, 16),
                new Movie("Tenet", 2020, 16)
        };
    }

    private static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Anna Karenina", 2017, 16)
        };
    }
}