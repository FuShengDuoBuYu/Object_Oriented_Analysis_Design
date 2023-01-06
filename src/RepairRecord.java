import java.util.Date;

//维修记录
public class RepairRecord {
    private String repairerName;
    private Date startTime;
    private Date endTime;
    //维修过程备注
    private String repairRemark;

    public RepairRecord(String repairerName,Date startTime, Date endTime, String repairRemark) {
        this.repairerName = repairerName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.repairRemark = repairRemark;
    }

    public Double getRepairRecordTime(){
        //小时
        return (endTime.getTime()-startTime.getTime())/1000.0/60/60;
    }
}
