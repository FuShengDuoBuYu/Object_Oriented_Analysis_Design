import java.util.ArrayList;
import java.util.List;

public class PropertyManager {
    private String name;

//    private List<Complaint> complaints = new ArrayList<>();

    public PropertyManager(String name) {
        this.name = name;
    }

//    public void receiveComplain(Complaint complaint){
//        complaints.add(complaint);
//    }

    public void receiveComplainExplainWritenMsg(Complaint complaint){
        if(complaint.allComplainExplainWritten()){
            complaint.solveComplain(chatWithOwner(complaint));
        }
    }

    public String chatWithOwner(Complaint complaint){
        Owner owner = complaint.getOwner();
        return owner.reviewComplaint(complaint.getComplainExplains());
    }

//    public void solveComplain(String complaintID,String response){
//        for (Complaint complaint : complaints) {
//            if(complaint.getComplaintID().equals(complaintID)){
//                complaint.solveComplain(response);
//                return;
//            }
//        }
//    }
}
