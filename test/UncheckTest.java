import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import net.auoeke.uncheck.ThrowingRunnable;
import net.auoeke.uncheck.Uncheck;

@SuppressWarnings("ALL")
@Testable
class UncheckTest {
    final Path source = Uncheck.handle(() -> Path.of(Uncheck.class.getResource('/' + Uncheck.class.getName().replace('.', '/') + ".class").toURI()).getParent());
    final int finalInt = Uncheck.handle(() -> Integer.parseInt("int"), 2);
    int state;

    @Test
    void test() throws Throwable {
        assert finalInt == 2;

        this.test(() -> Uncheck.handle(() -> {throw null;}, () -> {this.state = 0;}));
        this.test(() -> {
            assert Uncheck.handle(() -> this.state = 0, () -> this.state = 4) == 0;
        });
        this.test(() -> Uncheck.handle(4, (Integer state) -> {this.state = state; throw null;}, (Integer state) -> {this.state = 0;}));
        this.test(() -> Uncheck.handle(4, (Integer state) -> {this.state = state; throw null;}, () -> {this.state = 0;}));
        this.test(() -> this.state = Uncheck.handle(4, (Integer state) -> {this.state = state; return 0;}, (Integer state) -> this.state = 4));
        this.test(() -> this.state = Uncheck.handle(4, (Integer state) -> {this.state = state; return 0;}, () -> this.state = 4));
        this.test(() -> this.state = Uncheck.handle(4, (Integer state) -> {this.state = state; throw null;}, 0));
        this.test(() -> Uncheck.handle(Files.list(this.source), (Stream<Path> paths) -> {this.state = 0;}, () -> {throw null;}));
    }

    @Test
    void resources() throws Throwable {
        Uncheck.handle(Files.list(this.source), (Stream<Path> stream) -> stream.forEach(System.out::println));
    }

    void test(ThrowingRunnable test) {
        test.run();
        this.checkState();
    }

    void checkState() {
        assert this.state == 0 : this.state;
        this.state = 4;
    }
}
