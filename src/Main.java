public class Main {
    public static void main(String[] args) {

    }

    private static void initSystem(){
        //业主
        Owner owner = new Owner("张三", "南区27号楼");
        //业主提出报修
        RepairTask repairTask1 = new RepairTask(owner, "水龙头坏了", "南区27号楼");

    }
}