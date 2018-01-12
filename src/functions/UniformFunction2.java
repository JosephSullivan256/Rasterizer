package functions;

import pipeline.Function;

public interface UniformFunction2<A,B,T1,T2> extends Function<A,B> {
	public void set1(T1 value);
	public void set2(T2 value);
}
