package javagame.constants;

public enum ItemTypes {
	HEATLTH_BUFF(0);
	
	int id;
	
    ItemTypes(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
}
