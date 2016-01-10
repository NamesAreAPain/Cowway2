public enum Dir {
	NORTH (-1,0), SOUTH (1,0), EAST (0,1), WEST (-1,0);
	
	private final int deltaY;
	private final int deltaX;
	
	Dir(int dY, int dX){
		this.deltaY = dY;
		this.deltaX = dX;
	}
	
	int[] go(int[] loc0){
		int[] loc1 = new int[2];
		loc1[0] = loc0[0] + deltaY;
		loc1[1] = loc0[1] + deltaX;
		return loc1;
	}
}