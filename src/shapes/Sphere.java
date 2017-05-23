package shapes;

public class Sphere implements Shape{

	private double radius;
	
	public Sphere(double radius){
		this.radius = radius;
	}
	
	public String toString(){
		return "Sphere. Volume: " + getVolume() + " Radius: " + radius;
	}
	
	@Override
	public Double getVolume() {
		return 4.0 / 3.0 * Math.PI * Math.pow(radius, 3);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
