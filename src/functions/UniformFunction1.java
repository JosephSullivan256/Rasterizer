package functions;

import pipeline.Function;

public interface UniformFunction1<A,B,T1> extends Function<A,B> {
	public void set1(T1 value);
}
