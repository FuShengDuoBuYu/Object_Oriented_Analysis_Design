import java.util.ArrayList;
import java.util.List;

//业主
public class Owner {
    private String name;
    private String homeAddress;

    private List<RepairEvaluation> repairEvaluations = new ArrayList<>();

    private List<RepairTask> repairTasks = new ArrayList<>();

    private List<Complaint> complaints = new ArrayList<>();
    public Owner(String name, String homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }

    public void addPendingEvaluation(RepairEvaluation repairEvaluation){
        repairEvaluations.add(repairEvaluation);
    }

    public void evaluateRepair(int responseTimeDegree, int serviceAttitudeDegree, int satisfactionDegree){
        for (RepairEvaluation repairEvaluation : repairEvaluations) {
            if(!repairEvaluation.isEvaluated()){
                repairEvaluation.evaluate(responseTimeDegree, serviceAttitudeDegree, satisfactionDegree);
                return;
            }
        }
    }

    public RepairEvaluation getEvaluated(String taskID){
        for (RepairEvaluation repairEvaluation : repairEvaluations) {
            if(repairEvaluation.getTaskID().equals(taskID)){
                return repairEvaluation;
            }
        }
        return null;
    }

    public void uploadRepairTask(RepairTask repairTask){
        repairTasks.add(repairTask);
    }

    public void uploadComplaintTask(String complaintTaskId, String description,PropertyManager propertyManager){
        //根据Taskid找到对应的报修单
        RepairTask repairTask = null;
        for (RepairTask task : repairTasks) {
            if(task.getTaskID().equals(complaintTaskId)){
                repairTask = task;
                break;
            }
        }
        Complaint complaint = new Complaint(this,description,repairTask,propertyManager);
        complaints.add(complaint);
    }

    public Complaint getComplaint(String taskID){
        for (Complaint complaint : complaints) {
            if(complaint.getTaskId().equals(taskID)){
                return complaint;
            }
        }
        return null;
    }

    public String reviewComplaint(List<ComplainExplain> complainExplains){
        return String.valueOf(complainExplains.size());
    }
}
