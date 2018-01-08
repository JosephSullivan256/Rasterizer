package testing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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
		
		Function<List<Vertex<Color>>,List<Vertex<Color>>> vertexShader =
				(input) -> {
					List<Vertex<Color>> output = new ArrayList<Vertex<Color>>();
					for(Vertex<Color> v: input){
						output.add(new Vertex<Color>(v.pos,v.attributes));
					}
					return output;
				};
	}
}
