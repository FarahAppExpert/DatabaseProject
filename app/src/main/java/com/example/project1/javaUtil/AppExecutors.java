package com.example.project1.javaUtil;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Global executor pools for the whole application.
 * <p>
 * Grouping tasks like this avoids the effects of task starvation (e.g. disk reads don't wait behind
 * webservice requests).
 */

public class AppExecutors
{
    private static final Object lock_data = new Object();
    private static AppExecutors sInstance;
    private final Executor getIO;
    private final Executor mainThread;
    private final Executor networkIO;

    private AppExecutors(Executor getIO, Executor networkIO, Executor mainThread) {
        this.getIO = getIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    public static AppExecutors getInstance() {
        if (sInstance == null) {
            synchronized (lock_data) {
                sInstance = new AppExecutors(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(3),
                        new MainThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor diskIO()
    {
        return getIO;
    }

    public Executor mainThread()
    {
        return mainThread;
    }

    public Executor networkIO() {
        return networkIO;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command)
        {
            mainThreadHandler.post(command);
        }
    }
}
