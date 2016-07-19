package br.edu.ifpb.praticas.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by diogomoreira on 17/07/16.
 */
public class GerenciadorNotaFiscalTest extends GenericDatabaseTestCase {

    private GerenciadorNotaFiscal gerenciadorNotaFiscal;

    @Before
    public void setUp() {
        this.gerenciadorNotaFiscal = new GerenciadorNotaFiscal();
    }

    @Test(expected = NotaFiscalException.class)
    public void naoDevePermitirDuasNotasParaOMesmoCliente() throws NotaFiscalException {
        Pedido pedido = new Pedido("Diogo Moreira", 26d, 7);
        gerenciadorNotaFiscal.gera(pedido);
    }

    public String getDataSetFile() {
        return "src/test/resources/notas_fiscais.xml";
    }
}
