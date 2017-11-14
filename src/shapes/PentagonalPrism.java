package shapes;

public class PentagonalPrism extends Polygon{

	public PentagonalPrism(double height, double width, char compareType) {
		super(compareType, height, width);
	}

	@Override
	public double getArea() {
		return ((5 * Math.pow(width, 2) * Math.tan(Math.toRadians(54))))/4;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return getArea() * height;
	}

}
