import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProductAlimentary extends Product {
	GregorianCalendar expiration;

	public ProductAlimentary(String n, GregorianCalendar d) {
		super(n);
		this.expiration = d;
	}
	
	public ProductAlimentary(String n, int q, GregorianCalendar d) {
		super(n,q);
		this.expiration = d;
	}
	
	public ProductAlimentary(String n, int y, int m, int d) {
		super(n);
		this.expiration = new GregorianCalendar(y,m,d);
	}
	
	public ProductAlimentary(String n, int q, int y, int m, int d) {
		super(n,q);
		this.expiration = new GregorianCalendar(y,m,d);
	}
	
	
	public GregorianCalendar getExpiration(){
		return this.expiration;
	}
	
	public boolean canBeSold(){
		GregorianCalendar current = new GregorianCalendar();
		current.add(Calendar.DATE, 3);
		
		if(this.expiration.after(current)){
			return true;
		}
		
		return false;
	}

}
