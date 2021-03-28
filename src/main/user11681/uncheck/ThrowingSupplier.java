package user11681.dcp.common.uncheck;

import java.util.function.Supplier;

public interface ThrowingSupplier<T> extends Supplier<T> {
    T execute() throws Throwable;

    @Override
    default T get() {
        return Unchecker.handle(this);
    }
}
