package model;

/**
 *
 * @author Alisson Jaques
 */
public class VeiculoRotaModel {

    private int idVeiculoRota;
    private RotaModel rota;
    private VeiculoModel veiculo;

    public VeiculoRotaModel(int idVeiculoRota, RotaModel rota, VeiculoModel veiculo) {
        this.idVeiculoRota = idVeiculoRota;
        this.rota = rota;
        this.veiculo = veiculo;
    }

    public VeiculoRotaModel() {
        rota = new RotaModel();
        veiculo = new VeiculoModel();
    }

    /**
     * @return the idVeiculoRota
     */
    public int getIdVeiculoRota() {
        return idVeiculoRota;
    }

    /**
     * @param idVeiculoRota the idVeiculoRota to set
     */
    public void setIdVeiculoRota(int idVeiculoRota) {
        this.idVeiculoRota = idVeiculoRota;
    }

    /**
     * @return the rota
     */
    public RotaModel getRota() {
        return rota;
    }

    /**
     * @param rota the rota to set
     */
    public void setRota(RotaModel rota) {
        this.rota = rota;
    }

    /**
     * @return the veiculo
     */
    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }
}
