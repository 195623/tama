	// structure/calc-mvc/CalcMVC.java -- Calculator in MVC pattern.
	// Fred Swartz -- December 2004
import javax.swing.*;

public class TamaMVC
{
    //... Create model, view, and controller.  They are
    //    created once here and passed to the parts that
    //    need them so there is only one copy of each.
    public static void main(String[] args) {
        
        TamaM      model      = new TamaM();
        TamaV      view       = new TamaV(model);
        TamaC      controller = new TamaC(model, view);
        
        view.setVisible(true);
    }
}


