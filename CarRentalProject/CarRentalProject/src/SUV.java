import java.util.Scanner;

public class SUV implements Vehicle{

	@Override
	public double rent(double rent,double days) {
		MidSizeCar m=new MidSizeCar();
		double mRent=m.rent(rent, days);
		
		rent =1.5*mRent; 
		
		System.out.println("Will you go off-road? ");
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		if(s.equals("yes")){
			System.out.println("Your rent for SUV will be: "+ (rent+15)*days);
		}
		else{
			System.out.println("Your rent for SUV will be: "+ rent*days);
		}
		return rent;
	}

	
	
	
}
