package com.edu.util;

//定时器
public abstract class Didadida implements Runnable {
	private volatile Object lock;
	private volatile boolean goon;
	private long delayTime;
	
	public static final long DEFAULT_DELAY_TIME = 1000;
	
	public abstract void beforeDida();
	public abstract void doIt();
	public abstract void afterDida();
	
	public Didadida() {
		this.lock = new Object();
		this.delayTime = DEFAULT_DELAY_TIME;
	}
	
	public Didadida setDelayTime(long delayTime) {
		this.delayTime = delayTime;
		return this;
	}
	
	public void start() {
		if (goon == true) {
			return;
		}
		goon = true;
		new DidaWorker();
		new Thread(this, "滴答滴答").start();
	}
	
	public void stop() {
		if (goon == false) {
			return;
		}
		goon = false;
	}

	@Override
	public void run() {
		beforeDida();
		while (goon) {
			synchronized (lock) {
				try {
					lock.wait(delayTime);
					lock.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		afterDida();
	}
	
	class DidaWorker implements Runnable {
		
		public DidaWorker() {
			new Thread(this).start();
		}
		
		@Override
		public void run() {
			while (goon) {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				doIt();
			}
		}
	}
	
}