import java.util.*;

public class AtomicTango3{
  public static int pS, fS, wFS, uFS, lS, fCS, tCS, hS; //start values
  public static int pF, fF, wFF, uFF, lF, fCF, tCF, hF; //finish values
  public static int [] dists;
  public static ArrayList<int[]> permutations;
  public static int[] s;

  public static void main(String[] args) {


    //States3 initial = new States3();
    ArrayList<int[]> states = new ArrayList<int[]>();
   permutations = new ArrayList<int[]>();

    pS = 0; fS = 0; wFS = 0; uFS = 0; lS = 0; fCS = 0; tCS = 0; hS = 0;
    int[] S = {pS, fS, wFS, uFS, lS, fCS, tCS, hS};

    pF = 1; fF = 2; wFF = 1; uFF = 0; lF = 0; fCF = 0; tCF = 0; hF = 0;
    int[] F = {pF, fF, wFF, uFF, lF, fCF, tCF, hF};

  
    states = generateStates(S, F);

    s = new int[states.size()];

    for(int i = 0; i < states.size(); i++){
      printer(states.get(i));
      s[i] = i;
    }

    //permute(s, 1, states.size());


    System.out.println(permutations.size());
    for(int i = 0; i < permutations.size(); i++){
      printer(permutations.get(i));
    }
  }


  public static void permute(int[] arr, int index, int s){

    int [] temp = new int[s];

    if(index >= arr.length - 1){
        for(int i = 0; i < arr.length - 1; i++){
            temp[i] = arr[i];


        }
        if(arr.length > 0)
            temp[temp.length - 1] = arr[arr.length - 1];

        permutations.add(temp.clone());

        return;
    }

    for(int i = index; i < arr.length; i++){ //For each index in the sub array arr[index...end]

        //Swap the elements at indices index and i
        int t = arr[index];
        arr[index] = arr[i];
        arr[i] = t;

        //Recurse on the sub array arr[index+1...end]
        permute(arr, index+1, s);

        //Swap the elements back
        t = arr[index];
        arr[index] = arr[i];
        arr[i] = t;
    }


}
/*
  public static void calcDist(){ //finds the distances between the start and stop of each position.
    dists = new int[8];
    dists[0] = ((pS - pF) + 8) % 8;
    dists[1] = ((fS - fF) + 4) % 4;
    dists[2] = ((wFS - uFF) + 3) % 3;
    dists[3] = ((uFS - uFF) + 9) % 9;
    dists[4] = ((lS - lF) + 3) % 3;
    dists[5] = ((fCS - fCF) + 3) % 3;
    dists[6] = ((tCS - tCF) + 4) % 4;
    dists[7] = ((hS - hF) + 2) % 2;

  }
*/
  public static ArrayList<int[]> generateStates(int [] S, int [] F){
    //int[] caps = {8,4,3,9,3,3,4,2};
    int start[] = S.clone();
    ArrayList<int[]> states = new ArrayList<int[]>();

    /*
    for(int i = 0; i < 8; i++){       //only works if F > S
      if(S[i] != F[i]){
        for(int j = S[i]; j <= F[i]; j++){
          start[i] = j;
          states.add(start.clone());
        }
      }
    }
    */
    int [] j = S.clone();

    for(int  i = 0; i < 8; i++){
      if(j[i] != F[i]){
        j[i]++;
        start[i] = j[i];
        states.add(start.clone());
      }
    }

    permute(S, 1, 0);

    return states;

  }

  public static void printer(int [] p){
    StringBuilder sb = new StringBuilder("{");
    for(int i = 0; i < p.length; i++){
      sb.append(p[i]);
      if(i != p.length - 1){
        sb.append(", ");
      }
    }
    sb.append("}");
    System.out.println(sb);
  }
}
