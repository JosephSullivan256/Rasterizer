package functions;

import java.util.ArrayList;
import java.util.List;

import pipeline.Function;

public class ListFunction<A,B> implements Function<List<A>,List<B>> {
	
	private Function<A,B> function;
	
	public ListFunction(Function<A,B> function){
		this.function = function;
	}
	
	@Override
	public List<B> apply(List<A> input) {
		List<B> output = new ArrayList<B>();
		for(A a: input){
			output.add(function.apply(a));
		}
		return output;
	}
}
