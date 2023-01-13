package model;

/**
 *
 * @author Alisson Jaques
 */
public class RotaModel {
    private int idRota;
    private String descricao;
    
    public RotaModel(int idRota, String descricao){
        this.idRota = idRota;
        this.descricao = descricao;
    }
    
    public RotaModel(){
        
    }    

    /**
     * @return the idRota
     */
    public int getIdRota() {
        return idRota;
    }

    /**
     * @param idRota the idRota to set
     */
    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
