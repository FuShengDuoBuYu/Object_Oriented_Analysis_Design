import javafx.concurrent.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DispatchAndRepair {
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
    public void dispatchTaskAndAssignRepairer(){
        initBasicInfo();
        //业主提出报修
        repairTask1 = new RepairTask(owner, "水龙头坏了", "微信");
        owner.uploadRepairTask(repairTask1);
        dispatcher.receiveRepair(repairTask1);
        dispatcher.findOutFailureType(repairTask1);
        //以上为报修的产生和接收，故障类型判断
        //调度员根据故障类型分配维修工并调度任务
        dispatcher.dispatch(repairers);
        assert TaskDispatch.getProcessingDispatch().getTaskID().equals(repairTask1.getTaskID());
        System.out.println("=======正常流程3========");
        System.out.println("报修的调度成功:"+"调度的任务ID为："+TaskDispatch.getProcessingDispatch().getTaskID()+"调度的ID为："+TaskDispatch.getProcessingDispatch().getDispatchID());
        //维修工接收任务
        for(Repairer repairer:repairers){
            if(repairer.getName().equals("水维修工")){
                assert repairer.getCurrentTaskId().equals(repairTask1.getTaskID());
                System.out.println("=======正常流程4========");
                System.out.println("维修工人成功接收到:"+"接收的任务ID为："+TaskDispatch.getProcessingDispatch().getTaskID());
                System.out.println("=======扩展流程3========");
                System.out.println("成功将水维修任务分配给水维修工");
            }
        }
    }

    @Test
    public void repairerRepairTask(){
        initBasicInfo();
        repairTask1 = new RepairTask(owner, "水龙头坏了", "微信");
        owner.uploadRepairTask(repairTask1);
        dispatcher.receiveRepair(repairTask1);
        dispatcher.findOutFailureType(repairTask1);
        dispatcher.dispatch(repairers);
        //以上为报修的产生和接收，故障类型判断，调度任务
        //维修工到现场进行维修后，记录下维修结果
        for(Repairer repairer:repairers){
            Date endTime = Calendar.getInstance().getTime();
            //修了1h
            Date startTime = new Date(endTime.getTime() - 3600 * 1000);
            repairer.repair(startTime,endTime,"修好了");
        }
        //检验维修时间
        for(Repairer repairer:repairers){
            if(repairer.getName().equals("水维修工")){
                assert repairer.getAllWorkTime() == 1;
            }
        }
        assert TaskDispatch.getATaskRepairTime(repairTask1.getTaskID()) == 1;
        System.out.println("=======正常流程7========");
        System.out.println("维修工人与调度成功记录维修记录");
    }

    //扩展流程1
    @Test
    public void multiTimeDispatch(){
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
        String dispatchId = TaskDispatch.getProcessingDispatch().getDispatchID();
        //工人无法维修
        repairer1.unableToRepair(new FailureType("电"));
        //查看当前的报修的类型
        assert repairTask1.getFailureType().getFailureName().equals("电");
        System.out.println("=======扩展流程1_1========");
        System.out.println("维修工人无法维修，报告给调度员后成功将故障类型更改为电");
        //重新调度
        dispatcher.dispatch(repairers);
        Repairer repairer2 = null;
        for(Repairer repairer:repairers){
            if(repairer.getName().equals("电维修工")){
                assert repairer.getCurrentTaskId().equals(repairTask1.getTaskID());
                repairer2 = repairer;
                System.out.println("=======扩展流程1_2========");
                System.out.println("重新分配给新的种类的维修工:"+repairer.getName());
                System.out.println("=======扩展流程3========");
                System.out.println("成功将电维修任务分配给电维修工");
            }
        }
        assert repairer1.ifIdle() == true;
        assert repairer2.ifIdle() == false;
        System.out.println("=======扩展流程1_3========");
        System.out.println("原来的维修工成功进入空闲状态,新的维修工成功接收任务");

        //校验当前调度已经有一个维修记录
        assert TaskDispatch.getTaskRepairDispatch(repairTask1.getTaskID(),dispatchId).getRepairRecordsSize() == 1;
        System.out.println("=======扩展流程1_4========");
        System.out.println("调度成功记录上一个维修工人的维修记录");
    }

    //扩展流程2
    @Test
    public void multiTimeRepair(){
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
        repairer1.repair(startTime,endTime,"第一次维修");
        //修了2h
        startTime = new Date(endTime.getTime() - 7200 * 1000);
        repairer1.repair(startTime,endTime,"第二次维修");
        //此处修了2次
        assert TaskDispatch.getProcessingDispatch().getRepairRecordsSize() == 2;
        System.out.println("=======扩展流程2_1========");
        System.out.println("成功记录多次维修记录到同一次调度");
        assert repairer1.getAllWorkTime() == 3;
        assert TaskDispatch.getProcessingDispatch().getRepairTime() == 3;
        System.out.println("=======扩展流程2_2========");
        System.out.println("成功记录维修工人的总工作时间和调度的总工作时间");
    }


}
