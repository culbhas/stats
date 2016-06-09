package tickles.es;

import org.springframework.stereotype.Component;

import tickles.web.data.EventTracker;

@Component
/**
 * A worker component which pulls events from event stream and stores on 
 * tickle file system.
 * @author worker
 *
 */
public class EventStreamWorker {

	public void store(EventTracker data){
		
	}
}
