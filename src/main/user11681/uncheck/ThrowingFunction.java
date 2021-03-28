package user11681.dcp.common.uncheck;

import java.util.function.Function;

public interface ThrowingFunction<T, R> extends Function<T, R> {
    R execute(T object) throws Throwable;

    @Override
    default R apply(T object) {
        return Unchecker.handle(object, this);
    }
}
