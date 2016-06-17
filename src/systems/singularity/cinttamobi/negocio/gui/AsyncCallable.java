package systems.singularity.cinttamobi.negocio.gui;

import javafx.application.Platform;
import systems.singularity.cinttamobi.Programa;

import java.util.concurrent.Callable;

/**
 * Created by pedro on 5/10/16.
 * © 2016 Singularity Systems
 */
public class AsyncCallable extends Thread {
    private static Runnable emptyRunnable = () -> {
    };

    public AsyncCallable(Callable callable, boolean waitOnCatch, Runnable onCatch, Runnable onFinally) {
        super(() -> {
            try {
                callable.call();
            } catch (Exception e) {
                Platform.runLater(() -> StageTools.exception(e, waitOnCatch));
                onCatch.run();
            } finally {
                onFinally.run();
            }
        });
    }

    public AsyncCallable(Callable callable, boolean waitOnCatch, Runnable onCatch) {
        this(callable, waitOnCatch, onCatch, AsyncCallable.emptyRunnable);
    }

    public AsyncCallable(Callable callable, boolean waitOnCatch) {
        this(callable, waitOnCatch, AsyncCallable.emptyRunnable, AsyncCallable.emptyRunnable);
    }

    public AsyncCallable(Callable callable) {
        this(callable, Programa.isWaitOnExcept(), AsyncCallable.emptyRunnable, AsyncCallable.emptyRunnable);
    }
}
