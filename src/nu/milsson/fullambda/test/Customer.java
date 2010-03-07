/**
 * 
 */
package nu.milsson.fullambda.test;

import java.util.HashMap;
import java.util.Map;

class Customer
{
	private String name;
	private Address address;
	private Map<Market,Integer> orders;
	
	Customer(String name, Address address)
	{
		this.name = name;
		this.address = address;
		this.orders = new HashMap<Market,Integer>();
	}
	
	Customer(){
		
	}
	
	String getName() {
		return name;
	}

	Address getAddress() {
		return address;
	}

	void addOrder(Market market)
	{
		orders.put(market, getOrders(market)+1);
	}
	
	int getOrders(Market m)
	{
		Integer os = orders.get(m);
		return (os != null) ? os.intValue() : 0;
	}
}