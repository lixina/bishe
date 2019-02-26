package quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

public class TestJob implements Job{
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 编写具体的业务�?�辑
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Job:"+dateFormat.format(date));
		//JobKey jobKey = context.getJobDetail().getKey();
		//TriggerKey triggerKey = context.getTrigger().getKey();
		//System.out.println(triggerKey.getName()+triggerKey.getGroup());
		/*Trigger currentTrigger = context.getTrigger();
		System.out.println("Start:"+dateFormat.format(currentTrigger.getStartTime())+"   End:"+dateFormat.format(currentTrigger.getEndTime()));
	*/
		}
}
