package quartz;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class TestScheduler_CronTrigger {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		
		// 打印时间
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println("scheduler:"+dateFormat.format(date));
		
		// 创建JobDetail实例 将该实例与testJob绑定
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
				.withIdentity("job", "group").build();
		//.usingJobData("key1","message1")传参 jobDetail.getKey().getName()获取参数
		
		// 获取距离当前时间四秒后的时间
		Date startDate = new Date();
		startDate.setTime(date.getTime()+4000);
		//0 15 10 * �? �? 2017 2017年内每天十点十五分触发一�?
		// 0/5 * 14,18 * * �?  每天�?14点整�?14:59:55以及18:59:55 每五秒触发一�?

		CronTrigger trigger = (CronTrigger)TriggerBuilder
				.newTrigger()
				.withIdentity("trigger", "group")
				.startAt(startDate)
				.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))//每秒执行�?�?
				.build();
		// 创建Schedule实例
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
		// scheduler执行两秒后挂�?
		Thread.sleep(2000L);
		scheduler.standby();
		// scheduler挂起三秒后继续执�?
		Thread.sleep(3000L);
		scheduler.start();
	}
}
