package maoko.common.tdPool;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池[固定]执行中心
 * 
 * @author fanpei
 * @version 创建时间：2016年9月26日 下午2:35:30
 */
public class TdFixedPoolExcCenter {
	// private static final Object syncLock;
	private ExecutorService threadSver;

	// private static TdFixedPoolExcCenter instance;

	public TdFixedPoolExcCenter(int nThreads) {
		if (nThreads == 1)
			threadSver = Executors.newSingleThreadExecutor();
		else
			threadSver = Executors.newFixedThreadPool(nThreads);
	}

	public TdFixedPoolExcCenter(int nThreads, String poolName) {
		if (nThreads == 1)
			threadSver = Executors.newSingleThreadExecutor();
		else
			threadSver = Executors.newFixedThreadPool(nThreads, new CusThreadFactory(poolName));
	}

	public void execute(Runnable commond) {
		threadSver.execute(commond);
	}

	public void submit(Runnable commond) {
		threadSver.submit(commond);
	}

	public <T> Future<T> submit(Callable<T> commond) {
		return threadSver.submit(commond);
	}

	public void executes(Collection<Runnable> tasks) {
		if (tasks != null && !tasks.isEmpty()) {
			for (Runnable r : tasks) {
				if (r != null && r instanceof Runnable) {
					threadSver.execute(r);
				} else
					continue;
			}
		}
	}

	public void executes(Iterable<Runnable> tasks) {
		Iterator<Runnable> it = tasks.iterator();
		while (it.hasNext()) {
			Runnable r = it.next();
			if (r != null && r instanceof Runnable) {
				threadSver.execute(r);
			} else
				continue;
		}
	}

	public void shutdownNow() {
		threadSver.shutdownNow();
	}
}
