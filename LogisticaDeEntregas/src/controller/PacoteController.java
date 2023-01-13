package controller;

import java.util.ArrayList;
import utils.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.PacoteModel;
import model.VeiculoModel;

/**
 *
 * @author Alisson Jaques
 */
public class PacoteController {

    public boolean inserirComProcedure(PacoteModel pacote) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call inserirPacote(?,?,?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setString(1, pacote.getDescricao());
            sentenca.setDouble(2, pacote.getPeso());
            sentenca.setDouble(3, pacote.getVolume());
            sentenca.setString(4, pacote.getDestinatario());
            sentenca.setInt(5, pacote.getVeiculo().getIdVeiculo());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean inserir(PacoteModel pacote) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "insert into pacote (idpacote,descricao,peso,volume,destinatario,idveiculo) values (?,?,?,?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, pacote.getIdPacote());
            sentenca.setString(2, pacote.getDescricao());
            sentenca.setDouble(3, pacote.getPeso());
            sentenca.setDouble(4, pacote.getVolume());
            sentenca.setString(5, pacote.getDestinatario());
            sentenca.setInt(6, pacote.getVeiculo().getIdVeiculo());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean editarComProcedure(PacoteModel pacote) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "call editarPacote(?,?,?,?,?,?)";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, pacote.getIdPacote());
            sentenca.setString(2, pacote.getDescricao());
            sentenca.setDouble(3, pacote.getPeso());
            sentenca.setDouble(4, pacote.getVolume());
            sentenca.setString(5, pacote.getDestinatario());
            sentenca.setInt(6, pacote.getVeiculo().getIdVeiculo());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public String editar(PacoteModel pacote) {
        String retorno = "Erro ao Atualizar!";
        Conexao.conectar();
        String sql = "update pacote set descricao = ?, peso = ?, volume = ?, destinatario = ?, "
                + "idveiculo = ? where idpacote = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setString(1, pacote.getDescricao());
            sentenca.setDouble(2, pacote.getPeso());
            sentenca.setDouble(3, pacote.getVolume());
            sentenca.setString(4, pacote.getDestinatario());
            sentenca.setInt(5, pacote.getVeiculo().getIdVeiculo());
            sentenca.setInt(6, pacote.getIdPacote());
            if (!sentenca.execute()) {
                retorno = "Atualizado com sucesso!";
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar! " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public boolean excluir(PacoteModel pacote) {
        boolean retorno = false;
        Conexao.conectar();
        String sql = "delete from pacote where idpacote = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, pacote.getIdPacote());
            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public PacoteModel selecionar(PacoteModel pacote) {
        PacoteModel retorno = null;
        Conexao.conectar();
        String sql = "select * from pacote where idpacote = ?";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            sentenca.setInt(1, pacote.getIdPacote());
            ResultSet rs = sentenca.executeQuery();
            if (rs.next()) {
                retorno = new PacoteModel();
                retorno.setIdPacote(rs.getInt(1));
                retorno.setDescricao(rs.getString(2));
                retorno.setPeso(rs.getDouble(3));
                retorno.setVolume(rs.getDouble(4));
                retorno.setDestinatario(rs.getString(5));
                retorno.getVeiculo().setIdVeiculo(rs.getInt(6));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<PacoteModel> selecionarTodos() {
        ArrayList<PacoteModel> lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "select * from pacote";
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                PacoteModel retorno = new PacoteModel();
                retorno.setIdPacote(rs.getInt(1));
                retorno.setDescricao(rs.getString(2));
                retorno.setPeso(rs.getDouble(3));
                retorno.setVolume(rs.getDouble(4));
                retorno.setDestinatario(rs.getString(5));
                retorno.getVeiculo().setIdVeiculo(rs.getInt(6));
                lista.add(retorno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar: " + e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }

    public ArrayList<PacoteModel> selecionaView() {
        ArrayList<PacoteModel> lista = new ArrayList<>();
        String sql = "select * from vw_pacote_veiculo";
        Conexao.conectar();
        try {
            PreparedStatement sentenca = Conexao.con.prepareStatement(sql);
            ResultSet rs = sentenca.executeQuery();
            while (rs.next()) {
                PacoteModel fa = new PacoteModel();
                fa.setIdPacote(rs.getInt(1));
                fa.setDescricao(rs.getString(2));
                fa.setPeso(rs.getDouble(3));
                fa.setVolume(rs.getDouble(4));
                fa.setDestinatario(rs.getString(5));
                fa.getVeiculo().setPlaca(rs.getString(6));
                lista.add(fa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Conexao.desconectar();
        return lista;
    }
}
