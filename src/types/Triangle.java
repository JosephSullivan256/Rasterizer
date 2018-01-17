package types;

public class Triangle<T> {
	private Position<T> a;
	private Position<T> b;
	private Position<T> c;
	
	public Triangle(Position<T> a, Position<T> b, Position<T> c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	
}
