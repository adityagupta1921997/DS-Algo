package LLD.BookMyShow;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter input:-");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] inputArr = input.split("~");
        ArrayList<User> users= new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Seat> seats = new ArrayList<>();
        ArrayList<Theatre> theatres = new ArrayList<>();
        Long uid=0L;
        Long tid=0L;

        if(inputArr[0].equals("user")){
            String[] userArr = inputArr[1].split(",");
            uid++;
            users.add(new User(uid, userArr[0], userArr[1]));
        }
        if(inputArr[0].equals("movie")){
            String[] movieArr = inputArr[1].split(",");
            movies.add(new Movie(movieArr[0], movieArr[1], movieArr[2]));
        }
        if(inputArr[0].equals("seat")){
            String[] seatArr = inputArr[1].split(",");
            seats.add(new Seat(Long.parseLong(seatArr[0]), seatArr[1], seatArr[2]));
        }
        if(inputArr[0].equals("theatre")){
            String[] theatreArr = inputArr[1].split(",");
            tid++;
            theatres.add(new Theatre(tid, theatreArr[0], theatreArr[1]));
        }


    }
}
