
public class InvoiceGenerator {
	
	RideRepository rideRepository;

    public InvoiceGenerator() {
        rideRepository = new RideRepository();
    }

	public InvoiceSummary calculateFare(Ride ...rides) {
		double totalFare = 0;
		double rideFare;
		for(Ride ride : rides) {
			rideFare = ride.distance * ride.rideType.COST_PER_KM + ride.time * ride.rideType.COST_PER_MINUTE;
			totalFare += Math.max(rideFare, ride.rideType.MIN_FARE);
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
