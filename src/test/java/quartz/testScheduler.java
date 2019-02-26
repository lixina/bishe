package quartz;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class testScheduler {

	public static void main(String[] args) throws SchedulerException {
		
		// 打印时间
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println("scheduler"+dateFormat.format(date));
		
		// 创建JobDetail实例 将该实例与testJob绑定
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
				.withIdentity("job", "group").build();
		//.usingJobData("key1","message1")传参 jobDetail.getKey().getName()获取参数
		
		// 获取距离当前时间三秒后的时间
		Date startDate = new Date();
		startDate.setTime(date.getTime()+3000);
		// 获取距离当前时间六秒后的时间
		Date endDate = new Date();
		endDate.setTime(endDate.getTime()+6000);
		// 创建�?个Trigger实例，定义该job立即执行
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group").startAt(startDate).endAt(endDate)
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
		// 创建Schedule实例
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		
		scheduler.scheduleJob(jobDetail, trigger);
		
	}
}
