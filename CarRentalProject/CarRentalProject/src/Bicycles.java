
public class Bicycles implements Vehicle{

	@Override
	public double rent(double rent,double days) {
		
		
		System.out.println("Your rent for Bicycle will be: "+ rent*days);
		return rent;
	}
	
	
}
