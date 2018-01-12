package functions;

import pipeline.Function;

public interface UniformFunction3<A,B,T1,T2,T3> extends Function<A,B> {
	public void set1(T1 value);
	public void set2(T2 value);
	public void set3(T3 value);
}
