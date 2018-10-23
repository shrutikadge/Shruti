package com.tickets.tickets.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tickets.tickets.entity.Movie;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

	Movie getMovieByName(String name);
}
