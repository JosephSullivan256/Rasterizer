package math;

public class Vec2 {
	
	private final float x, y;
	
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
	
	public Matrix asRowMatrix() {
		return new Matrix(new float[][] {{x,y,1,1}});
	}
	
	public Matrix asRowMatrix4() {
		return new Matrix(new float[][] {{x,y,1,1}});
	}
	
	public Matrix asColumnMatrix() {
		return asRowMatrix().transpose();
	}
	
	public Matrix asColumnMatrix4() {
		return asRowMatrix4().transpose();
	}
}
