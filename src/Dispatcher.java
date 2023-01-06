import java.util.ArrayList;
import java.util.List;

//调度员
public class Dispatcher{
    private String name;
    private List<RepairTask> repairTasks = new ArrayList<>();
    private List<ComplainExplain> complainExplains = new ArrayList<>();
    public Dispatcher(String name) {
        this.name = name;
    }

    public void receiveRepair(RepairTask repairTask){
        repairTasks.add(repairTask);
    }

    public boolean hasRepair(String repairTaskId){
        return this.repairTasks.stream().anyMatch(repairTask -> repairTask.getTaskID().equals(repairTaskId));
    }

    public void findOutFailureType(RepairTask repairTask){
        if(repairTask.getDescription().contains("水")){
            repairTask.setFailureType(new FailureType("水"));
        }else if(repairTask.getDescription().contains("电")){
            repairTask.setFailureType(new FailureType("电"));
        }else if(repairTask.getDescription().contains("气")){
            repairTask.setFailureType(new FailureType("气"));
        }
    }

    public void findOutFailureType(RepairTask repairTask,FailureType failureType){
        repairTask.setFailureType(failureType);
    }

    public void dispatch(List<Repairer> repairers){
        if(TaskDispatch.getProcessingDispatch()!=null){
            System.out.println("仍有任务调度在系统中未完成");
            return;
        }
        //找到所有正在进行的维修任务
        RepairTask doingRepairTask = null;
        for(RepairTask repairTask : repairTasks){
            if(repairTask.getRepairStatus().equals(RepairStatus.UNPROCESSED)){
                doingRepairTask= repairTask;
                break;
            }
        }
        if(doingRepairTask == null){
            System.out.println("没有正在进行的维修任务");
            return;
        }
        //根据工种分配维修工进行调度
        for(Repairer repairer : repairers){
            if(repairer.canRepair(doingRepairTask.getFailureType())){
                List<Repairer> repairerss = new ArrayList<>();
                repairerss.add(repairer);
                //将调度任务存到系统中
                TaskDispatch.dispatchTask(doingRepairTask.getTaskID(), repairerss,this);
                //给维修工发布调度任务
                repairer.getDispatched(doingRepairTask.getTaskID());
                break;
            }
        }
    }

    public void finishRepairTask(boolean isSuccessfulFinish,FailureType failureType){
        RepairTask rt = null;
        Dispatch dispatch = TaskDispatch.getProcessingDispatch();
        for (RepairTask repairTask : repairTasks) {
            if(repairTask.getTaskID().equals(dispatch.getTaskID())){
                rt = repairTask;
                break;
            }
        }
        if(isSuccessfulFinish){
            //维修任务结束
            rt.setFinish();
            dispatch.setFinish();
        }else{
            //调度结束
            TaskDispatch.getProcessingDispatch().setFinish();
            //赋值新的故障类型
            rt.setFailureType(failureType);
        }
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

    public RepairTask getRepairTask(String repairTaskId){
        for(RepairTask repairTask : repairTasks){
            if(repairTask.getTaskID().equals(repairTaskId)){
                return repairTask;
            }
        }
        return null;
    }
}
