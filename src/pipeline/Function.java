package pipeline;

public interface Function<A,B> {
	public B apply(A a);
}
