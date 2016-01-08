public class World{
	
	private int time;
	private Farm[] farms;
	
	public World(int qfarms){
		this.time = 0;
		this.farms = new Farm[qfarms];
		for(int i = 0; i < qfarms;i++){
			farms[i] = new farm();
		}
	}
	
	public void timeTick(){
		time++;
	}
	
	public int whatTimeIsIt(){
		return time;
	}
	
	public Farm getFarm(int which){
		if(which < 0 || which >= farms.length){
			return null;
		}
		return farms[which];
	}
	
	public Farm[] getFarms() {
		return farms;
	}