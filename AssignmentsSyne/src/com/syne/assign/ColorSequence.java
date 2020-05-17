package com.syne.assign;

//class for colors runnable threads1
 class ColorRunnable implements Runnable{
	 
	public int PRINT_COLORS_UPTO=21;
	static int  number=1;
	int remainder;
	static Object lock=new Object();
 
	ColorRunnable(int remainder)
	{
		this.remainder=remainder;
	}
 
	@Override
	public void run() {
		while (number < PRINT_COLORS_UPTO-1) {
			synchronized (lock) {
				while (number % 3 != remainder) { 
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() );
				number++;
				lock.notifyAll();
			}
		}
	}
}


public class ColorSequence {
	 
	public static void main(String[] args) {
		
		ColorRunnable runnable1=new ColorRunnable(1);
		ColorRunnable runnable2=new ColorRunnable(2);
		ColorRunnable runnable3=new ColorRunnable(0);
		
		Thread t1=new Thread(runnable1,"Red");
		Thread t2=new Thread(runnable2,"Green");
		Thread t3=new Thread(runnable3,"Blue");
		
		t1.start();
		t2.start();
		t3.start();	  
	}
}
 
