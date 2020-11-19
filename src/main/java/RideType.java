
public enum RideType {
	NORMAL(10, 1, 5), PREMIUM(15, 2, 20);
	
	public double COST_PER_KM;
    public int COST_PER_MINUTE;
    public double MIN_FARE;

    RideType(double COST_PER_KM, int COST_PER_MINUTE, double MIN_FARE) {
        this.COST_PER_KM = COST_PER_KM;
        this.COST_PER_MINUTE = COST_PER_MINUTE;
        this.MIN_FARE = MIN_FARE;
    }
}
