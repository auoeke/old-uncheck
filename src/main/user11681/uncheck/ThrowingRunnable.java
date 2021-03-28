package user11681.dcp.common.uncheck;

public interface ThrowingRunnable extends Runnable {
    void execute() throws Throwable;

    @Override
    default void run() {
        Unchecker.handle(this);
    }
}
