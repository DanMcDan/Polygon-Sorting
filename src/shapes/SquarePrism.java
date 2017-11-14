package shapes;

public class SquarePrism extends Polygon{

	public SquarePrism(double height, double width, char compareType) {
		super(compareType, height, width);
	}

	@Override
	public double getArea() {
		return width * width;
	}

	@Override
	public double getVolume() {
		return width * width * height;
	}

}
