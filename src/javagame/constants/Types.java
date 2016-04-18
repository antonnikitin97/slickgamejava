package javagame.constants;

public enum Types {
	PLAYER (0),
	ITEM (1);
	
	int id;
	
    Types(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
}
