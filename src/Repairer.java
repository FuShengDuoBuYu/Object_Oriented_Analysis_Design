import java.util.*;

//维修工
public class Repairer {
    private String name;
    private List<FailureType> failureTypes = new ArrayList<>();
    private List<ComplainExplain> complainExplains = new ArrayList<>();
    private Map<String,List<RepairRecord>> repairRecord = new HashMap<>();
    private boolean isIdle;
    private String currentTaskId = null;

    public Repairer(String name, List<FailureType> failureTypes) {
        this.name = name;
        this.failureTypes = failureTypes;
        this.isIdle = true;
    }

    public boolean canRepair(FailureType failureType){
        return this.failureTypes.stream().anyMatch(failureType1 -> failureType1.getFailureName().equals(failureType.getFailureName()))&&isIdle;
    }

    public String getName(){
        return name;
    }

    //被调度员调度
    public void getDispatched(String taskId){
        isIdle = false;
        repairRecord.put(taskId,new ArrayList<>());
        currentTaskId = taskId;
    }

    public String getCurrentTaskId(){
        return currentTaskId;
    }

    public void repair(Date startTime,Date endTime,String repairRemark){
        if(currentTaskId == null){
            return;
        }
        RepairRecord repairRecord = new RepairRecord(name,startTime,endTime,repairRemark);
        //工人维护自己的维修记录
        this.repairRecord.get(currentTaskId).add(repairRecord);
        //对于一个调度,维护维修记录
        TaskDispatch.addRepairRecord(repairRecord);
    }

    public void finishRepair(){
        isIdle = true;
        currentTaskId = null;
        TaskDispatch.getProcessingDispatch().getDispatcher().finishRepairTask(true,null);
    }

    public void unableToRepair(FailureType failureType){
        isIdle = true;
        currentTaskId = null;
        TaskDispatch.getProcessingDispatch().getDispatcher().finishRepairTask(false,failureType);
    }

    public double getAllWorkTime(){
        double allRepairTime = 0;
        for(List<RepairRecord> repairRecords : repairRecord.values()){
            for(RepairRecord repairRecord : repairRecords){
                allRepairTime += repairRecord.getRepairRecordTime();
            }
        }
        return allRepairTime;
    }

    public boolean ifIdle(){
        return isIdle;
    }

    public void receiveComplain(ComplainExplain complainExplain){
        complainExplains.add(complainExplain);
    }

    public int getComplainCount(){
        return complainExplains.size();
    }

    public void writeComplainExplain(int index,String complainExplain){
        complainExplains.get(index).writeComplainExplain(complainExplain);
    }
}
