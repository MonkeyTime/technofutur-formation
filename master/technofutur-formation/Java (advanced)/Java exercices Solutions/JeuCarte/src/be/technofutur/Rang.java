package jeucarte;

public enum Rang {
	AS(13),ROI(12),DAME(11),VALET(10),
	DIX(9),NEUF(8),HUIT(7),SEPT(6),SIX(5),
	CINQ(4),QUATRE(3),TROIS(2),DEUX(1);
	
	protected Integer valeur;
	
	Rang(Integer valeur){
		this.valeur = valeur;
	}
	
	public Integer getValeur(){
		return this.valeur;
	}
	
}
