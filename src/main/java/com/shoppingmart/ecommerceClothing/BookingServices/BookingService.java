package com.shoppingmart.ecommerceClothing.BookingServices;
import java.util.*;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmart.ecommerceClothing.productsService.ProductRepo;
import com.shoppingmart.ecommerceClothing.productsService.Productsdto;

import jakarta.persistence.Query;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private ProductRepo productRepo;

    public BookingDto saveBooking(BookingDto bookingDto)
    {
        int pid=bookingDto.getProductId();
        int quantity=bookingDto.getQuantity();
        Optional<Productsdto> optional=productRepo.findById(pid);
        int totalprice=optional.get().getPrice()*quantity;
        bookingDto.setTotalPrice(totalprice);
        int price=optional.get().getPrice();
        bookingDto.setPrice(price);
        bookingDto.setBookingdateTime(LocalDateTime.now());

        return bookingDao.saveBooking(bookingDto);
    }

    public Optional<BookingDto> getbyid(int i)
    {
        return bookingDao.getbyid(i);
    }

     public List<BookingDto> getbypaymenttype(String s)
    {
        return bookingDao.getbypaymenttype(s);
    }
}
