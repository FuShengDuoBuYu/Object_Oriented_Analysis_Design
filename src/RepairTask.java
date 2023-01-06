import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.UUID;

//报修
public class RepairTask {
    //保修单号
    private String taskID;
    //报修人
    private Owner owner;
    //报修时间
    private String reportTime;
    //报修描述
    private String description;
    //报修状态是一个枚举类型
    private RepairStatus repairStatus;
    // 报修来源
    private String reportSource;
    //故障类型
    private FailureType failureType;

    public RepairTask(Owner owner, String description, String reportSource) {
        this.owner = owner;
        this.description = description;
        //当前时间
        this.reportTime = Calendar.getInstance().getTime().toString();
        this.reportSource = reportSource;
        taskID = UUID.randomUUID().toString();
        this.repairStatus = RepairStatus.UNPROCESSED;
    }

    public void setFinish(){
        this.repairStatus = RepairStatus.PROCESSED;
        owner.addPendingEvaluation(new RepairEvaluation(this));
    }

    public String getTaskID() {
        return taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setFailureType(FailureType failureType) {
        this.failureType = failureType;
    }

    public FailureType getFailureType() {
        return failureType;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setEvaluated(){
        this.repairStatus = RepairStatus.EVALUATED;
    }

}
