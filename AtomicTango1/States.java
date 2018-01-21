import java.util.*;

public class States{

public int position, facing, weightedFoot, unweightedFoot, leaning, footContact, thighContact, height;
public ArrayList<States> newStates;

//default constructor
  public States(){
    position = 0;
    facing = 0;
    weightedFoot = 0;
    unweightedFoot = 0;
    leaning = 0;
    footContact = 0;
    thighContact = 0;
    height = 0;
  }

//overloaded constructor
  public States(int p, int f, int wF, int uF, int l, int fC, int tC, int h){
    position = p;
    facing = f;
    weightedFoot = wF;
    unweightedFoot = uF;
    leaning = l;
    footContact = fC;
    thighContact = tC;
    height = h;

  }

//makes the array that contains all of the sister moves.
  public ArrayList<States> newStates(States i){

    newStates = new ArrayList<States>();

    int [] temp = new int[2];


    temp = newP(i.getP());
    newStates.add(new States(temp[0], i.getF(), i.getwF(), i.getuF(), i.getL(), i.getfC(), i.gettC(), i.getH()));
    newStates.add(new States(temp[1], i.getF(), i.getwF(), i.getuF(), i.getL(), i.getfC(), i.gettC(), i.getH()));

    temp = newF(i.getF());
    newStates.add(new States(i.getP(), temp[0], i.getwF(), i.getuF(), i.getL(), i.getfC(), i.gettC(), i.getH()));
    newStates.add(new States(i.getP(), temp[1], i.getwF(), i.getuF(), i.getL(), i.getfC(), i.gettC(), i.getH()));

    temp = newwF(i.getwF());
    newStates.add(new States(i.getP(), i.getF(), temp[0], i.getuF(), i.getL(), i.getfC(), i.gettC(), i.getH()));
    newStates.add(new States(i.getP(), i.getF(), temp[1], i.getuF(), i.getL(), i.getfC(), i.gettC(), i.getH()));

    temp = newuF(i.getuF());
    newStates.add(new States(i.getP(), i.getF(), i.getwF(), temp[0], i.getL(), i.getfC(), i.gettC(), i.getH()));
    newStates.add(new States(i.getP(), i.getF(), i.getwF(), temp[1], i.getL(), i.getfC(), i.gettC(), i.getH()));

    temp = newL(i.getL());
    newStates.add(new States(i.getP(), i.getF(), i.getwF(), i.getuF(), temp[0], i.getfC(), i.gettC(), i.getH()));
    newStates.add(new States(i.getP(), i.getF(), i.getwF(), i.getuF(), temp[1], i.getfC(), i.gettC(), i.getH()));

    temp = newfC(i.getfC());
    newStates.add(new States(i.getP(), i.getF(), i.getwF(), i.getuF(), i.getL(), temp[0], i.gettC(), i.getH()));
    newStates.add(new States(i.getP(), i.getF(), i.getwF(), i.getuF(), i.getL(), temp[1], i.gettC(), i.getH()));

    temp = newtC(i.gettC());
    newStates.add(new States(i.getP(), i.getF(), i.getwF(), i.getuF(), i.getL(), i.getfC(), temp[0], i.getH()));
    newStates.add(new States(i.getP(), i.getF(), i.getwF(), i.getuF(), i.getL(), i.getfC(), temp[1], i.getH()));

    if(i.getH() == 0){
      newStates.add(new States(i.getP(), i.getF(), i.getwF(), i.getuF(), i.getL(), i.getfC(), i.gettC(), 1));
    } else {
      newStates.add(new States(i.getP(), i.getF(), i.getwF(), i.getuF(), i.getL(), i.getfC(), i.gettC(), 0));
    }

  //  return stateToIntArray(newStates);
    return newStates;
  }

//generates the two new sister values for each part of the body.
  public int[] newP(int iP){
    int[] x = {((iP - 1) + 8) % 8, ((iP + 1) + 8) % 8};
    return x;
  }
  public int[] newF(int iF){
    int[] x = {((iF - 1) + 4) % 4, ((iF + 1) + 4) % 4};
    return x;
  }
  public int[] newwF(int iwF){
    int[] x = {((iwF - 1) + 3) % 3, ((iwF + 1) + 3) % 3};
    return x;
  }
  public int[] newuF(int iuF){
    int[] x = {((iuF - 1) + 9) % 9, ((iuF + 1) + 9) % 9};
    return x;
  }
  public int[] newL(int iL){
    int[] x = {((iL - 1) + 3) % 3, ((iL + 1) + 3) % 3};
    return x;
  }
  public int[] newfC(int ifC){
    int[] x = {((ifC - 1) + 3) % 3, ((ifC + 1) + 3) % 3};
    return x;
  }
  public int[] newtC(int itC){
    int[] x = {((itC - 1) + 4) % 4, ((itC + 1) + 4) % 4};
    return x;
  }

//get Functions
  public int getP(){
    return position;
  }
  public int getF(){
    return facing;
  }
  public int getwF(){
    return weightedFoot;
  }
  public int getuF(){
    return unweightedFoot;
  }
  public int getL(){
    return leaning;
  }
  public int getfC(){
    return footContact;
  }
  public int gettC(){
    return thighContact;
  }
  public int getH(){
    return height;
  }

  //public int[] stateToIntArray(State s){

}

/* if we have P, F, wF, uF, L, fC, tC, H --- k1, k2, ... Total number of Statess
is k1 * k2 * k3 *... K8
Future: we want to define each kind of move: gancho, leaning in (volcada), leaning out
(colgada), foot contact (parada). Here is a sequence of Statess, find the shortest path
to visit all in the sequence.

basic database has one file that is a set of states
and another that is a set of edges (s1, s2) such that they are neighbors
/*
  public void printer(){
    System.out.println(newStates.get(newStates.size() - 1).getP() + " " +  newStates.get(newStates.size() - 1).getF() + " " +
        newStates.get(newStates.size() - 1).getwF() + " " +  newStates.get(newStates.size() - 1).getuF() + " " +
          newStates.get(newStates.size() - 1).getL() + " " +  newStates.get(newStates.size() - 1).getfC() + " " +  newStates.get(newStates.size() - 1).gettC() + " " +
             newStates.get(newStates.size() - 1).getH());
  }
  */
