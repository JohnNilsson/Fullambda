package nu.milsson.fullambda;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CallChainBuilderInterceptor implements MethodInterceptor {

	private final CallChain cc;
	
	public CallChainBuilderInterceptor(CallChain cc)
	{
		this.cc = cc;
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable 
	{
		cc.add(new MethodCall<Object,Object>(method,args));
		
		if(Modifier.isFinal(method.getReturnType().getModifiers()))
			return null;
		else if(method.getReturnType().isPrimitive())
			return Utils.defaultValueFor(method.getReturnType());
		else
			return Enhancer.create(method.getReturnType(), this);
	}
}