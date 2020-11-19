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
}
