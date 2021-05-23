package SystemDesignPractice.LLD.CabBooking.src.main.java.com.uditagarwal.cabbooking.strategies;

import com.uditagarwal.cabbooking.model.Location;

public interface PricingStrategy {
  Double findPrice(Location fromPoint, Location toPoint);
}
