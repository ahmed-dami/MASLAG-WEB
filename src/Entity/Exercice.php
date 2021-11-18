<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Exercice
 *
 * @ORM\Table(name="exercice")
 * @ORM\Entity
 */
class Exercice
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_Ex", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idEx;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_Ex", type="string", length=255, nullable=false)
     */
    private $nomEx;

    /**
     * @var string
     *
     * @ORM\Column(name="Cat_Ex", type="string", length=255, nullable=false)
     */
    private $catEx;

    /**
     * @var int
     *
     * @ORM\Column(name="Num_Ser", type="integer", nullable=false)
     */
    private $numSer;

    /**
     * @var int
     *
     * @ORM\Column(name="Num_Rep", type="integer", nullable=false)
     */
    private $numRep;


}
