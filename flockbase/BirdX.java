package flockbase;
import java.util.ArrayList;
import static java.lang.Math.sqrt;


public class BirdX extends Bird{
    
    public BirdX(){
        super();
        boolean amleader = false;
    }

    private boolean amleader;
    
	public void setTarget(int xt, int yt) {
        super.setTarget(xt, yt);
    }
    
    public void becomeLeader(){
        
        amleader = true;
        // int xt = getFlock().getf_Target().getX();
        // int yt = getFlock().getf_Target().getY();
        // setTarget(xt, yt);
    }
    
    public void retireLead(){
        amleader = false;
        int xt = getFlock().getLeader().getPos().getX();
        int yt = getFlock().getLeader().getPos().getY();
        setTarget(xt, yt);
    }

    protected boolean check_collision(int xt, int yt){
        Flock f = getFlock();
        ArrayList<Bird> bird_list = f.getBirds();
        for (Bird b : bird_list) {
            int x = b.getPos().getX();
            int y = b.getPos().getY();
            if((xt<(x+10) && xt>(x-10)) && (yt<(y+10) && yt>(y-10))){
                if(b != this){
                    // System.out.println("XXXX");
                    return true;
                }
            }
        }
        return false;
        
    }
    
    protected void updatePos(){
        
        int target_x = getTarget().getX() - getPos().getX();
        int target_y = getTarget().getY() - getPos().getY();
        
        double magnitude = Math.sqrt(target_x*target_x + target_y*target_y);
        
        double unit_target_x = target_x/ (magnitude+1);
        double unit_target_y = target_y/ (magnitude+1);
        
        int xt, yt;
        if(magnitude > 10){
            xt = (int)(getPos().getX() + getMaxSpeed()*unit_target_x);
            yt = (int)(getPos().getY() + getMaxSpeed()*unit_target_y);
        }
        else{
            xt = (int)(getPos().getX() + target_x);
            yt = (int)(getPos().getY() + target_y);
        }
        
        if(!check_collision(xt, yt)){
            setPos(xt, yt);
            // System.out.println("Pos updated");
        }
        if(check_collision(xt, yt) && amleader){
            // for (int i = 0; i < 3; i++) {
            xt = (int)(getPos().getX() - getMaxSpeed()*unit_target_y);
            yt = (int)(getPos().getY() + getMaxSpeed()*unit_target_x);
            setPos(xt, yt);
        }
        if(!amleader) {
            setTarget(this.getFlock().getLeader().getPos().getX(), this.getFlock().getLeader().getPos().getY());
        }
        
    }

}
