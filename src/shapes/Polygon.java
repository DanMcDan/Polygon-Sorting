package shapes;

public abstract class Polygon implements Comparable<Polygon> {
	protected char compareType;
	
	
	public abstract double getArea();
	public abstract double getVolume();
}
