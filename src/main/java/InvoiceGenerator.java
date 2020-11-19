
public class InvoiceGenerator {

	private static final double COST_PER_KM = 10;
	private static final int COST_PER_MINUTE = 1;
	private static final double MIN_FARE = 5;

	public InvoiceSummary calculateFare(Ride ...rides) {
		double totalFare = 0;
		double rideFare;
		for(Ride ride : rides) {
			rideFare = ride.distance * COST_PER_KM + ride.time * COST_PER_MINUTE;
			totalFare += Math.max(rideFare, MIN_FARE);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

}
