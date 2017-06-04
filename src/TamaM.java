// structure/calc-mvc/CalcModel.java
// Fred Swartz - December 2004
// Model
//     This model is completely independent of the user interface.
//     It could as easily be used by a command line or web interface.

import java.math.BigInteger;
import  java.util.Collection;
import java.util.List ;
import java.util.ArrayList ;

public class TamaM
{
    Creature pet ;
    List<Creature> petList = new ArrayList<Creature>();
    
    
    TamaM()
    {
        pet = new Creature("Bon-Bon") ;
        
        petList.add(new Dog("Fido")) ;
        petList.add(new Parrot("Carrot")) ;
        petList.add(new Cat("Precious")) ;
    }
    
    public Creature returnPet()
    {
    	return this.pet ;
    }
    
    public List<Creature> returnPets()
    {
    	return this.petList ;
    }
}