package br.edu.ifpb.praticas.tdd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author diogomoreira
 *         Created on: 20/06/16.
 */
public class ValidadorRGTest {

	private ValidadorRG validador;

	@Before
	public void setUpTests() {
		validador = new ValidadorRGImpl();
	}

	@After
	public void afterTests() {
		System.out.println("Os testes foram concluídos");
	}

	@Test
	public void validarTamanho() throws InvalidRGException {
		Assert.assertEquals(false, validador.ehValido("152715276512"));
		Assert.assertEquals(false, validador.ehValido(""));
		Assert.assertEquals(false, validador.ehValido("9999999"));
		Assert.assertEquals(true, validador.ehValido("161554-8"));
	}

	@Test
	public void validarFormato() throws InvalidRGException {
		Assert.assertEquals(false, validador.ehValido("AAAAAAAA"));
		Assert.assertEquals(false, validador.ehValido("11287199"));
		Assert.assertEquals(true, validador.ehValido("161554-8"));
		Assert.assertEquals(false, validador.ehValido("#%%!$@-8"));
		Assert.assertEquals(false, validador.ehValido("$!@!$%!$$"));
	}

	@Test(expected = InvalidRGException.class)
	public void testarObjeto() throws InvalidRGException {
		validador.ehValido(null);
	}

	@Test(timeout = 100L)
	public void testarPerformance() throws InvalidRGException {
		assertEquals(true, validador.ehValido("161554-8"));
	}

}
