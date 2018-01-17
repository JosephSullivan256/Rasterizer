package math;

public class Vec2 {
	
	public final float x, y;
	
	public Vec2(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Vec2 plus(Vec2 v) {
		return new Vec2(x+v.x,y+v.y);
	}
	
	public Vec2 scaledBy(float s) {
		return new Vec2(s*x,s*y);
	}
	
	public Vec2 minus(Vec2 v) {
		return this.plus(v.scaledBy(-1f));
	}
	
	public float dot(Vec2 v) {
		return x*v.x+y*v.y;
	}
	
	public float cross(Vec2 v) {
		return x*v.y-y*v.x;
	}
	
	public float magnitudeSquared() {
		return dot(this);
	}
	
	public float magnitude() {
		return (float) Math.sqrt(magnitudeSquared());
	}
}
