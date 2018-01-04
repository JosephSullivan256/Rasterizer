package core;

import math.Vec3;

public final class Vertex<T> {
	
	public final Vec3 pos;
	public final T attributes;
	
	public Vertex(Vec3 pos, T attributes){
		this.pos = pos;
		this.attributes = attributes;
	}
}
