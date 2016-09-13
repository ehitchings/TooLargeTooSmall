package Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.Math;
import static org.junit.Assert.*;

/**
 * Created by evanhitchings on 9/12/16.
 */
public class BasicMathTest {

    BasicMath basicMath;
    @Before public void initialize(){
        basicMath = new BasicMath();

    }

    @Test
    public void addTest(){
        Assert.assertEquals(50.0, basicMath.add(25.0, 25.0), 0 );
    }

    @Test
    public void subtractTest(){
        Assert.assertEquals(25.0, basicMath.subtract(50.0, 25.0), 0);
    }

    @Test
    public void multiplyTest(){
        Assert.assertEquals(25.0, basicMath.multiply(5.0, 5.0), 0);
        Assert.assertEquals(-25.0, basicMath.multiply(5.0, -5.0), 0);
    }

    @Test
    public void divideTest(){
        Assert.assertEquals(5.0, basicMath.divide(25.0, 5.0), 0);
        Assert.assertEquals(4.6, basicMath.divide(23.0, 5.0), 0);
    }

    @Test
    public void squareTest(){
        Assert.assertEquals(25.0, basicMath.square(5.0), 0);

    }

    @Test
    public void squareRoot(){
        Assert.assertEquals(5.0, basicMath.squareRoot(25.0), 0);

    }

    @Test
    public void exponationTest(){
        Assert.assertEquals(25.0, basicMath.exponation(5.0, 2.0), 0);
        Assert.assertEquals(.04, basicMath.exponation(5.0, -2.0), 0);
    }

    @Test
    public void inverseTest(){
        Assert.assertEquals(.04, basicMath.inverse(25.0), 0);
    }

    @Test
    public void switchNegAndPosTest(){
        Assert.assertEquals(-25.0, basicMath.switchNegAndPos(25.0), 0);
        Assert.assertEquals(25.0, basicMath.switchNegAndPos(-25.0), 0);

    }


}
