package api.service;

import api.AbstractBookerService;
import api.constants.BookerEndpoints;
import api.dto_objects.Booking.Booking;
import api.dto_objects.Booking.CreateBookingResponse;

public class BookingService extends AbstractBookerService {

    public CreateBookingResponse createBooking(Booking booking) {
        return post(booking, BookerEndpoints.BOOKING.getUrl()).as(CreateBookingResponse.class);
    }

    public Booking getBooking(int id) {
        return get(BookerEndpoints.BOOKING_ID.getUrl(id)).as(Booking.class);
    }
}
