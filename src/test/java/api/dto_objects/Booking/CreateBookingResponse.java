package api.dto_objects.Booking;

import api.dto.AbstractDTO;

public class CreateBookingResponse extends AbstractDTO<CreateBookingResponse> {
    public Booking booking;
    public int bookingid;
}
