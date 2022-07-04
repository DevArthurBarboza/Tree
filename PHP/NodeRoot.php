<?php 

require_once("Node.php");

class NodeRoot extends Node{
    public $listNode;

    function __construct(int $number){
        //super(number);
        parent::__construct($number);
        $aux = parent::getThis();
        $this->listNode = [];
        array_push($this->listNode,$aux);
    }

    function addList(Node $node){
        array_push($this->listNode,$node);
    }

    function getNodes(){
        
        $listSize = count($this->listNode);
        $nodeArray = [];
        for($i = 0; $i < $listSize; $i++){
            $nodeArray[$i] = $this->listNode[$i];
        }
        return $nodeArray;
    }

    function addNode(int $number){
        $newNode = parent::addNode($number);
        $this->addList($newNode);
    }
    

}