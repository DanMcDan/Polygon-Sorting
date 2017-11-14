package shapes;

public class TriangularPrism extends Polygon{

	public TriangularPrism(double height, double width, char compareType) {
		super(compareType, height, width);
	}

	@Override
	public double getArea() {
		return ((width * width) * Math.sqrt(3))/4;
	}

	@Override
	public double getVolume() {
		return getArea() * height;
	}

}
