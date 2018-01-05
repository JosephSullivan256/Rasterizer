package core;

public interface Process<A,B> {
	public B perform(A a);
}
