import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<String, Ride[]> userRides = new HashMap<>();
	
	public void addRideForUser(String userId, Ride ...rides) {
		userRides.put(userId, rides);
	}
	
	public Ride[] getRidesForUser(String userId) {
		return userRides.get(userId);
    }
}
