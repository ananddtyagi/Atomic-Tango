

import java.util.*;

public class AtomicTango{

static int p, f, wF, uF, l, fC, tC, h;

   public static void main(String[] args) {

        /*Scanner s = new Scanner(System.in);

        System.out.println("Position: ");
        p = s.nextInt();
        System.out.println("Facing: ");
        f = s.nextInt();
        System.out.println("Weighted Foot: ");
        wF = s.nextInt();
        System.out.println("Unweighted Foot: ");
        uF = s.nextInt();
        System.out.println("Leaning: ");
        l = s.nextInt();
        System.out.println("Foot Contact: ");
        fC = s.nextInt();
        System.out.println("Thigh Contact: ");
        tC = s.nextInt();
        System.out.println("Height: ");
        h = s.nextInt();
*/

        //State initial = new State(p, f, wF, uF, l, fC, tC, h);
        States initial = new States();
        ArrayList<States> moves = new ArrayList<States>();

        moves = initial.newStates(initial);



        System.out.println(moves.size());


        for(int i = 0; i < moves.size(); i++){
          System.out.println(moves.get(i).getP() + ", " + moves.get(i).getF() + ", " + moves.get(i).getwF() + ", " +
                               moves.get(i).getuF() + ", " +moves.get(i).getL() + ", " + moves.get(i).getfC() + ", " + moves.get(i).gettC() + ", " + moves.get(i).getH());
        }
        



      }
    }
