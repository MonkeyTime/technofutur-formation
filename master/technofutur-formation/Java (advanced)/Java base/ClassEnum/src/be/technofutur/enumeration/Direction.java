package be.technofutur.enumeration;

public enum Direction {

	NORTH(1), SOUTH(2), WEST(3), EAST(4);
	private int val;
	
	private Direction(int val) {
		
		this.val = val;
	}

	public int getVal() {
		
		return this.val;
	}
	
	public static Direction getValue(int i) {
		
		for(Direction d : Direction.values()) {
			
			if(d.val == i) {
				
				return d;
			}
		}
		
		return null;
	}
}
