package shapes;

public class Cylinder extends Polygon{
	

	public Cylinder(double height, double width, char compareType) {
		super(compareType, height, width);
	}


	@Override
	public double getArea() {
		return Math.PI * (Math.pow(width, 2));
	}

	@Override
	public double getVolume() {
		return (Math.PI * (Math.pow(width, 2)))*height;
	}

}
