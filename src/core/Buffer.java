package core;

public class Buffer<T> {
	
	private T[][] fragments;
	private T clearValue;
	
	private int width;
	private int height;
	
	public Buffer(T[][] fragments, T clearValue){
		this.fragments = fragments;
		this.width = fragments.length;
		this.height = fragments[0].length;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public T get(int x, int y){
		return fragments[x][y];
	}
}
