package br.edu.ifpb.praticas.teste;

import java.util.List;

/**
 * @author diogomoreira.
 */
public class NFDao {

    public void persiste(NotaFiscal nf) throws NotaFiscalException, ObjetoNuloException {
        if(nf == null) {
            throw new ObjetoNuloException();
        }
        if(nf.getData() == null) {
            throw new NotaSemDataException();
        }
        // Lógica de persistência de dados
    }

    public boolean excluir(NotaFiscal nf) {
        return true;
    }

    public List<NotaFiscal> listar() {
        return null;
    }

    public NotaFiscal consultar(String cliente) {
        return null;
    }

}
