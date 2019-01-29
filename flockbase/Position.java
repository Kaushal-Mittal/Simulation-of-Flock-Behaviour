package flockbase;

public class Position {
	// helper class
		public Position(int px, int py) {
				x = px;
				y = py;
		}
		public static Position add(Position a1, Position a2){
			int x = a1.getX() + a2.getX();
			int y = a1.getY() + a2.getY();
			return new Position(x,y);
		}
		public static Position sub(Position a1, Position a2){
			int x = a1.getX() - a2.getX();
			int y = a1.getY() - a2.getY();
			return new Position(x,y);
		}

		public static Position multiply(Position v1, double s1) {
			Double x = v1.getX() * s1;
			Double y = v1.getY() * s1;
			return new Position(x.intValue(), y.intValue());
		}

		public static Position division(Position v1, double s1) {
			Double x = v1.getX() / s1;
			Double y = v1.getY() / s1;
			return new Position(x.intValue(), y.intValue());
		}

		public static int mag(Position v1) {
			Double d;
			d = Math.sqrt(Math.pow(v1.getX(), 2) + Math.pow(v1.getY(), 2));
			return d.intValue();
		}

		public int getX() {
			return (int)x;
		}

		public int getY() {
			return (int)y;
		}

		public void setPos(int px, int py) {
				x = px;
				y = py;
		}

		public String toString() {
			return ("( " + x + ", " + y + " )");
		}
		
		private double x, y;
}
