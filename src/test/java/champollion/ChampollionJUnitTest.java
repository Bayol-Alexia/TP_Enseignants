package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	
        @Test
	public void testHeuresPrevues(){
		//On met 8h de CM, 10h de TD et 12h de TP pour UML
		untel.ajouteEnseignement(uml, 8, 10, 12);

		//On met 5h de CM, 10h de TD, 15h de TP pour JAVA
		untel.ajouteEnseignement(java, 5, 10, 15);
                
                //Le total est de 60h
		assertEquals(60, untel.heuresPrevues(),"L'enseignant doit avoir 60 h de prévues");
	}
        
        @Test
	public void testSousService(){
		//On met 8h de CM, 10h de TD, 12h de TP pour UML (le tout infénieur à 192h)
		untel.ajouteEnseignement(uml, 8, 10, 12);
		assertTrue(untel.enSousService(),"L'enseignant doit être en sous-service");

		//On met 50h de CM, 40h de TD et 105h de TP pour UML (le tout supérieur à 192h)
		untel.ajouteEnseignement(uml, 50, 40, 105);
		assertFalse(untel.enSousService(),"L'enseignant doit être en sous-service");
	}
        
        @Test
	public void testAjouterInterventions(){
		untel.ajouteEnseignement(uml, 10, 10, 10);
		try{
			untel.ajouteIntervention(new Intervention(new Date(), 1, 14, TypeIntervention.TD, java, new Salle("B019", 30)));
			fail("Cet appel doit lever une exception");
		} catch (IllegalArgumentException e){
		}
	}
        
        @Test
	public void testAPlanifier(){
		untel.ajouteEnseignement(uml, 20, 10, 30);

		untel.ajouteIntervention(new Intervention(new Date(), 2, 15, TypeIntervention.CM, uml, new Salle("B012", 30)));
                untel.ajouteIntervention(new Intervention(new Date(), 5, 14, TypeIntervention.TD, uml, new Salle("B019", 30)));
		untel.ajouteIntervention(new Intervention(new Date(), 10, 15, TypeIntervention.TP, uml, new Salle("B011", 30)));
		
                assertEquals(18, untel.resteAPlanifier(uml, TypeIntervention.CM),"Il doit rester 18 h de CM à planifier");
		assertEquals(5, untel.resteAPlanifier(uml, TypeIntervention.TD),"Il doit rester 5 h de TD à planifier");
		assertEquals(20, untel.resteAPlanifier(uml, TypeIntervention.TP),"Il doit rester 20 h de CM à planifier");
	}
        
        
        
}
