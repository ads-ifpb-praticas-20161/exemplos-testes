package br.edu.ifpb.praticas.tdd;

/**
 * @author diogomoreira
 *         Created on: 20/06/16.
 */
public interface ValidadorRG {

	Boolean ehValido(String rg) throws InvalidRGException;

}