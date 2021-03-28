package user11681.dcp.common.uncheck;

@SuppressWarnings("unchecked")
public class Unchecker {
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

    public static RuntimeException rethrow(Throwable throwable) {
        return rethrowInternal(throwable);
    }

    private static <T extends Throwable> RuntimeException rethrowInternal(Throwable throwable) throws T {
        throw (T) throwable;
    }
}
