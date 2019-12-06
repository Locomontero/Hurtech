package bean;

/**
 *
 * @author Patrick
 */
public class Produto {
    private int codigoP;
    private String modelo;
    private String cor;
    private int prazo;
    private Cliente cliente;

    public Produto() {
        
    }
    

    public Produto(int codigoP, String modelo, String cor,int prazo, Cliente cliente) {
        this.codigoP = codigoP;
        this.modelo = modelo;
        this.cor = cor;
        this.prazo = prazo;
        this.cliente = cliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(int codigoP) {
        this.codigoP = codigoP;
    }
    

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
     
}
