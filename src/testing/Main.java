package testing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import functions.UniformFunction1;
import math.Matrix;
import math.Vec3;
import pipeline.Function;
import pipeline.Pipeline;
import types.Vertex;

public class Main {
	
	public static void main(String[] args) {
		List<Vertex<Color>> vertices = new ArrayList<Vertex<Color>>();
		vertices.add(new Vertex<Color>(new Vec3(0.5f,-0.5f,1f),Color.red));
		vertices.add(new Vertex<Color>(new Vec3(0f,0.5f,1f),Color.blue));
		vertices.add(new Vertex<Color>(new Vec3(-0.5f,-0.5f,1f),Color.green));
		
		UniformFunction1<List<Vertex<Color>>,List<Vertex<Color>>,Matrix> vertexShader = new UniformFunction1<List<Vertex<Color>>,List<Vertex<Color>>, Matrix>() {
			
			private Matrix transform = null;
			
			public List<Vertex<Color>> apply(List<Vertex<Color>> input) {
				List<Vertex<Color>> output = new ArrayList<Vertex<Color>>();
				for(Vertex<Color> v: input){
					output.add(new Vertex<Color>(Vec3.fromColMatrix(transform.times(v.pos.asColumnMatrix4())),v.attributes));
				}
				return output;
			}

			@Override
			public void set1(Matrix value) {
				this.transform = value;
			}
		};
		
		
		
	}
}
