import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
	InvoiceGenerator invoiceGenerator;

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
    }
    
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
    	double distance = 2.0;
    	int time = 5;
    	Ride ride = new Ride(distance, time);
    	InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(ride);
    	InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 25);
    	Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
    
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
    	double distance = 0.01;
    	int time = 1;
    	Ride ride = new Ride(distance, time);
    	InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(ride);
    	InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(1, 5);
    	Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
    
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
    	Ride ride1 = new Ride(4.0, 10);
    	Ride ride2 = new Ride(0.01, 1);
    	InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(ride1, ride2);
    	InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 55);
    	Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
    
    @Test
    public void givenUserId_IfPresentInRideRepository_ShouldReturnInvoiceSummary() {
    	invoiceGenerator.addRideToRepository("user1", new Ride(6.0, 10), new Ride(1.5, 3));
    	invoiceGenerator.addRideToRepository("user2", new Ride(4.0, 5), new Ride(0.01, 1), new Ride(3.0, 4));
    	invoiceGenerator.addRideToRepository("user3", new Ride(8.0, 7), new Ride(2.0, 2));
    	InvoiceSummary invoiceSummary = invoiceGenerator.calculateFareForUser("user2");
    	InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 84);
    	Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
    
}
