package tickles.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tickles.es.EventStream;
import tickles.web.data.Stats;
/**
 * stats API to create and list assets
 * 
 * stats are basically namespace based key value pairs where as key represents an operation 
 * on an asset and value represents time taken to complete that operation
 * 
 * All submit operations - POST is async and client can assume, in most cases 
 *                         the operations are successful and they dont have to check the status of operation
 * submitted tasks are guaranteed to be part of analytics                         
 * @author worker
 *
 */
@RestController("stats")
public class StatsController {

	@Autowired
	private EventStream es;
	
	@RequestMapping(method=RequestMethod.POST,
					consumes="application/json",
					produces="application/json")
	public ResponseEntity<String> addAsset(Stats asset){
		String submissionId = es.submit(asset);
		
		return new ResponseEntity<String>(submissionId, HttpStatus.ACCEPTED);
	}
}
