package shapes;

import java.io.Serializable;

public class Cone implements Shape, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double height;
	private double radius;
	
	public Cone(double height, double radius){
		this.height = height;
		this.radius = radius;
	}
	
	public String toString(){
		return "Cone. Volume: " + getVolume() + " Radius: " + radius + " Height: " + height;
	}
	
	@Override
	public Double getVolume() {
		double vol = 1/3.0 * Math.PI * radius * radius * height;
		return vol;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
