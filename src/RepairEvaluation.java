public class RepairEvaluation {
    //报修单号
    private RepairTask repairTask;
    //响应及时度
    private int responseTimeDegree;
    //服务态度
    private int serviceAttitudeDegree;
    //满意度
    private int satisfactionDegree;

    private boolean isEvaluated;
    public RepairEvaluation(RepairTask repairTask) {
        this.repairTask = repairTask;
        this.isEvaluated = false;
    }

    public void evaluate(int responseTimeDegree, int serviceAttitudeDegree, int satisfactionDegree){
        this.responseTimeDegree = responseTimeDegree;
        this.serviceAttitudeDegree = serviceAttitudeDegree;
        this.satisfactionDegree = satisfactionDegree;
        this.isEvaluated = true;
        this.repairTask.setEvaluated();
    }

    public boolean isEvaluated(){
        return this.isEvaluated;
    }

    public int getResponseTimeDegree() {
        return responseTimeDegree;
    }

    public int getServiceAttitudeDegree() {
        return serviceAttitudeDegree;
    }

    public int getSatisfactionDegree() {
        return satisfactionDegree;
    }

    public String getTaskID() {
        return repairTask.getTaskID();
    }
}
