package tickles.es;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Component;

import tickles.web.data.EventTracker;

@Component
/**
 * A worker component which pulls events from event stream and stores on 
 * tickle file system.
 * @author worker
 *
 */

public class EventStreamQueue {

	private BlockingQueue<EventTracker> queue = new ArrayBlockingQueue<>(200);
	
	public void store(EventTracker data){
		queue.offer(data);
	}
	
	public EventTracker extract() throws InterruptedException{
		return queue.take();
	}
}
