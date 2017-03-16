package br.edu.ifpb.praticas.teste;

import java.util.Calendar;
import java.util.List;

/**
 * @author diogomoreira
 */
public class GeradorNotaFiscal {

    private NFDao dao;

    public GeradorNotaFiscal() {
        dao = new NFDao();
    }

    public GeradorNotaFiscal(NFDao dao) {
        this.dao = dao;
    }

    public NotaFiscal gera(Pedido pedido) throws ObjetoNuloException, NotaFiscalException {
        NotaFiscal nf = new NotaFiscal(pedido.getCliente(), pedido.getValorTotal() * 0.94, Calendar.getInstance());

        List<NotaFiscal> notas = dao.listar();
        for (NotaFiscal nfBd : notas) {
            if(nf.getCliente().equals(nfBd.getCliente()))
                throw new NotaFiscalException();
        }

        dao.persiste(nf);
        return nf;
    }

}
