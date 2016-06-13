package tickles.es;

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

	public String submit(EventTracker data){
		return null;
	}
}
