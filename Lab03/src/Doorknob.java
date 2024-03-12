public class Doorknob {
    private String doorknobID;
    
    public Doorknob(String doorknobID) {
        this.doorknobID = doorknobID;
    }

    public String getDoorknobID() {
        return doorknobID;
    }

    public boolean canUnlock(Key key) {
        return getDoorknobID().equals(key.getKeyID());
    }
}
