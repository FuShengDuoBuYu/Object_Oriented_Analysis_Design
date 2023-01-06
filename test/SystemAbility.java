import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SystemAbility {
    Owner owner;
    Dispatcher dispatcher;
    List<Repairer> repairers = new ArrayList<>();
    RepairTask repairTask1;
    public void initBasicInfo(){
        owner = new Owner("张三", "南区27号楼");
        dispatcher = new Dispatcher("调度员");

        List<FailureType> failureTypes1 = new ArrayList<>();
        failureTypes1.add(new FailureType("水"));
        repairers.add(new Repairer("水维修工", failureTypes1));
        List<FailureType> failureTypes2 = new ArrayList<>();
        failureTypes2.add(new FailureType("电"));
        repairers.add(new Repairer("电维修工", failureTypes2));
        List<FailureType> failureTypes3 = new ArrayList<>();
        failureTypes3.add(new FailureType("气"));
        repairers.add(new Repairer("气维修工", failureTypes3));

        TaskDispatch.clear();
    }

    @Test
    public void DispatcherKnowRepairTaskInfo(){
        initBasicInfo();
        repairTask1 = new RepairTask(owner, "水龙头坏了", "微信");
        owner.uploadRepairTask(repairTask1);
        dispatcher.receiveRepair(repairTask1);
        dispatcher.findOutFailureType(repairTask1);
        dispatcher.dispatch(repairers);
        Repairer repairer1 = null;
        for(Repairer repairer:repairers){
            if(repairer.getCurrentTaskId()!=null){
                repairer1 = repairer;
            }
        }
        Date endTime = Calendar.getInstance().getTime();
        //修了1h
        Date startTime = new Date(endTime.getTime() - 3600 * 1000);
        repairer1.repair(startTime,endTime,"修好了");
        //以上为报修的产生和接收，故障类型判断，调度任务，维修任务
        assert dispatcher.getRepairTask(repairTask1.getTaskID()).getRepairStatus().equals(RepairStatus.UNPROCESSED);
        System.out.println("======系统功能1_1======");
        System.out.println("调度员可以查看报修任务的状态");
        assert TaskDispatch.getTaskRepairDispatches(repairTask1.getTaskID()).size()==1;
        System.out.println("======系统功能1_2======");
        System.out.println("调度员可以查看报修任务的调度记录");
        assert TaskDispatch.getTaskRepairDispatches(repairTask1.getTaskID()).get(0).getRepairRecordsSize()==1;
        System.out.println("======系统功能1_3======");
        System.out.println("调度员可以查看报修任务的维修记录");

        assert TaskDispatch.getProcessingDispatch() != null;
        System.out.println("======系统功能3======");
        System.out.println("处理中的报修，知道当前活动的调度");
    }

    @Test
    public void RepairerKnowPersonalInfoAndOtherAbility(){
        initBasicInfo();
        repairTask1 = new RepairTask(owner, "水龙头坏了", "微信");
        owner.uploadRepairTask(repairTask1);
        dispatcher.receiveRepair(repairTask1);
        dispatcher.findOutFailureType(repairTask1);
        dispatcher.dispatch(repairers);
        Repairer repairer1 = null;
        for(Repairer repairer:repairers){
            if(repairer.getCurrentTaskId()!=null){
                repairer1 = repairer;
            }
        }
        Date endTime = Calendar.getInstance().getTime();
        assert repairer1.getCurrentTaskId()!=null;
        //修了1h
        Date startTime = new Date(endTime.getTime() - 3600 * 1000);
        repairer1.repair(startTime,endTime,"修好了");
        //以上为报修的产生和接收，故障类型判断，调度任务，维修任务
        assert !repairer1.ifIdle();
        System.out.println("======系统功能4======");
        System.out.println("可以知道一个维修工是否空闲");
        assert repairer1.getAllWorkTime()==1;
        System.out.println("======系统功能6======");
        System.out.println("可以知道一个维修工的工作时长");
        assert TaskDispatch.getATaskRepairTime(repairTask1.getTaskID())==1;
        System.out.println("======系统功能5======");
        System.out.println("可以知道一个报修用掉的工时");

        owner.uploadComplaintTask(repairTask1.getTaskID(), "维修工不好",new PropertyManager("物业经理"));
        assert repairer1.getComplainCount()==1;
        assert dispatcher.getComplainCount()==1;
        System.out.println("======系统功能2======");
        System.out.println("维修工人可以知道他的投诉");
    }
}
