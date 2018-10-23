package com.tickets.tickets.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tickets.tickets.entity.Person;


@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{

	//public Person findByName(String name);
}
