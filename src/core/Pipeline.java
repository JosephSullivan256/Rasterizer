package core;

public class Pipeline<A,B> implements Function<A,B> {
	
	private Function<A,B> t;
	
	private Pipeline(Function<A,B> t){
		this.t = t;
	}
	
	public <T> Pipeline<A,T> push(Function<B,T> t1){
		return new Pipeline<A,T>((a)->t1.apply(t.apply(a)));
	}
	
	@Override
	public B apply(A a) {
		return t.apply(a);
	}
	
	public static <C,D> Pipeline<C,D> create(Function<C,D> t){
		return new Pipeline<C,D>(t);
	}
}
