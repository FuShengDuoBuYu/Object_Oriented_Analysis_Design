import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EvaluateAndComplaint {
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

    //正常流程
    @Test
    public void finishTaskOrDispatchAgain(){
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
        //工人维修完成
        repairer1.finishRepair();
        assert repairer1.getCurrentTaskId() == null;
        assert repairer1.ifIdle();
        System.out.println("=======正常流程6========");
        System.out.println("维修工人成功完成维修,进入空闲状态");

        assert owner.getEvaluated(repairTask1.getTaskID())!=null;
        System.out.println("=======正常流程8========");
        System.out.println("成功分配报修"+repairTask1.getTaskID()+"的评价给业主");

        owner.evaluateRepair(10,10,10);
        assert owner.getEvaluated(repairTask1.getTaskID()).getResponseTimeDegree() == 10;
        assert owner.getEvaluated(repairTask1.getTaskID()).isEvaluated();
        System.out.println("=======正常流程9========");
        System.out.println("业主成功评价报修"+repairTask1.getTaskID());
    }

    //扩展流程4
    @Test
    public void ownerUploadComplaint(){
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

        //业主发起投诉
        PropertyManager propertyManager = new PropertyManager("物业经理");
        owner.uploadComplaintTask(repairTask1.getTaskID(),"维修工人不认真",propertyManager);
        assert owner.getComplaint(repairTask1.getTaskID())!=null;
        //查看对应人员是否都已经收到投诉
        assert repairer1.getComplainCount() == 1;
        assert dispatcher.getComplainCount() == 1;
        System.out.println("=======扩展流程4_1========");
        System.out.println("业主成功发起投诉");
    }

    //扩展流程4
    @Test
    public void solveComplaint(){
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

        PropertyManager propertyManager = new PropertyManager("物业经理");
        owner.uploadComplaintTask(repairTask1.getTaskID(),"维修工人不认真",propertyManager);

        Complaint complaint = owner.getComplaint(repairTask1.getTaskID());

        repairer1.writeComplainExplain(0,"我很认真");
        assert !complaint.isSolved();

        dispatcher.writeComplainExplain(0,"维修工人不认真和我无关");
        assert complaint.isSolved();

        System.out.println("=======扩展流程4_2========");
        System.out.println("维修工人和调度员成功输出投诉说明并且物业经理解决了投诉");
    }
}
