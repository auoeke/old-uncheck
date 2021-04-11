package user11681.uncheck;

public interface ThrowingRunnable extends Runnable {
    void execute() throws Throwable;

    @Override
    default void run() {
        Uncheck.handle(this);
    }
}
