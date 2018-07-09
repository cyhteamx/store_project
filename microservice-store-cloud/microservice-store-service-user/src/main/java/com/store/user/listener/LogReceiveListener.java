package com.store.user.listener;

/**
 * @author lengleng
 * @date 2017/11/17
 */
//@Component
//@RabbitListener(queues = MqQueueConstant.LOG_QUEUE)
public class LogReceiveListener {
    private static final String KEY_USER = "user";

//    @Autowired
//    private SysLogService sysLogService;
//
//    @RabbitHandler
//    public void receive(LogVO logVo) {
//        SysLog sysLog = logVo.getSysLog();
//        MDC.put(KEY_USER, logVo.getUsername());
//        sysLog.setCreateBy(logVo.getUsername());
//        sysLogService.insert(sysLog);
//        MDC.remove(KEY_USER);
//    }
}
