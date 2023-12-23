package Building;

public class List implements Next, Previous{

    public Stage current;
    private Stage[] list = new Stage[]{new Project(Status.PLANNED), new Foundation(Status.PLANNED), new Walls(Status.PLANNED), new Roof(Status.PLANNED), new Finishing(Status.PLANNED)};


    public List() {
        Stage root = list[0];
        current = root;
        
        for(int i = 1; i < 5; ++i) {
            current.next = list[i];
            current = current.next;
        }
        for(int i = 4; i >= 0; --i) {
            current.prev = list[i];
            current = current.prev;
        }
    }

    @Override
    public void next() {
        current = current.next;
        System.out.println(current.name);
    }
    @Override
    public void prev() {
        current = current.prev;
        System.out.println(current.name);
    }

    public String getCurrent() {
        return current.name;
    }
    public void updateStatus() throws IsRejected{
        System.out.println(current.name + " is in progress");
        current.status = Status.IN_PROGRESS;
        int chance = (int) (Math.random() * 100);
        if (chance < 15){
            System.out.println(current.name + " was rejected");
            current.status = Status.REJECTED;
            throw new IsRejected();
        }
        current.status = Status.DONE;
        System.out.println(current.name + " is done");
    }
}
