package pipeline;

public class FunctionPair<A,B,C> implements Function<A,C>{
	private Function<A,B> f1;
	private Function<B,C> f2;
	
	public FunctionPair(Function<A,B> f1, Function<B,C> f2){
		this.f1 = f1;
		this.f2 = f2;
	}

	@Override
	public C apply(A a) {
		return f2.apply(f1.apply(a));
	}
}