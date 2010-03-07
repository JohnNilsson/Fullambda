/**
 * 
 */
package nu.milsson.fullambda.test;

import java.text.Format;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import nu.milsson.fullambda.CallChain;
import nu.milsson.fullambda.CallChainBuilderInterceptor;

class BOReport<T>
{
	private final Class<T> clz;
	private final List<CallChain> cols = new ArrayList<CallChain>();
	private final List<Format> fmts    = new ArrayList<Format>();
	
	BOReport(Class<T> clz)
	{
		this.clz = clz;
	}
	
	/**
	 * Returns a proxy of type T recording method calls.
	 */
	@SuppressWarnings("unchecked")
	public T format(Format f)
	{
		final CallChain cc = new CallChain();
		cols.add(cc);
		fmts.add(f);
		return (T)Enhancer.create(clz,new CallChainBuilderInterceptor(cc));
	}
	
	public void render(Iterable<T> ts) throws Throwable
	{
		for(T t : ts)
		{
			for(int i = 0; i<cols.size(); i++)
			{
				System.out.println(fmts.get(i).format(cols.get(i).apply(t)));
			}
		}
	}
}