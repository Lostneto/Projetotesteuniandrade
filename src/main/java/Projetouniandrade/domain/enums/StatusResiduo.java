package Projetouniandrade.domain.enums;

public enum StatusResiduo {
	
	STATUSAPROVADO(2,"Produto Fucional"),
	STATUSDESAPROVADO(1, "Produto não Funcional");
	
	private int cod;
	private String descricao;
	
	private StatusResiduo (int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static StatusResiduo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(StatusResiduo x : StatusResiduo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("id inválido: " + cod);
		
	}
	
}
	


