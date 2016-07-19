package br.edu.ifpb.praticas.tdd;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author diogomoreira
 *         Created on: 20/06/16.
 */
public class ValidadorRGImpl implements ValidadorRG {

	public Boolean ehValido(String rg) throws InvalidRGException {
		if(rg == null) {
			throw new InvalidRGException();
		}
		String pattern = "\\d{6}-\\d";
		Pattern p = Pattern.compile(pattern);
		Matcher match = p.matcher(rg);
		return match.matches();
	}

}
