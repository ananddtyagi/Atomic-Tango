public class ShortestPath(){
  public int[] node;
  public int length;
  public final int[] finalPosition;

  public ShortestPath(){

  }

  public ShortestPath(int[] finalPosition){
    this.finalPosition = finalPosition;
  }

  public ShortestPath(int [] node, int length){
    this.node = node;
    this.length = length;
    match();
  }

  public void recordLength(){
    //records the length of how long it took to get to the current node
  }

  public void recordMap(){
    //keeps the array of the whole map up to this point
  }

  public void generateNeighbors(){
  State s = new States();

  }

  public boolean match(){
    return node == finalPosition;
    //checks it against the final result and returns true if it's a match;
  }

}
