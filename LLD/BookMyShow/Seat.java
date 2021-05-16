package LLD.BookMyShow;

public class Seat {

    private Long theatreId;
    private String seatId;
    private String seatType;


    public Seat(Long theatreId, String seatId, String seatType) {
        this.theatreId = theatreId;
        this.seatId = seatId;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }


}
