package shapes;

public abstract class Polygon implements Comparable<Polygon> {
	protected char compareType;
	protected double height;
	protected double width;
	
	
	public Polygon(char compareType, double height, double width) {
		this.compareType = compareType;
		this.height = height;
		this.width = width;
	}
	
	
	public abstract double getArea();
	public abstract double getVolume();
	
	
	public double getHeight() {
		return height;
	}
	
	public int compareTo(Polygon o) {
		double compareSize = 0;
		double otherSize = 0;
		
		switch(compareType) {
		case 'h':
			compareSize = this.getHeight();
			otherSize = o.getHeight();
			break;
			
		case 'v':
			compareSize = this.getVolume();
			otherSize = o.getVolume();
			break;
			
		case 'a':
			compareSize = this.getArea();
			otherSize = o.getArea();
			break;
		}
		
		
		return (int) (compareSize - otherSize);
	}
	
	@Override
	public String toString() {
		switch(compareType) {
		case 'a':
			return this.getClass().getName() + ", Area: " + this.getArea();
			
		case 'h':
			return this.getClass().getName() + ", Height: " + this.getHeight();
			
		case 'v':
			return this.getClass().getName() + ", Volume: " + this.getVolume();
			
			default:
				return null;
		}
	}
}
