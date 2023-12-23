package Building;

public class BuildingProcces implements Building{
    private List list = new List();
    @Override
    public void build(){
        do {
            try {
                list.updateStatus();
                if (list.current.name != "Finishing") list.next();
            } catch (IsRejected e) {
                if (list.current.name == "Project") {
                    System.out.println("Rejected");
                    break;
                } else {
                    list.prev();
                }
            }
        }while (list.current.name != "Finishing" || (list.current.name == "Finishing" & list.current.status != Status.DONE));
    }

    @Override
    public void doneBuild() {
        System.out.println("Building is done ");
    }
}
