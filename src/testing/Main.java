package testing;

import pipeline.Function;
import pipeline.Pipeline;

public class Main {
	
	public static void main(String[] args) {
		Function<Integer,String> t1 = (Integer a)->"hi";
		Function<String,Double> t2 = (String a)->3.14;
		Function<Double,Boolean> t3 = (Double a)->false;
		
		Pipeline<Integer,Boolean> p = Pipeline.create(t1).push(t2).push(t3);
		System.out.println(p.apply(7));
	}
}
