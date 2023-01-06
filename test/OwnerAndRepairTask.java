import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OwnerAndRepairTask {
    Owner owner;
    Dispatcher dispatcher;
    List<Repairer> repairers = new ArrayList<>();
    RepairTask repairTask1;
    public void initBasicInfo(){
        owner = new Owner("张三", "南区27号楼");
        dispatcher = new Dispatcher("调度员");

        List<FailureType> failureTypes = new ArrayList<>();
        failureTypes.add(new FailureType("水"));
        repairers.add(new Repairer("水维修工", failureTypes));
        failureTypes.remove("水");
        failureTypes.add(new FailureType("电"));
        repairers.add(new Repairer("电维修工", failureTypes));
        failureTypes.remove("电");
        failureTypes.add(new FailureType("气"));
        repairers.add(new Repairer("气维修工", failureTypes));
    }

    @Test
    public void OwnerUploadRepair() {
        initBasicInfo();
        //业主提出报修
        repairTask1 = new RepairTask(owner, "水龙头坏了", "微信");
        owner.uploadRepairTask(repairTask1);
        //调度员接收报修
        dispatcher.receiveRepair(repairTask1);
        //检验报修是否被接收
        assert dispatcher.hasRepair(repairTask1.getTaskID());
        System.out.println("=======正常流程1========");
        System.out.println("报修的产生和接收成功:"+"产生一个报修任务，报修任务ID为："+repairTask1.getTaskID()+"，报修内容为："+repairTask1.getDescription());
        //调度员根据报修内容判断故障类型
        dispatcher.findOutFailureType(repairTask1);
        assert repairTask1.getFailureType().getFailureName().equals("水");
        System.out.println("=======正常流程2========");
        System.out.println("报修的故障类型判断成功:"+"故障类型为："+repairTask1.getFailureType().getFailureName());
    }


}
