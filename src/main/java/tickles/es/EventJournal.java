package tickles.es;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tickles.web.data.EventTracker;

@Component
public class EventJournal {
	@Value("${tickles.fs.journal:journal.dat}")
	private String journalFile;
	
	private BufferedOutputStream journal;
	@Autowired
	private EventStreamQueue queue;
	private boolean started;
	
	@PostConstruct
	public void init() throws IOException{
		//TODO create directories and then file
		Path path = Paths.get(journalFile);
		if(!Files.exists(path)){
			Files.createFile(path);
		}
		journal = new BufferedOutputStream(new FileOutputStream(path.toFile()));
	}
	public void record(){
		//TODO revisit this 
		started = true;
		while(true){
			try{
				EventTracker tracker = queue.extract();
				ObjectMapper mapper = new ObjectMapper();
				String streamJ = mapper.writeValueAsString(tracker);
				journal.write(streamJ.getBytes());
				//TODO not so good on performance but works for now 
				//revisit
				journal.flush();
			}catch(InterruptedException exception){
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean isRecording(){
		return started;
	}
	@PreDestroy
	public void shutDown(){
		try{
			journal.close();
		}catch(Exception e){
			
		}
	}
	
}
