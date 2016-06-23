package tickles.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import tickles.es.EventJournal;

@Component
public class BackgroundInitilizer {

	@Autowired
	private EventJournal journal;
	@Autowired
	private TaskExecutor executor;
	
	@EventListener
	public void startJournal(ContextRefreshedEvent event){
		if(!journal.isRecording()){
			executor.execute(journal::record);
		}
	}
}
