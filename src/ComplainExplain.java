public class ComplainExplain {

    //投诉说明
    private String ComplainExplain;
    //填写状态
    private Boolean isWrite;

    private Complaint complaint;

    private PropertyManager propertyManager;

    public ComplainExplain(Complaint complaint,PropertyManager propertyManager) {
        this.complaint = complaint;
        this.propertyManager = propertyManager;
        this.isWrite = false;
    }

    public void writeComplainExplain(String ComplainExplain){
        this.ComplainExplain = ComplainExplain;
        this.isWrite = true;
        propertyManager.receiveComplainExplainWritenMsg(complaint);
    }

    public boolean isWrite(){
        return this.isWrite;
    }
}
