package Calculator;
import static org.junit.Assert.*;
/**
 * Created by evanhitchings on 9/11/16.
 */
public class DisplayTest {

    public void displayInterfaceTest(){
        Display dis = new Display();
        dis.displayInterface();
        assertSame("Failed to store first value", 100, dis.getFirstValue());

    }
}
