package types;

import math.Vec3;

public final class Position<T> {
	
	public final Vec3 pos;
	public final T attributes;
	
	public Position(Vec3 pos, T attributes){
		this.pos = pos;
		this.attributes = attributes;
	}
}
