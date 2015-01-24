

package random.quadform.calc;

/**
 *
 * @author Owner
 */
public class FormulaGuts
{
    public static double[] QuadraticFormula(double a, double b, double c)
    {
        //These two fields will store the roots gotten from the equation (+ & -)
        double root1 = 0.0;
        double root2 = 0.0;
        
        double discriminant = Math.sqrt((b*b - 4*a*c));
        //You can have two roots total from a QF, so we need to return them
        //in an array.
        double[] rootArray = new double[2];
        
        //Here is the equation itself.
        
        if(a != 0) //If a is 0, you obviously have a linear eqauation!
        {
            root1 = ((-1 * b) + discriminant) / 2*a;

            root2 = ((-1 * b) - discriminant) / 2*a;

            rootArray[0] = root1;
            rootArray[1] = root2;
        
        }
        
        else
        {
            rootArray[0] = Double.NaN;
            rootArray[1] = Double.NaN;
        
        }
        
        return rootArray;
    }
    
}
