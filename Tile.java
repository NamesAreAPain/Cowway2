public enum Tile{
	DIRT, GRASS, POSIONCOW, COW, FLYINGCOW, NOCTURNALCOW;
	
	public Tile convert(FarmTile old){
		if(old == null){
			return GRASS;
		}
		
		if(old.getType().equals("Cow")){
			
		}
		if(old.getType().equals("Grass")){
			
		}
	}
}