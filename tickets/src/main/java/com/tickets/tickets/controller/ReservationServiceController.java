package com.tickets.tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tickets.tickets.domain.MovieReservation;
import com.tickets.tickets.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ReservationServiceController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method= RequestMethod.GET, value="/reservations/{date}")
    public List<MovieReservation> getAllReservationsForDate(@PathVariable(value="date")String dateString){
        return this.reservationService.getMovieReservationsForDate(dateString);
    }
}
