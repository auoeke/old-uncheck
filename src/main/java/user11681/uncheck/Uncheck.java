package user11681.uncheck;

@SuppressWarnings("unchecked")
public class Uncheck {
    public static void handle(ThrowingRunnable runnable) {
        try {
            runnable.execute();
        } catch (Throwable throwable) {
            throw rethrow(throwable);
        }
    }

    public static <T> T handle(ThrowingSupplier<T> supplier) {
        try {
            return supplier.execute();
        } catch (Throwable throwable) {
            throw rethrow(throwable);
        }
    }

    public static <T> void handle(T argument, ThrowingConsumer<T> consumer) {
        try {
            consumer.execute(argument);
        } catch (Throwable throwable) {
            throw rethrow(throwable);
        }
    }

    public static <T, R> R handle(T object, ThrowingFunction<T, R> function) {
        try {
            return function.execute(object);
        } catch (Throwable throwable) {
            throw rethrow(throwable);
        }
    }

    public static void handle(ThrowingRunnable runnable, ThrowingRunnable handler) {
        try {
            runnable.execute();
        } catch (Throwable throwable) {
            handler.run();
        }
    }

    public static <T> T handle(ThrowingSupplier<T> supplier, ThrowingSupplier<T> handler) {
        try {
            return supplier.execute();
        } catch (Throwable throwable) {
            return handler.get();
        }
    }

    public static <T> void handle(T argument, ThrowingConsumer<T> consumer, ThrowingConsumer<T> handler) {
        try {
            consumer.execute(argument);
        } catch (Throwable throwable) {
            handler.accept(argument);
        }
    }

    public static <T> void handle(T argument, ThrowingConsumer<T> consumer, ThrowingRunnable handler) {
        try {
            consumer.execute(argument);
        } catch (Throwable throwable) {
            handler.run();
        }
    }

    public static <T, R> R handle(T object, ThrowingFunction<T, R> function, ThrowingFunction<T, R> handler) {
        try {
            return function.execute(object);
        } catch (Throwable throwable) {
            return handler.apply(object);
        }
    }

    public static <T, R> R handle(T object, ThrowingFunction<T, R> function, ThrowingSupplier<R> handler) {
        try {
            return function.execute(object);
        } catch (Throwable throwable) {
            return handler.get();
        }
    }

    public static RuntimeException rethrow(Throwable throwable) {
        return rethrowInternal(throwable);
    }

    private static <T extends Throwable> RuntimeException rethrowInternal(Throwable throwable) throws T {
        throw (T) throwable;
    }
}
