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
import types.Triangle;

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
				return new Position<Color>(Vec3.fromColMatrix(transform.times(v.pos.asColumnMatrix4())),v.attributes);
			}
			
			@Override
			public void set1(Matrix value) {
				this.transform = value;
			}
		};
		
		vertexShader.set1(Matrix.perspective(((float)Math.PI)/4f, width/height, 1f, 100000f));
		
		ListFunction<Position<Color>,Position<Color>> vertexShaderIteration = new ListFunction<Position<Color>,Position<Color>>(vertexShader);
		
		// Perspective Divide => performs perspective divide
		Function<Position<Color>,Position<Color>> perspectiveDivide = new Function<Position<Color>,Position<Color>>(){

			@Override
			public Position<Color> apply(Position<Color> a) {
				return new Position<Color>(a.pos.scaledBy(a.pos.z),a.attributes);
			}
		};
		
		ListFunction<Position<Color>,Position<Color>> perspectiveDivideIteration = new ListFunction<Position<Color>,Position<Color>>(perspectiveDivide);
		
		// Primitive Assembly => converts from list of vertices into list of triangles
		Function<List<Position<Color>>,List<Triangle<Color>>> primitiveAssembly = new Function<List<Position<Color>>,List<Triangle<Color>>>(){
			
			public List<Triangle<Color>> apply(List<Position<Color>> input){
				List<Triangle<Color>> output = new ArrayList<Triangle<Color>>();
				for(int i = 0; i+2 < input.size(); i++) {
					output.add(new Triangle<Color>(input.get(i),input.get(i+1),input.get(i+2)));
				}
				return output;
			}
		};
		
		// Fragment Shader => converts from list of fragments into the colors
		Function<Position<Color>,Color> fragmentShader = new Function<Position<Color>,Color>() {
			@Override
			public Color apply(Position<Color> a) {
				return null;
			}
		};
		
		ListFunction<Position<Color>,Color> fragmentShaderIteration = new ListFunction<Position<Color>,Color>(fragmentShader);
		
		// Combining all of the previous functions in a pipeline
		Pipeline<List<Position<Color>>,List<Triangle<Color>>> pipeline = Pipeline
				.create(vertexShaderIteration)
				.push(perspectiveDivideIteration)
				.push(primitiveAssembly);
	}
}
