package nu.milsson.fullambda.test;

import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;


public class Test {
	
	
	
	public static void main(String[] args) throws Throwable {
		final Market market = new Market("YRSE");
		final Customer c1 = new Customer("Test1",new Address("Street1"));
		c1.addOrder(market);
		final Customer c2 = new Customer("Test2",new Address("Street2"));
		c2.addOrder(market);
		c2.addOrder(market);
		
		final BOReport<Customer> _report = boReport(Customer.class);
		_report.format(toStr()).getName();
		_report.format(toStr()).getAddress().getStreet();
		_report.format(toInt()).getOrders(market);
		
		_report.render(Arrays.asList(c1,c2));
	}
	
	
	
	private static <T> BOReport<T> boReport(Class<T> tc)
	{
		return new BOReport<T>(tc);
	}
	
	private static Format toStr()
	{
		return new Format(){
			private static final long serialVersionUID = 1;

			@Override
			public StringBuffer format(Object obj, StringBuffer toAppendTo,	FieldPosition pos) {
				return toAppendTo.append(String.valueOf(obj));
			}

			@Override
			public Object parseObject(String source, ParsePosition pos) {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	private static Format toInt()
	{
		return NumberFormat.getIntegerInstance();
	}
}