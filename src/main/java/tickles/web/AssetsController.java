package tickles.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tickles.es.EventStream;
import tickles.web.data.Asset;
/**
 * Asset API to create update and list assets
 * 
 * Asset can be anything - Machine, test suite, developer, tester, service
 * 							module
 * 
 * All submit operations - POST and PUT are async and client can assume, in most cases 
 *                         the operations are successful and they can check the status of operation
 *                         after some time 
 * @author worker
 *
 */
@RestController("assets")
public class AssetsController {

	@Autowired
	private EventStream es;
	
	@RequestMapping(path="/assets",
					method=RequestMethod.POST,
					consumes="application/json",
					produces="application/json")
	public ResponseEntity<String> addAsset(Asset asset){
		String submissionId = es.submit(asset);
		
		return new ResponseEntity<String>(submissionId, HttpStatus.ACCEPTED);
	}
}
