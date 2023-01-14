package br.com.aj_sistemas.logistica.controller;

import java.util.ArrayList;
import br.com.aj_sistemas.logistica.utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.aj_sistemas.logistica.model.VeiculoModel;

/**
 *
 * @author Alisson Jaques
 */
public class VeiculoController {

    private int contador;
    public VeiculoController(){
        contador = 0;
    }
    public boolean inserirComProcedure(VeiculoModel veiculo) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call inserirVeiculo(?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setString(1, veiculo.getModelo());
            sentenca.setString(2, veiculo.getPlaca());
            sentenca.setInt(3, veiculo.getMotorista().getIdMotorista());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean inserir(VeiculoModel veiculo) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "insert into veiculo (idveiculo,modelo,placa,idmotorista) values (?,?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculo.getIdVeiculo());
            sentenca.setString(2, veiculo.getModelo());
            sentenca.setString(3, veiculo.getPlaca());
            sentenca.setInt(4, veiculo.getMotorista().getIdMotorista());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean editarComProcedure(VeiculoModel veiculo) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call editarVeiculo(?,?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculo.getIdVeiculo());
            sentenca.setString(2, veiculo.getModelo());
            sentenca.setString(3, veiculo.getPlaca());
            sentenca.setInt(4, veiculo.getMotorista().getIdMotorista());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public String editar(VeiculoModel veiculo) {
        String retorno = "Erro ao Atualizar!";
        Conexao.conectar();
        String sql = "update veiculo set modelo = ?, placa = ?, idmotorista = ? where idveiculo = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setString(1, veiculo.getModelo());
            sentenca.setString(2, veiculo.getPlaca());
            sentenca.setInt(3, veiculo.getMotorista().getIdMotorista());
            sentenca.setInt(4, veiculo.getIdVeiculo());
            if (!sentenca.execute()) {
                retorno = "Atualizado com sucesso!";
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean excluir(VeiculoModel veiculo) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "delete from veiculo where idveiculo = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculo.getIdVeiculo());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public VeiculoModel selecionar(VeiculoModel veiculo) {
        VeiculoModel retorno = null;
        Conexao.conectar();
        String sql = "select * from veiculo where idveiculo = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, veiculo.getIdVeiculo());
            ResultSet rs = sentenca.executeQuery();
            if (rs.next()) {
                retorno = new VeiculoModel();
                retorno.setIdVeiculo(rs.getInt(1));
                retorno.setModelo(rs.getString(2));
                retorno.setPlaca(rs.getString(3));
                retorno.getMotorista().setIdMotorista(rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<VeiculoModel> selecionarTodos() {
        ArrayList<VeiculoModel> lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "select * from veiculo";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                VeiculoModel retorno = new VeiculoModel();
                retorno.setIdVeiculo(rs.getInt(1));
                retorno.setModelo(rs.getString(2));
                retorno.setPlaca(rs.getString(3));
                retorno.getMotorista().setIdMotorista(rs.getInt(4));
                lista.add(retorno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }

    public ArrayList<VeiculoModel> selecionaView() {
        ArrayList<VeiculoModel> lista = new ArrayList<>();
        String sql = "select * from vw_veiculo_motorista order by idveiculo";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                VeiculoModel fa = new VeiculoModel();
                fa.setIdVeiculo(rs.getInt(1));
                fa.setModelo(rs.getString(2));
                fa.setPlaca(rs.getString(3));
                fa.getMotorista().setNome(rs.getString(4));
                lista.add(fa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }

    public ArrayList<String> selecionaVeiculosTodos() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("");
        String sql = "select placa from veiculo";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }

    public ArrayList<Integer> selecionaIdVeiculos() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(0);
        String sql = "select idveiculo from veiculo order by idveiculo";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }
    
    public ArrayList<Integer> selecionaIdVeiculosComPacotes() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(0);
        String sql = "select * from vw_idveiculos_pacotes order by idveiculo";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt(1));
                setContador(getContador() + 1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }
    
    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
