package nu.milsson.fullambda;

import nu.milsson.fp.Function;

public class CallChain extends Function<Object,Object>{
	
	Function<Object,Object> fun = id();
	
	public void add(Function<Object,Object> fun)
	{
		this.fun = this.fun.andThen(fun);
	}

	@Override
	public Object apply(Object arg) throws Throwable {
		return fun.apply(arg);
	}
}