import java.util.ArrayList;
import java.util.Vector;
import java.util.*;

public class Stock extends Vector<Product> {
	
	private String name;
	private String address;
	
	public Stock(String n, String ad) {
		super();
		this.name = n;
		this.address = ad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public Product nameToProduct(String name){
		Iterator<Product> it = this.iterator();
		while(it.hasNext()){
			Product current = it.next();
			if(name == current.getName()){
				return current;
			}
		}
		return null;
	}
	
	public Product nameToProductEnum(String name){
		Enumeration<Product> enumer = this.elements();
		
		while(enumer.hasMoreElements()){
			Product current = enumer.nextElement();
			if(name == current.getName()){
				return current;
			}
			
		}
		
		
		return null;
	}
	
	public void display(){
		System.out.println("the stock name is : " + this.getName());
		System.out.println("the stock address is :" + this.getAdress());
		System.out.println("\n");
		Enumeration<Product> enumer = this.elements();
		while(enumer.hasMoreElements()){
			Product current = enumer.nextElement();
			current.display();
		}

	}
	
	

}
