package personnages;

public enum TypeHumain {
	HUMAIN("un habitant"),
	COMMERCANT("un marchand"),
	GRANDMERE("une grand-mère"),
	RONIN("un ronin"),
	SAMOURAI("un samouraï"),
	TRAITRE("un traître"),
	YAKUZA("un yakuza");
	
	private String type;

	private TypeHumain(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
}