package math;

public final class Vec3 {
	public final float x,y,z;
	
	public Vec3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public static Vec3 fromRowMatrix(Matrix m) {
		float[][] v = m.getVals();
		return new Vec3(v[0][0],v[0][1],v[0][2]);
	}
	
	public static Vec3 fromColMatrix(Matrix m) {
		return Vec3.fromRowMatrix(m.transpose());
	}
	
	public Vec3 plus(Vec3 v) {
		return new Vec3(x+v.x,y+v.y,z+v.z);
	}
	
	public Vec3 scaledBy(float s) {
		return new Vec3(s*x,s*y,s*z);
	}
	
	public Vec3 minus(Vec3 v) {
		return this.plus(v.scaledBy(-1f));
	}
	
	public float dot(Vec3 v) {
		return x*v.x+y*v.y+z*v.z;
	}
	
	public Vec3 cross(Vec3 v) {
		return new Vec3(y*v.z-z*v.x,z*v.x-x*v.z,x*v.y-y*v.x);
	}
	
	public Matrix asRowMatrix() {
		return new Matrix(new float[][] {{x,y,z}});
	}
	
	public Matrix asRowMatrix4() {
		return new Matrix(new float[][] {{x,y,z,1}});
	}
	
	public Matrix asColumnMatrix() {
		return asRowMatrix().transpose();
	}
	
	public Matrix asColumnMatrix4() {
		return asRowMatrix4().transpose();
	}
}