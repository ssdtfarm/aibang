package com.cifex.web.task;

import com.cifex.business.api.system.user.HjsUserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import javax.annotation.Resource;


/**
 * Created by jiwenku on 2015/8/13.
 */
public class TestTimer extends QuartzJobBean{

    @Resource(name="userService")
//    @Reference(interfaceClass=UserService.class,interfaceName="com.cifex.business.api.system.user.UserService")
    private HjsUserService userService;
//    @Autowired
//    private BorrowTenderService borrowTenderService;
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException
    {

        System.out.println("===timer  test===");
        System.out.println("===timer  test===");
    }
}