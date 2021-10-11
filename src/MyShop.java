import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class MyShop {
	
	private String name;
	private ArrayList<Stock> stocks;
	
	public MyShop(String n){
		this.setName(n);
		this.stocks = new ArrayList<Stock>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Stock> getStocks(){
		return this.stocks;
	}
	
	public void addStock(Stock s){
		this.stocks.add(s);
	}
	
	public Stock nameToStock(String name){
		
		Iterator<Stock> it = stocks.iterator();
		while(it.hasNext()){
			Stock current = it.next();
			if(name.equals(current.getName())){
				return current;
			}
		}
		return null;
	}

	public void display(){
		System.out.println("shop name : " + this.getName());
		System.out.println("\n");
		for(int i =0; i<stocks.size(); i++){
			stocks.get(i).display();
		}
	}

	
}
