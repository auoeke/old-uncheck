package user11681.dcp.common.uncheck;

import java.util.function.Consumer;

public interface ThrowingConsumer<T> extends Consumer<T> {
    void execute(T argument) throws Throwable;

    @Override
    default void accept(T argument) {
        Unchecker.handle(argument, this);
    }
}
