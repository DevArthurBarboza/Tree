import java.util.Scanner;

public class Tree{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe um valor referente ao nó raiz : ");
        int value = 5;
        NodeRoot rootNode = new NodeRoot(value);
        rootNode.addNode(3);
        rootNode.addNode(9);
        rootNode.addNode(-1);
        rootNode.addNode(4);
        rootNode.addNode(-6);
        rootNode.addNode(2);
        System.out.println("Teste");

        Node[] nodeArray = rootNode.getNodes();

        for(int i =0; i < nodeArray.length; i++){
            System.out.println("Node " + nodeArray[i].id + " valor: " + nodeArray[i].value);
        }



    }
}