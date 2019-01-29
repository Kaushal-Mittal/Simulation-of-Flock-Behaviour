package flockbase;
import java.util.ArrayList;


import flockbase.Flock;

public class FlockY extends Flock{
	public FlockY() {
        super();
        birds = new ArrayList<Bird>();
    }
    private Bird leader;
    private ArrayList<Bird> birds;

	// add a Bird to this Flock
	public void addBird(Bird b){
        birds.add(b);
        b.setFlock(this);
    }

	// Make this Bird the leader of the flock
	public void setLeader(Bird l){
        l.becomeLeader();
        for (Bird b : birds) b.setTarget(l.getPos().getX(), l.getPos().getX());
        leader = l;
    }

	// get current list of birds in the flock
	public ArrayList<Bird> getBirds(){
        return birds;
    }

	// return the current leader
	public Bird getLeader(){
        return leader;
    }
	
	// split with the bird at pos as the leader of new flock
	// Returns the new flock formed
    public Flock split(int pos){
        FlockY f = new FlockY();

        ArrayList<Bird> f_birds = new ArrayList<Bird>(birds.subList(pos, birds.size()));
        ArrayList<Bird> temp = new ArrayList<Bird>(birds.subList(0, pos-1));
        
        birds = temp;        
        f.setLeader(f_birds.get(0));
        for (Bird b : f_birds) f.addBird(b);
        return f;
    }

	// merges current flock with flock f - should join at end of f
	public void joinFlock(Flock f){
        this.getLeader().retireLead();
        for (Bird b : this.getBirds()) f.addBird(b);
    }

}