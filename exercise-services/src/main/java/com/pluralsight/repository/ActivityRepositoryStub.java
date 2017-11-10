package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Activity;

public class ActivityRepositoryStub implements ActivityRepository {

	/* (non-Javadoc)
	 * @see com.pluralsight.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities(){
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity1=new Activity();
		activity1.setDesciption("Swimming");
		activity1.setDuration(55);
		activities.add(activity1);
		
		Activity activity2=new Activity();
		activity2.setDesciption("Cycling");
		activity2.setDuration(120);
		activities.add(activity2);
	    
		return activities;
	}

	@Override
	public Activity findActivity(String activityId) {
		// TODO Auto-generated method stub
		Activity activity1=new Activity();
		activity1.setId("1234");
		activity1.setDesciption("Swimming");
		activity1.setDuration(55);
		return activity1;
	}
}
