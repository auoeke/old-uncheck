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

    public static <T> T handle(ThrowingSupplier<T> supplier, Object fallback) {
        try {
            return supplier.execute();
        } catch (Throwable throwable) {
            return (T) fallback;
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

    public static <T, R> R handle(T object, ThrowingFunction<T, R> function, Object fallback) {
        try {
            return function.execute(object);
        } catch (Throwable throwable) {
            return (R) fallback;
        }
    }

    public static <T extends AutoCloseable> void handle(T closeable, ThrowingConsumer<T> consumer) {
        try (closeable) {
            consumer.execute(closeable);
        } catch (Throwable throwable) {
            throw rethrow(throwable);
        }
    }

    public static <T extends AutoCloseable> void handle(T closeable, ThrowingConsumer<T> consumer, ThrowingRunnable handler) {
        try (closeable) {
            consumer.execute(closeable);
        } catch (Throwable throwable) {
            handler.run();
        }
    }

    public static <T extends AutoCloseable> void handle(T closeable, ThrowingConsumer<T> consumer, ThrowingConsumer<T> handler) {
        try (closeable) {
            consumer.execute(closeable);
        } catch (Throwable throwable) {
            handler.accept(closeable);
        }
    }

    public static <T extends AutoCloseable, R> R handle(T closeable, ThrowingFunction<T, R> consumer, ThrowingFunction<T, R> handler) {
        try (closeable) {
            return consumer.execute(closeable);
        } catch (Throwable throwable) {
            return handler.apply(closeable);
        }
    }

    public static <T extends AutoCloseable, R> R handle(T closeable, ThrowingFunction<T, R> consumer, ThrowingSupplier<R> handler) {
        try (closeable) {
            return consumer.execute(closeable);
        } catch (Throwable throwable) {
            return handler.get();
        }
    }

    public static <T extends AutoCloseable, R> R handle(T closeable, ThrowingFunction<T, R> consumer, Object fallback) {
        try (closeable) {
            return consumer.execute(closeable);
        } catch (Throwable throwable) {
            return (R) fallback;
        }
    }

    public static RuntimeException rethrow(Throwable throwable) {
        return rethrowInternal(throwable);
    }

    private static <T extends Throwable> RuntimeException rethrowInternal(Throwable throwable) throws T {
        throw (T) throwable;
    }
}
