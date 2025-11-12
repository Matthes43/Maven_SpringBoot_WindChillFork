package de.eldecker.dhbw.spring.windchill;

import org.springframework.stereotype.Component;


/**
 * Diese Bean-Klasse enthält eine Methode zur Berechnung der gefühlten Temperatur
 * bei kalten Temperaturen (unter 10 Grad Celsius).
 */
@Component
public class WindChillLogik {

	/** 
	 * Berechnung der gefühlten Temperatur nach
	 * <a href="https://de.wikipedia.org/wiki/Windchill#Aktuelle_Berechnung_und_Tabelle">Wikipedia</a>.
	 * 
	 * @param physTemperatur Tatsächliche (physische) Temperatur in Grad Celsius, muss 
	 *                       kleiner-gleich 10 Grad sein
	 * 
	 * @param windgeschwindigkeit Windgeschwindigkeit in km/h; muss innerhalb 5.0 km/h
	 *                            und 60 km/h sein
	 * 
	 * @return Gefühlte Temperatur
	 */
	public double berechneWindChillTemperatur( double physTemperatur, 
			                                   double windgeschwindigkeit ) {
		
	    final double v  = Math.pow( windgeschwindigkeit, 0.16 );
	    final double va = physTemperatur;

	    final double gefuehlteTemperatur        = 13.12 + 0.6215 * va + (0.3965 * va - 11.37) * v;
	    final double gefuehlteTempraturGerundet = Math.round( gefuehlteTemperatur * 10 ) / 10;

	    return gefuehlteTempraturGerundet;
	}
	
}
