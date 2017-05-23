package shapes;

public class Ellipsoid implements Shape {

	private double radius1;
	private double radius2;
	private double radius3;
	
	public Ellipsoid(double radius1, double radius2, double radius3){
		this.radius1 = radius1;
		this.radius2 = radius2;
		this.radius3 = radius3;
	}
	
	public String toString(){
		return "Ellipsoid. Volume: " + getVolume() + " Radii: " + radius1  + ", " + radius2 + ", " + radius3;
	}
	
	@Override
	public Double getVolume() {
		return 4.0/3.0 * Math.PI * radius1 * radius2 * radius3;
	}

	public double getRadius1() {
		return radius1;
	}

	public void setRadius1(double radius1) {
		this.radius1 = radius1;
	}

	public double getRadius2() {
		return radius2;
	}

	public void setRadius2(double radius2) {
		this.radius2 = radius2;
	}

	public double getRadius3() {
		return radius3;
	}

	public void setRadius3(double radius3) {
		this.radius3 = radius3;
	}

}
