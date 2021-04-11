import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import user11681.uncheck.Uncheck;

@Testable
class UncheckTest {
    static final int finalInt = Uncheck.handle(() -> Integer.parseInt("int"), () -> 2);

    @Test
    void test() {
        assert finalInt == 2;
    }
}
