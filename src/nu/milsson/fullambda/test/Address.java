/**
 * 
 */
package nu.milsson.fullambda.test;

public class Address
{
	private String street;

	Address(String street) {
		this.street = street;
	}
	
	Address()
	{	
	}

	public String getStreet() {
		return street;
	}
}