public class Node {

    public static int nextId = 0;
    public int id;
    public int value;
    public Node left;
    public Node right;

    public Node getThis(){
        return this;
    }

    public Node(int number){
        this.value = number;
        this.id = setId();

    }


    public Node getNode(int number){
        return new Node(number);
    }

    private static int setId(){
        nextId++;
        return nextId;


    }


    // Check if node right exists
    public boolean hasRight(){
        if (this.right != null){
            System.out.println("existe");
            return true;
        }
            System.out.println("não existe");
        return false;
    }

    // Check if node left exists
    public boolean hasLeft(){
        if (this.left != null){
            return true;
        }
        return false;
    }

    // Add a node using a number
    public void addNode(int number){
        // Note to be added at the end of the tree
        Node newNode = new Node(number);
        System.out.println("Antes do if");

        if (number > this.value){
            if (!this.hasRight()){
                this.right = newNode;
                return;
            }
            this.throwRight(newNode);
            return;
        }
        if (number < this.value){
            if (!this.hasLeft()){
                this.left = newNode;
                return;
            }
            this.throwLeft(newNode);
            return;
        }
    }


    // Add a node using a node
     public void addNode(Node newNode){
        // Note to be added at the end of the tree
        int number = newNode.value;

        if (number > this.value){
            if (!this.hasRight()){
                System.out.println("Saiuuu");
                this.right = newNode;
                return;
            }
            this.throwRight(newNode);
            return;
        }
        if (number < this.value){
            if (!this.hasLeft()){
                this.left = newNode;
                return;
            }
            this.throwLeft(newNode);
            return;
        }
    }

    public void throwLeft (Node newNode){
        
        Node parentNode = this.left;
        while((parentNode.hasLeft() && parentNode.hasRight())){
            Node nextLeft = parentNode.left;
            Node nextRight = parentNode.right;
            if (newNode.value > nextLeft.value){
                nextLeft.addNode(newNode.value);
            }
            if (newNode.value < nextLeft.value){

            }
        }
        if (newNode.value > parentNode.value){
            parentNode.right = newNode;
            return;
        } 
        parentNode.left = newNode;
        
    }

    public void throwRight (Node newNode){

        Node parentNode = this.right;
        while((parentNode.hasLeft() && parentNode.hasRight())){
            System.out.println("Testeeeeee");
            Node nextLeft = parentNode.left;
            Node nextRight = parentNode.right;
            if (newNode.value > nextLeft.value){
                nextLeft.addNode(newNode.value);
            }
            if (newNode.value < nextLeft.value){
                System.out.println("Ué");
            }
        }
        if (newNode.value > parentNode.value){
            parentNode.right = newNode;
            return;
        } 
        parentNode.left = newNode;
        

    }
}
