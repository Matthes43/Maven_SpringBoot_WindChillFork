package de.eldecker.dhbw.spring.windchill;


/**
 * Eine Instanz der folgenden Record-Klasse enthält die Rückgabe-Werte für
 * den Aufruf des REST-Endpunkts zur Berechnung der gefühlten Temperatur.
 */
public record ErgebnisRecord( double tatsaechlicheTemperatur, 
		                      double windgeschwindigkeit, 
		                      double gefuehlteTemperatur 
		                    ) {
}
