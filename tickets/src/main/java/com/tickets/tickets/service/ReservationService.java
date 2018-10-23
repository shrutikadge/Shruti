package com.tickets.tickets.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickets.tickets.domain.MovieReservation;
import com.tickets.tickets.entity.Movie;
import com.tickets.tickets.entity.Person;
import com.tickets.tickets.entity.Reservation;
import com.tickets.tickets.repository.MovieRepository;
import com.tickets.tickets.repository.PersonRepository;
import com.tickets.tickets.repository.ReservationRepository;



@Service
public class ReservationService {

	private MovieRepository movieRepository;
	private PersonRepository personRepository;
	private ReservationRepository reservationRepository;
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	public ReservationService(PersonRepository personRepository, ReservationRepository reservationRepository, MovieRepository movieRepository) {
		super();
		this.personRepository = personRepository;
		this.reservationRepository = reservationRepository;
		this.movieRepository = movieRepository;
	}
	
	public List<MovieReservation> getMovieReservationsForDate(String dateString){
        Date date = this.createDateFromDateString(dateString);
        Iterable<Movie> movies = this.movieRepository.findAll();
        Map<Long, MovieReservation> movieReservationMap = new HashMap<>();
        movies.forEach(movie->{
            MovieReservation movieReservation = new MovieReservation();
            movieReservation.setMovieId(movie.getId());
            movieReservation.setMovieName(movie.getName());
            movieReservationMap.put(movie.getId(), movieReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findByDate(new java.sql.Date(date.getTime()));
        if(null!=reservations){
            reservations.forEach(reservation -> {
            	//Person guest = this.personRepository.findOne(reservation.getUserId());
                Optional<Person> guest = this.personRepository.findById(reservation.getUserId());
                if(null!=guest){
                    MovieReservation movieReservation = movieReservationMap.get(reservation.getId());
                    movieReservation.setDate(date);
                    movieReservation.setFirstName(guest.get().getFirstName());
                    movieReservation.setLastName(guest.get().getLastName());
                    movieReservation.setPersonId(guest.get().getId());
                }
            });
        }
        List<MovieReservation> movieReservations = new ArrayList<>();
        for(Long movieId:movieReservationMap.keySet()){
            movieReservations.add(movieReservationMap.get(movieId));
        }
        return movieReservations;
    }
	
	private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null!=dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }
}
