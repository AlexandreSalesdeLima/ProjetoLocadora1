package entidades;

public class Diaria extends Item {
    private int qtdLugares;
    private String marcaModelo;

    public Diaria(Categoria categoria) {
        super(categoria);
    }

	public int getQtdLugares() {
		return qtdLugares;
	}

	public void setQtdLugares(int qtdLugares) {
		this.qtdLugares = qtdLugares;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}
    
   
}
