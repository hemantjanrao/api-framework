package api.tests;

import api.dto_objects.Booking.Booking;
import api.dto_objects.Booking.CreateBookingResponse;
import api.service.BookingService;
import api.service.PingService;
import common.retry.RetryFlakyTests;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

@Test(retryAnalyzer = RetryFlakyTests.class)
public class BookingTests extends BaseAPITest {

    public void pingTestServer() {
        assertThat(new PingService().ping()).isEqualTo("Created");
    }

    public void create_new_booking(){
        BookingService service = new BookingService();
        Booking booking = Booking.newInstance();

        CreateBookingResponse bookingResponse = service.createBooking(booking);

        assertThat(bookingResponse.booking).isEqualTo(booking);
        assertThat(service.getBooking(bookingResponse.bookingid)).isEqualTo(booking);
    }
}

