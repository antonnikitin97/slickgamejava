package javagame.constants;

public enum ItemTypes {
	HEALTH_BUFF(0, "Health Buff");
	
	int id;
	String nameRepresentation;
	
    ItemTypes(int id, String nameRepresentation){
		this.id = id;
		this.nameRepresentation = nameRepresentation;
	}
	
	public int getId(){
		return this.id;
	}

	public String toString(){
		return this.nameRepresentation;
	}


}
