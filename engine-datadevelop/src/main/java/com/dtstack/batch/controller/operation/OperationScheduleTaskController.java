package com.dtstack.batch.controller.operation;

import com.dtstack.batch.mapstruct.task.ScheduleTaskMapstructTransfer;
import com.dtstack.batch.vo.schedule.QueryTaskListVO;
import com.dtstack.batch.service.schedule.TaskService;
import com.dtstack.batch.vo.schedule.ScheduleTaskVO;
import com.dtstack.engine.pager.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: dazhi
 * @Date: 2021/12/6 1:58 PM
 * @Email:dazhi@dtstack.com
 * @Description:
 */
@RestController
@RequestMapping("/node/scheduleTaskShade")
public class OperationScheduleTaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(value = "/queryTasks")
    public PageResult<List<ScheduleTaskVO>> queryTasks(@RequestBody @Validated QueryTaskListVO vo) {
        return taskService.queryTasks(ScheduleTaskMapstructTransfer.INSTANCE.queryTasksVoToDto(vo));
    }

    @PostMapping(value = "/frozenTask")
    public void frozenTask(@RequestParam("taskIdList") List<Long> taskIdList,
                           @RequestParam("scheduleStatus") Integer scheduleStatus) {
        taskService.frozenTask(taskIdList, scheduleStatus);
    }


}
