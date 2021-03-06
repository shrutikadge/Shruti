package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Goal save(Goal goal) {
		// TODO Auto-generated method stub
		em.persist(goal);
		em.flush();
		return goal;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Goal> loadAll() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select g from Goal g");
		List goals = query.getResultList();
		return goals;
	}

	@SuppressWarnings("unchecked")
	public List<GoalReport> findAllGoalReports() {
		Query query = em.createQuery("Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity)" +
	                                 "from Goal g, Exercise e where g.id = e.goal.id");
		return query.getResultList();
	}

}
