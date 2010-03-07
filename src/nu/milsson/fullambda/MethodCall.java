package nu.milsson.fullambda;

import java.lang.reflect.Method;

import nu.milsson.fp.Function;

class MethodCall<T,R> extends Function<T,R>{
	private final Object[] args;
	private final Method method;
	
	MethodCall(Method method, Object...args)
	{
		this.method = method;
		this.args = args;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public R apply(T arg) throws Throwable {
		return (R)method.invoke(arg, args);
	}
}
