package de.eldecker.dhbw.spring.windchill;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/windchill/v1")
public class WindChillRestController {

	/** Objekt mit eigentlicher Berechnungslogik, wird über Konstruktor-Injection bereitgestellt. */
	private WindChillLogik _windChillLogik;
	
	
	/**
	 * Konstruktor für Dependency-Injection
	 */
	@Autowired
	public WindChillRestController( WindChillLogik windChillLogik ) {
		
		_windChillLogik = windChillLogik;
	}
	
	
	/**
	 * Methode für HTTP-GET-Endpunkt, um eine Berechnung der WindChill-Temperatur durchzugeführen.
	 * 
	 * @param physTemperatur URL-Parameter mit physischer Temperatur
	 * 
	 * @param windgeschwindigkeit URL-Parameter mit Windgeschwindigkeit
	 * 
	 * @return Ergebnis der Berechnung
	 * 
	 * @throws WindChillException Eingabewerte im ungültigen Bereich
	 */
	@GetMapping( "/berechnung" )
	public ResponseEntity<ErgebnisRecord> berechneWindChillTemperatur(
												@RequestParam("pt") double physTemperatur,
												@RequestParam("wg") double windgeschwindigkeit 
											) throws WindChillException {
		
		final double gefuehlteTemperatur = 
				_windChillLogik.berechneWindChillTemperatur( physTemperatur, windgeschwindigkeit ); // throws WindChillException
		
		final ErgebnisRecord ergebnis = 
									new ErgebnisRecord( physTemperatur, 
											            windgeschwindigkeit, 
											            gefuehlteTemperatur 
											          );
		
		return ResponseEntity.status( OK ).body( ergebnis );
	}
	
}
