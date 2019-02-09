/*
	This program fixes the probelm by not allowing 
	both threads to acess a method at the same time
	in particular 
*/


class Counter
{
	int count;
	public synchronized void increment()
	{	
		count++; //count = count +1 
		//Two operations both acessing and adding
		
	}
}
	
public class SyncDemo2
{
	
	public static void main(String[] args){
		
		Counter c = new Counter();
		//c.increment();
		Thread t1 = new Thread(new Runnable()
		{
		
			public void run()
			{
				for(int i = 1; i <= 1000; i++)
				{
					c.increment();
				}
			}
		
		 // if you do not join the thread then the main loop will be waiting for the incrementation
		
		});
		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
				for(int i = 1; i <= 1000; i++)
				{
					c.increment();
				}
			}
		
		 // if you do not join the thread then the main loop will be waiting for the incrementation
		});
		t1.start();
		t2.start();
		//Without the join method main goes ahead without the c.increment 
		try { t1.join(); }
		catch(InterruptedException ie){
		System.out.println("oops");
		System.exit(1);
		}
		
		
		
		System.out.println("Count " + c.count);
		
		//Thread t1 = new Thread
		
	}
}