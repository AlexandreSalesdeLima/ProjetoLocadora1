package entidades;

public class Km extends Item {
    private String marcaModelo;
    private Double qkm;

    public Km(Categoria categoria) {
        super(categoria);
    }
    
    public String getmarcaModelo() {
        return marcaModelo;
    }
  
    public void setmarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }
    public Double getQkm() {
		return qkm;
	}

	public void setQkm(Double qkm) {
		this.qkm = qkm;
	}
    
    @Override
    public String toString() {
        return "Km \n" + 
                "   ID: " + getId() + "\n" +
                "   marca: " + marcaModelo + "\n" +
                "   QKm: " + qkm + "\n" +
                "   Placa: " + getPlaca() + "\n" +
                "   Descricao: " + getDescricao() + "\n" +
                "   Preco: " + getPreco() + "\n" +
                "   N_Dias: " + getNumeroDias() + "\n" +
                "   Categoria: " + getCategoria() + "\n" +
                '}';
        
          }

       }
