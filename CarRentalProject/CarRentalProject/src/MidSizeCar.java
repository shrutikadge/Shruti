import java.util.Calendar;

public class MidSizeCar implements Vehicle{

	
	@Override
	public double rent(double rent,double days) {
		
		Calendar c=Calendar.getInstance();
		int day=c.get(Calendar.DAY_OF_WEEK);
		
		if(day==6||day==7){
			rent =30;
			double premium=rent+(0.25*30);
			System.out.println("Your rent for MidSize Car will be: "+premium*days);
			rent=premium;
			
			
		}
		else if(day==1)
		{
			rent=30;
			double discount= rent-(0.20*30);
			System.out.println("Your rent for MidSize Car will be: "+discount*days);
			rent = discount;
		}
		else{
			System.out.println("Your rent for MidSize Car will be: "+30*days);
			rent=30;
		}
		return rent;
	}

}
