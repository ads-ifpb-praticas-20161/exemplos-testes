package br.edu.ifpb.praticas.teste;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author diogomoreira.
 */
public class NFDaoTest {

    private NFDao dao;

    @Before
    public void setUp() {
        dao = new NFDao();
    }

    @Test(expected = ObjetoNuloException.class)
    public void naoAceitaNulo() throws ObjetoNuloException, NotaFiscalException {
        NotaFiscal nf = null;
        dao.persiste(nf);
    }

    @Test(expected = NotaSemDataException.class)
    public void naoAceitaNFSemData() throws ObjetoNuloException, NotaFiscalException {
        NotaFiscal nf = new NotaFiscal("Diogo", 26d, null);
        dao.persiste(nf);
    }

}