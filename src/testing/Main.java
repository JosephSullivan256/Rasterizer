package testing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import functions.ListFunction;
import functions.UniformFunction1;
import math.Matrix;
import math.Vec3;
import pipeline.Function;
import pipeline.Pipeline;
import types.Position;

public class Main {
	
	public static void main(String[] args) {
		int width = 640;
		int height = 480;
		
		List<Position<Color>> vertices = new ArrayList<Position<Color>>();
		vertices.add(new Position<Color>(new Vec3(0.5f,-0.5f,2f),Color.red));
		vertices.add(new Position<Color>(new Vec3(0f,0.5f,2f),Color.blue));
		vertices.add(new Position<Color>(new Vec3(-0.5f,-0.5f,2f),Color.green));
		
		// Vertex Shader => converts to screen space
		UniformFunction1<Position<Color>,Position<Color>,Matrix> vertexShader = new UniformFunction1<Position<Color>,Position<Color>, Matrix>() {
			
			private Matrix transform = Matrix.i44;
			
			public Position<Color> apply(Position<Color> v) {
				Matrix tx0 = transform.times(v.pos.asColumnMatrix4());
				Vec3 tx1 = Vec3.fromColMatrix(tx0).scaledBy(1f/tx0.getVals()[0][3]);
				return new Position<Color>(tx1,v.attributes);
			}
			
			@Override
			public void set1(Matrix value) {
				this.transform = value;
			}
		};
		
		vertexShader.set1(Matrix.perspective(((float)Math.PI)/4f, width/height, 1f, 100000f));
		
		ListFunction<Position<Color>,Position<Color>> vertexShaderIteration = new ListFunction<Position<Color>,Position<Color>>(vertexShader);
		
		Function<Position<Color>,Color> fragmentShader = new Function<Position<Color>,Color>() {
			@Override
			public Color apply(Position<Color> a) {
				return null;
			}
		};
		
		ListFunction<Position<Color>,Color> fragmentShaderIteration = new ListFunction<Position<Color>,Color>(fragmentShader);
		
	}
}
