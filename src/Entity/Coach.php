<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Coach
 *
 * @ORM\Table(name="coach")
 * @ORM\Entity
 */
class Coach
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_Coach", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCoach;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_Coach", type="string", length=255, nullable=false)
     */
    private $nomCoach;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom_Coach", type="string", length=255, nullable=false)
     */
    private $prenomCoach;

    /**
     * @var int
     *
     * @ORM\Column(name="Id_User", type="integer", nullable=false)
     */
    private $idUser;

    /**
     * @var int
     *
     * @ORM\Column(name="Cin_Coach", type="integer", nullable=false)
     */
    private $cinCoach;

    /**
     * @var string
     *
     * @ORM\Column(name="Email_Coach", type="string", length=255, nullable=false)
     */
    private $emailCoach;

    /**
     * @var float
     *
     * @ORM\Column(name="Prix_Hr", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixHr;


}
