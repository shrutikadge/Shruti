package com.tickets.tickets.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tickets.tickets.entity.Reservation;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{

	List<Reservation> findByDate(Date date);
}
