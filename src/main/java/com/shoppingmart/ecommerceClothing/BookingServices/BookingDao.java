package com.shoppingmart.ecommerceClothing.BookingServices;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class BookingDao {

    @Autowired
    private BookingRepo bookingRepo;

    public BookingDto saveBooking(BookingDto bookingDto)
    {
        return bookingRepo.save(bookingDto);
    }

    public Optional<BookingDto> getbyid(int i)
    {
        return bookingRepo.findById(i);
    }

    @Autowired
    private EntityManager entityManager;

    public List<BookingDto> getbypaymenttype(String s)
    {
       Query q= entityManager.createQuery("SELECT a FROM BookingDto a WHERE a.paymentType LIKE :s");
                      q.setParameter("s", s); 
                      return  q.getResultList();
        
    }
}
