import java.util.Scanner;

public class Motorcycles implements Vehicle{

	@Override
	public double rent(double rent,double days) {
		MidSizeCar m=new MidSizeCar();
		double mRent=m.rent(rent, days);
	    rent=mRent;
		System.out.println("Enter you age");
		Scanner sc=new Scanner(System.in);
		double age=sc.nextDouble();
		double ins=this.insurance(age);
		
		System.out.println(ins);
		double rent1=(rent*days)+ins;
		System.out.println("Your rent for Motorcycle will be: "+ rent1);
		
		return rent+ins;
	}

	public double insurance(double age1){
		double i=0;
		if((age1>=18)&&(age1<=25)){
			
			i=50;
		}
			
		else if(age1>=26&&age1<=32)
		    {System.out.println(age1);
			i=35;}
		else if(age1>=33&&age1<=45)
			{i=15;}
		else if(age1>=45)
			{i=0;}
		else
			{i=0;}
	   
		return i;
	}
}
