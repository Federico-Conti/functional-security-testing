import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTestPro {
    Calc c;
    
    @BeforeEach
    void setUp() {
        c = new Calc();
    }

    @Test
    void testSub() {

        assert (c.sub(5, 3) == 2);
    }

    @Test
    void testSum() {

        assert (c.sum(5, 3) == 8);
    }

}
