public class AtomicTango2{


    public static void main(String[] args) {

      int [] initialPos = {0,0,0,0,0,0,0,0};
      States initial = new GenerateStates(initialPos);
      initial.generateNewStates();

      for(int i = 0; i < initial.getNewStates().size(); i++){
        initial.getNewStates().get(i).printStatement();
        System.out.println();
      }
    }

}
