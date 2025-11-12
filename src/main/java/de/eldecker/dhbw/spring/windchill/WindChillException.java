package de.eldecker.dhbw.spring.windchill;


/**
 * Eigene Exception-Klasse.
 */
@SuppressWarnings("serial")
public class WindChillException extends Exception {

	public WindChillException( String fehlerText ) {
		
		super( fehlerText );
	}
	
}
