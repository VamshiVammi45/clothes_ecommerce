package com.shoppingmart.ecommerceClothing.BookingServices;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/SaveBooking")
    public BookingDto saveBooking(@RequestBody BookingDto bookingDto)
    {
        return bookingService.saveBooking(bookingDto);
    }

    @GetMapping("/getbyid/{i}")
     public Optional<BookingDto> getbyid(@PathVariable int i)
    {
        return bookingService.getbyid(i);
    }

    @GetMapping("/getbypayment/{s}")
    public List<BookingDto> getbypaymenttype(@PathVariable String s)
    {
        return bookingService.getbypaymenttype(s);
    }
}
