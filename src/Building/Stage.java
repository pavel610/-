package Building;

abstract class Stage {
    String name;
    Status status;
    Stage next;
    Stage prev;

    public Stage(String name, Status status) {
        this.name = name;
        this.status = status;
    }


}
