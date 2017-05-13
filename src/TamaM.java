// structure/calc-mvc/CalcModel.java
// Fred Swartz - December 2004
// Model
//     This model is completely independent of the user interface.
//     It could as easily be used by a command line or web interface.

import java.math.BigInteger;

public class TamaM
{
    Creature pet ;    
    
    TamaM()
    {
        pet = new Creature("Bon-Bon") ;        
    }
    
    public Creature returnPet()
    {
    	return this.pet ;
    }   
}