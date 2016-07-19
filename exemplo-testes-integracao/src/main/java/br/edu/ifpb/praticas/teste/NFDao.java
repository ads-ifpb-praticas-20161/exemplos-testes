package br.edu.ifpb.praticas.teste;

import java.sql.*;
import java.util.List;

/**
 * @author diogomoreira.
 */
public class NFDao {

    public Connection connection;

    public NFDao() {
        try {
            Class driverClass = Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbunit", "postgres", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void persiste(NotaFiscal nf) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("INSERT INTO notafiscal VALUES (?,?,?)");
        statement.setString(1, nf.getCliente());
        statement.setDouble(2, nf.getValor());
        statement.setDate(3, new java.sql.Date(nf.getData().getTime()));
        statement.execute();
    }

    public void excluir(NotaFiscal nf) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("DELETE FROM notafiscal WHERE cliente = ?");
        statement.setString(0, nf.getCliente());
        statement.execute();
    }

    public List<NotaFiscal> listar() {
        return null;
    }

    public NotaFiscal consultar(String cliente) throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("SELECT * FROM notafiscal WHERE cliente = ?");
        statement.setString(1, cliente);
        ResultSet resultSet = statement.executeQuery();
        NotaFiscal notaFiscal = new NotaFiscal();
        while(resultSet.next()) {
            notaFiscal.setCliente(resultSet.getString(1));
            notaFiscal.setValor(resultSet.getDouble(2));
            notaFiscal.setData(resultSet.getDate(3));
        }
        return notaFiscal;
    }

}
