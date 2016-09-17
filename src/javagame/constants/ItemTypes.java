package javagame.constants;

public enum ItemTypes {
	HEALTH_BUFF(0, "Health Buff", 'H');
	
	int id;
	String nameRepresentation;
	char useKey;
	
    ItemTypes(int id, String nameRepresentation, char useKey){
		this.useKey = useKey;
		this.id = id;
		this.nameRepresentation = nameRepresentation;
	}

	//Returns ID of the item
	public int getId(){
		return this.id;
	}

	public char getUseKey(){
		return this.useKey;
	}

	public String toString(){
		return this.nameRepresentation;
	}

}
