import java.util.*;

//投诉
public class Complaint {
    //投诉流水号
    private String complaintID;
    //投诉人
    private Owner owner;
    //投诉描述
    private String complaintDescription;
    //投诉情况
    private boolean isSolved;
    //投诉时间
    private Date complaintTime;

    private String response = null;
    private RepairTask complaintRepairTask;

    private PropertyManager propertyManager;
    private List<ComplainExplain> complainExplains = new ArrayList<>();

    public Complaint(Owner owner, String complaintDescription, RepairTask complaintRepairTask, PropertyManager propertyManager) {
        this.complaintID = UUID.randomUUID().toString();
        this.owner = owner;
        this.complaintDescription = complaintDescription;
        isSolved = false;
        this.complaintTime = Calendar.getInstance().getTime();
        this.complaintRepairTask = complaintRepairTask;
        this.propertyManager = propertyManager;
        getComplainExplainsPerson();

    }

    public void getComplainExplainsPerson(){
        //找到这些和本次投诉相关的人并发送给他们情况说明
        String taskId = complaintRepairTask.getTaskID();
        List<Dispatch> dispatches = TaskDispatch.getTaskRepairDispatches(taskId);
        //给每次调度的调度员和维修员发送情况说明
        for(Dispatch dispatch:dispatches){
            Dispatcher dispatcher = dispatch.getDispatcher();
            List<Repairer> repairers = dispatch.getRepairers();
            for(Repairer repairer:repairers){
                ComplainExplain complainExplain = new ComplainExplain(this,propertyManager);
                complainExplains.add(complainExplain);
                repairer.receiveComplain(complainExplain);
            }
            ComplainExplain complainExplain = new ComplainExplain(this,propertyManager);
            dispatcher.receiveComplain(complainExplain);
            complainExplains.add(complainExplain);
        }
    }

    public String getComplaintID(){
        return complaintID;
    }

    public void solveComplain(String response){
        isSolved = true;
        this.response = response;
    }

    public String getTaskId(){
        return complaintRepairTask.getTaskID();
    }

    public boolean allComplainExplainWritten(){
        for(ComplainExplain complainExplain:complainExplains){
            if(!complainExplain.isWrite()){
                return false;
            }
        }
        return true;
    }

    public Owner getOwner() {
        return owner;
    }

    public List<ComplainExplain> getComplainExplains() {
        return complainExplains;
    }

    public boolean isSolved() {
        return isSolved;
    }
}
