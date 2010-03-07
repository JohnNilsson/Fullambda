/**
 * 
 */
package nu.milsson.fullambda.test;

import java.util.HashMap;
import java.util.Map;

public class Customer
{
	private String name;
	private Address address;
	private Map<Market,Integer> orders;
	
	public Customer(String name, Address address)
	{
		this.name = name;
		this.address = address;
		this.orders = new HashMap<Market,Integer>();
	}
	
	Customer(){
		
	}
	
	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public void addOrder(Market market)
	{
		orders.put(market, getOrders(market)+1);
	}
	
	public int getOrders(Market m)
	{
		Integer os = orders.get(m);
		return (os != null) ? os.intValue() : 0;
	}
}