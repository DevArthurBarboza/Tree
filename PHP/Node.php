<?php 

declare(strict_types=1);

class Node {

public static int $nextId = 0;
public int $id;
public int $value;
public $left;
public $right;

function getThis(){
    return $this;
}

function __construct(int $number){
    $this->value = $number;
    $this->id = self::setId();

}


function getNode(int $number){
    return new Node($number);
}

static function setId(){
    self::$nextId++;
    return self::$nextId;


}


// Check if node right exists
function hasRight(){
    if (isset($this->right->value)){
        echo("existe");
        return true;
    }
    echo("não existe");
    return false;
}

// Check if node left exists
function hasLeft(){
    if (isset($this->left->value)){
        return true;
    }
    return false;
}



function isNextNotEmpty(Node $nodeParent, Node $newNode){
    if ($newNode > $nodeParent){
        if (!isset($nodeParent->right)){
            $nodeParent->right = $newNode;
            return false;
        }
        return true;
    }
    if (!isset($nodeParent->left)){
        $nodeParent->left = $newNode;
        return false;
    }
    return true;

}


function addNode(int $number){
    // Note to be added at the end of the tree
    $newNode = new Node($number);
    $auxNode = $this;

    
    
    //Checking right node of the root
    if ($number > $this->value){
        if (!$this->hasRight()){
            $this->right = $newNode;
            return $newNode;
        }


        $parentNode = $this->right;
        $continue = true;
        while($continue){
            $nextLeft = $parentNode->left;
            $nextRight = $parentNode->right;
            if ($newNode->value > $nextLeft->value){
                $continue = $this->isNextNotEmpty($nextLeft,$newNode);
            }
            if ($newNode->value < $nextLeft->value){
                $continue = $this->isNextNotEmpty($nextRight,$newNode);
            }
        }

    }

    //Checking left node of the root
    if ($number < $this->value){
        if (!$this->hasLeft()){
            $this->left = $newNode;
            return $newNode;
        }

        $parentNode = $this->left;
        $continue = true;
        while($continue){
            $nextLeft = $parentNode->left;
            $nextRight = $parentNode->right;
            if ($newNode->value > $nextLeft->value && ($nextLeft->value != null)){
                $continue = $this->isNextNotEmpty($nextLeft,$newNode);
            }
            if ($newNode->value < $nextLeft->value && ($nextRight->value != null)){
                $continue = $this->isNextNotEmpty($nextRight,$newNode);
            }
            
        }
    }

}


}
