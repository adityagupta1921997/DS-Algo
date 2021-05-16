package LLD.BookMyShow;

public class Movie {

    private String movieName;
    private String movieType;
    private String movieLang;

    public Movie(String movieName, String movieType, String movieLang) {
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieLang = movieLang;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieLang() {
        return movieLang;
    }

    public void setMovieLang(String movieLang) {
        this.movieLang = movieLang;
    }


}
