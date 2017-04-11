package AbstractFactory;

interface PointCornerFactory  {
	Point getPoint();
	Corner getCorner();
}

interface Point {
	void line(int width);
}

interface Corner {
	void leftUp();
	void rightUp();
	void leftDown();
	void rightDown();
}

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	void paint(PointCornerFactory factory) {
		Point point = factory.getPoint();
		Corner corner = factory.getCorner();
		
		corner.leftUp();
		point.line(width - 2);
		corner.rightUp();
		System.out.println();
		for(int i = 0; i < height - 2; i ++) {
			point.line(width);
			System.out.println();
		}
		
		corner.leftDown();
		point.line(width - 2);
		corner.rightDown();
		System.out.println();
	}
}
