import java.util.ArrayList;

public class NodeRoot extends Node{
    public ArrayList<Node> listNode;

    public NodeRoot(int number){
        super(number);
        Node aux = this.getThis();
        listNode = new ArrayList<Node>();
        listNode.add(aux);
    }

    public Node[] getNodes(){
        
        int listSize = this.listNode.size();
        Node[] nodeArray = new Node[listSize];
        for(int i =0; i < listSize;i++){
            nodeArray[i] = listNode.get(i);
        }
        return nodeArray;
    }
}