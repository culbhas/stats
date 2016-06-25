package tickles.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tickles.web.data.EventTracker;

/**
 * 
 * @author worker
 * A high volume event stream handler backed by multiple worker threads to 
 * store the event data
 */
@Component
public class EventStream {

	@Autowired
	private EventStreamQueue worker;
	
	public String submit(EventTracker data){
		worker.store(data);
		return data.id();
	}
}
