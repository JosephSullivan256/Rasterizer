package types;

public interface Interperable<T> {
	public Interperable<T> interpolate(Interperable<T> a, float a1, Interperable<T> b, float b1, Interperable<T> c, float c1);
}
