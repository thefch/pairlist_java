import java.util.ArrayList;

public class PairList extends ArrayList<Pair>{
    ArrayList<Pair<String,Object>> list;

    PairList(){
        list = new ArrayList<Pair<String,Object>>();
    }

    public boolean add(String var, Object value){
        if(exists(var)){
            try {
                throw new DuplicateVariableName();
            } catch (DuplicateVariableName duplicateVariableName) {
                duplicateVariableName.printStackTrace();
            }
            return false;
        }

        this.list.add(new Pair<>(var,value));

        System.out.println("Pair added:"+var+" "+value);
        return true;
    }

    public boolean exists(String var){
        for(Pair<String, Object> p: list){
            if(p.getVariable() == var)
                return true;
        }
        return false;
    }

    public Pair<String,Object> getPair(String var){
        for (Pair p:list){
            if(p.getVariable() == var){
                return p;
            }

        }
        System.out.println(" No pair found with these values !!");

        return null;
    }

    public Object get(String var){
        for (Pair p:list){
            if(p.getVariable() == var){
                return p.getValue();
            }

        }
        System.out.println(" No value found with that variable !!");
        return null;
    }

    private int indexOf(String var){
        for(int i=0;i<list.size();i++){
            if(var.equals(list.get(i).getVariable())) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(String var){
        int index = indexOf(var);
        if (index != -1) {
            list.remove(index);
            return true;
        }
        System.out.println("Variable "+var + " was does not exits in the list");
        return false;
    }

    @Override
    public String toString() {
        String output = "";
        for (Object o: list){
            output+= o ;
            output+= "\n" ;

        }
        return output;
    }


    public static void main(String[] args) {
        PairList pairList = new PairList();
        pairList.add("minutes",2);
        pairList.add("seconds",5);

        System.out.println(pairList);

        pairList.get("minutes");

    }
}



class Pair<Variable, V> {

    private final Variable var;
    private final V val;

    public Pair(Variable var_, V val_) {
        //assert var != null;
        assert val_ != null;



        this.var = var_;
        this.val = val_;
    }
    public Variable getVariable() { return var; }
    public V getValue() { return val; }

    @Override
    public String toString() {
        return this.var + " : " +this.val;
    }
}

class DuplicateVariableName extends Exception{
    DuplicateVariableName(){
        super("Variables with duplicate name are not allowed!");
    }
}