import java.util.List;

public class InvoiceGenerator {

	private static final double COST_PER_KM = 10;
	private static final int COST_PER_MINUTE = 1;
	private static final double MIN_FARE = 5;
	
	RideRepository rideRepository;

    public InvoiceGenerator() {
        rideRepository = new RideRepository();
    }

	public InvoiceSummary calculateFare(Ride ...rides) {
		double totalFare = 0;
		double rideFare;
		for(Ride ride : rides) {
			rideFare = ride.distance * COST_PER_KM + ride.time * COST_PER_MINUTE;
			totalFare += Math.max(rideFare, MIN_FARE);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}
	
	public void addRideToRepository(String userId, Ride ...rides) {
		rideRepository.addRideForUser(userId, rides);
	}
	
	public InvoiceSummary calculateFareForUser(String userId) {
		return calculateFare(rideRepository.getRidesForUser(userId));
	}

}
