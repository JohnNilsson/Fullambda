package nu.milsson.fp;

public abstract class Function<A,R> {
	public abstract R apply(A arg) throws Throwable;
	
	public <U> Function<A,U> andThen(final Function<? super R,U> fun){
		return new Function<A,U>(){
			public U apply(A arg) throws Throwable {
				return fun.apply(Function.this.apply(arg));
			}			
		};
	}
	
	
	private static final Function<Object,Object> ID = new Function<Object,Object>()
	{
		@Override
		public Object apply(Object arg) throws Throwable {
			return arg;
		}
	};
	
	
	@SuppressWarnings("unchecked")
	public static <T> Function<T,T> id()
	{
		return (Function<T,T>)ID;
	}
}
