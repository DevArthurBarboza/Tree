<?php 
declare(strict_types=1);
require_once("NodeRoot.php");
error_reporting(E_ALL);

        echo("Informe um valor referente ao nó raiz : \n ");
        $value = 5;
        $rootNode = new NodeRoot($value);
        $rootNode->addNode(3);
        $rootNode->addNode(9);
        
        $rootNode->addNode(-1);
        $rootNode->addNode(4);
        $rootNode->addNode(-6);
        $rootNode->addNode(2);
        $nodeArray = $rootNode->getNodes();
        for($i =0; $i < count($nodeArray); $i++){
            echo("Node " . $nodeArray[$i]->id . " valor: " . $nodeArray[$i]->value) . "\n ";
        }
        die();
        

        