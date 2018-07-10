package program.peggy.action;

public class ActionClass {
    private int ActionID=0;
    private String ActionName;
    private int ActionPart;
    public final static String ActionID_ColName="_id";
    public final static String ActionName_ColName="ActionName";
    public final static String ActionPart_ColName="ActionPart";

    public ActionClass(int id,String name,int part){
        ActionID=id;
        ActionName=name;
        ActionPart=part;
    }
    public int getActionID(){
        return ActionID;
    }
    public String getActionName() {
        return ActionName;
    }
    public int getActionPart() { return ActionPart;}
}
