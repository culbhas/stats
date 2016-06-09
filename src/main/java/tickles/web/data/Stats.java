package tickles.web.data;

import java.sql.Date;

/**
 * Defines a resource to submit the test stats 
 * The <code>Stats{@link #getKey()}</code> method is a name spaced entity 
 * Starting from left to right the containers becomes too specific 
 * example of key
 * 
 * machineX.testsuiteY.serviceA.methodZ
 * 
 * @author worker
 *
 */
public class Stats implements EventTracker{

	private String key;
	private long timeTaken;
	private Date time;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
