import org.junit.jupiter.api.Test;

public class CalcTest {
    Calc c;

    @Test
    void testSub() {
        c = new Calc();
        assert (c.sub(5, 3) == 2);
    }

    @Test
    void testSum() {
        c = new Calc();
        assert (c.sum(5, 3) == 8);
    }
}
