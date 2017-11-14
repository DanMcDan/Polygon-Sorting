package shapes;

public class OctagonalPrism extends Polygon{

	
	public OctagonalPrism(double height, double width, char compareType) {
		super(compareType, height, width);
	}
	

	@Override
	public double getArea() {
		return 2 * (1 + (Math.sqrt(2))) * Math.pow(width, 2);
	}

	@Override
	public double getVolume() {
		return this.getArea()*height;
	}

}
