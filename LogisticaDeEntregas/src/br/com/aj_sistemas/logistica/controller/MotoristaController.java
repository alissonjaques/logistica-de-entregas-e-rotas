package br.com.aj_sistemas.logistica.controller;

import java.util.ArrayList;
import br.com.aj_sistemas.logistica.utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.aj_sistemas.logistica.model.MotoristaModel;

/**
 *
 * @author Alisson Jaques
 */
public class MotoristaController {

    private int contador;

    public MotoristaController() {
        contador = 0;
    }

    public boolean inserirComProcedure(MotoristaModel motorista) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call inserirMotorista(?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setString(1, motorista.getNome());
            sentenca.setString(2, motorista.getCnh());
            sentenca.setInt(3, motorista.getIdade());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean inserir(MotoristaModel motorista) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "insert into motorista (idmotorista,nome,cnh,idade) values (?,?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, motorista.getIdMotorista());
            sentenca.setString(2, motorista.getNome());
            sentenca.setString(3, motorista.getCnh());
            sentenca.setInt(4, motorista.getIdade());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean editarComProcedure(MotoristaModel motorista) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call editarMotorista(?,?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, motorista.getIdMotorista());
            sentenca.setString(2, motorista.getNome());
            sentenca.setString(3, motorista.getCnh());
            sentenca.setInt(4, motorista.getIdade());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public String editar(MotoristaModel motorista) {
        String retorno = "Erro ao Atualizar!";
        Conexao.conectar();
        String sql = "update motorista set nome = ?, cnh = ?, idade = ? where idmotorista = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setString(1, motorista.getNome());
            sentenca.setString(2, motorista.getCnh());
            sentenca.setInt(3, motorista.getIdade());
            sentenca.setInt(4, motorista.getIdMotorista());
            if (!sentenca.execute()) {
                retorno = "Atualizado com sucesso!";
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean excluir(MotoristaModel motorista) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "delete from motorista where idmotorista = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, motorista.getIdMotorista());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public MotoristaModel selecionar(MotoristaModel motorista) {
        MotoristaModel retorno = null;
        Conexao.conectar();
        String sql = "select * from motorista where idmotorista = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, motorista.getIdMotorista());
            ResultSet rs = sentenca.executeQuery();
            if (rs.next()) {
                retorno = new MotoristaModel();
                retorno.setIdMotorista(rs.getInt(1));
                retorno.setNome(rs.getString(2));
                retorno.setCnh(rs.getString(3));
                retorno.setIdade(rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<MotoristaModel> selecionarTodos() {
        ArrayList<MotoristaModel> lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "select * from motorista";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                MotoristaModel retorno = new MotoristaModel();
                retorno.setIdMotorista(rs.getInt(1));
                retorno.setNome(rs.getString(2));
                retorno.setCnh(rs.getString(3));
                retorno.setIdade(rs.getInt(4));
                lista.add(retorno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }

    public ArrayList<String> selecionaMotoristas() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("");
        String sql = "select nome from motorista";
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

    public ArrayList<Integer> selecionaIdMotoristas() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(0);
        String sql = "select idmotorista from motorista order by idmotorista";
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

    public ArrayList<Integer> selecionaIdMotoristasComVeiculos() {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(0);
        String sql = "select * from vw_idmotoristas_veiculos order by idmotorista";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt(1));
                contador++;
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
