package packassociations;

public class Point {

	private double x;
	private double y;
	
	// Variable de classe => initialisation ici
	private static int nbPoints = 0;
	
	public Point(double x, double y) {
		// Initialisation des variables d'instance à l'aide des arguments 
		this.x = x;
		this.y = y;
		// Constructeur => création d'un point => augmentation du nombre de points
		nbPoints++;
	}
	
	public Point() {
		// Initialisation des variables d'instance à l'aide de valeurs par défaut 
		this.x = 0;
		this.y = 0;
		// Constructeur => création d'un point => augmentation du nombre de points
		nbPoints++;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public String toString() {
		// Renvoie l'état de l'objet Point
		return "(" + x + "," + y + ")";
	}
	
	public void translation(double deplacementX, double deplacementY) {
		// Modification de la valeur de x et de y
		x += deplacementX;
		y += deplacementY;
	}
	
	public void translation(Point p) {
		// Modification de la valeur de x et de y
		x += p.x;
		y += p.y;
	}
	
	public void symOrthogonaleX() {
		// Modification de la valeur de y
		y = -y;
	}
	
	public void symOrthogonaleY() {
		// Modification de la valeur de x
		x = -x;
	}
	
	public void symCentrale() {
		// Modification de la valeur de x et de y
//		x = -x;
//		y = -y;
		symOrthogonaleX();
		symOrthogonaleY();
	}
	
	public static int getNbPoints() {
		return nbPoints;
	}
	
	public double calculerDistance(Point p) {
		// Méthode d'instance => appelée sur un objet matérialisé par "this" => 1 objet en argument
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}
	
	public static double calculerDistance(Point p1, Point p2) {
		// Méthode de classe => appelée sur le nom de la classe => "this" non disponible => 2 objets en argument
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	
	public Point clone() {
		// Retourne un NOUVEAU point crée à partir des valeurs du premier
		return new Point(this.x, this.y);
	}
	
	public boolean equals(Point p) {
		// Comparaison sur la valeur des attributs des 2 points
		return (this.x == p.x) && (this.y == p.y);
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
}
