
package Model;

public class Gastos {
   String descricao;
   double valorGasto;

    public Gastos() {
    }

    public Gastos(String descricao, double valorGasto) {
        this.descricao = descricao;
        this.valorGasto = valorGasto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

    public void get(int l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
   
}
