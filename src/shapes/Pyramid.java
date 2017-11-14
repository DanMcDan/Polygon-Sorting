package shapes;

public class Pyramid extends Polygon{

	public Pyramid(double height, double width, char compareType) {
		super(compareType, height, width);
	}
	
	
	@Override
	public double getArea() {
		return Math.pow(width, 2);
	}

	@Override
	public double getVolume() {
		return (Math.pow(width, 2)*height)/3;
	}

}
