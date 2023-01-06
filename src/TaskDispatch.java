import java.util.*;

//单例模式
public class TaskDispatch {
    //报修单的id

    private static List<Dispatch> dispatches = new ArrayList<>();

    public static Dispatch getProcessingDispatch(){
        for (Dispatch dispatch : dispatches) {
            if(dispatch.isProcessing()){
                return dispatch;
            }
        }
        return null;
    }

    public static void dispatchTask(String taskId, List<Repairer> repairers, Dispatcher dispatcher){
        Dispatch dispatch = new Dispatch(taskId, repairers, dispatcher);
        dispatches.add(dispatch);
    }

    public static void addRepairRecord(RepairRecord repairRecord){
        getProcessingDispatch().addRepairRecord(repairRecord);
    }

    public static double getATaskRepairTime(String taskId){
        double allRepairTime = 0;
        for (Dispatch dispatch : dispatches) {
            if(dispatch.getTaskID().equals(taskId)){
                allRepairTime += dispatch.getRepairTime();
            }
        }
        return allRepairTime;
    }

    public static void clear(){
        dispatches.clear();
    }

    public static Dispatch getTaskRepairDispatch(String taskId,String dispatchId){
        Dispatch res = null;
        for (Dispatch dispatch : dispatches) {
            if(dispatch.getTaskID().equals(taskId)&&dispatch.getDispatchID().equals(dispatchId)){
                res = dispatch;
            }
        }
        return res;
    }

    public static List<Dispatch> getTaskRepairDispatches(String taskId){
        List<Dispatch> res = new ArrayList<>();
        for (Dispatch dispatch : dispatches) {
            if(dispatch.getTaskID().equals(taskId)){
                res.add(dispatch);
            }
        }
        return res;
    }

}

class Dispatch{
    private String taskID;

    private String dispatchId;

    private List<Repairer> repairers;
    //调度时间
    private Date dispatchTime;

    private boolean isFinish;

    private Dispatcher dispatcher;

    private List<RepairRecord> repairRecords = new ArrayList<>();
    public Dispatch(String taskID, List<Repairer> repairers, Dispatcher dispatcher) {
        this.taskID = taskID;
        this.dispatchId = UUID.randomUUID().toString();
        this.repairers = repairers;
        this.dispatcher = dispatcher;
        this.dispatchTime = Calendar.getInstance().getTime();
        this.isFinish = false;
    }

    public Boolean isProcessing(){
        return !this.isFinish;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getDispatchID() {
        return dispatchId;
    }

    public void addRepairRecord(RepairRecord repairRecord){
        repairRecords.add(repairRecord);
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public List<Repairer> getRepairers() {
        return repairers;
    }

    public double getRepairTime(){
        double allRepairTime = 0;
        for (RepairRecord repairRecord : repairRecords) {
            allRepairTime += repairRecord.getRepairRecordTime();
        }
        return allRepairTime;
    }

    public void setFinish(){
        this.isFinish = true;
    }

    public int getRepairRecordsSize() {
        return repairRecords.size();
    }
}