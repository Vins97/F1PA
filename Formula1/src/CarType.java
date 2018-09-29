
public enum CarType {
	MERCEDES("SILVER"),
	FERRARI("RED"),
	REDBULL("BLUE"),
	TOROROSSO("BLUERED"),
	HAAS("WHITERED"),
	FORCEINDIA("PINK"),
	WILLIAMS("WHITE"),
	RENAULT("YELLOW"),
	SAUBER("REDBLOOD"),
	MCLAREN("ORANGE");
	String color;
	CarType(String color){
		this.color=color;
	}
	public int getIndex() {
		return this.ordinal();
	}
	public String getColor() {
		return this.color;
	}
	
	
	
}
