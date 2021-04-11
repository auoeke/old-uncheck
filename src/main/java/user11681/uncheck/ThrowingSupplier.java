package user11681.uncheck;

import java.util.function.Supplier;

public interface ThrowingSupplier<T> extends Supplier<T> {
    T execute() throws Throwable;

    @Override
    default T get() {
        return Uncheck.handle(this);
    }
}
