<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Evenement
 *
 * @ORM\Table(name="evenement")
 * @ORM\Entity
 */
class Evenement
{
    /**
     * @var int
     *
     * @ORM\Column(name="ID_Event", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idEvent;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_Event", type="string", length=255, nullable=false)
     */
    private $nomEvent;

    /**
     * @var string
     *
     * @ORM\Column(name="Adresse_Event", type="string", length=255, nullable=false)
     */
    private $adresseEvent;

    /**
     * @var int
     *
     * @ORM\Column(name="Num_Event", type="integer", nullable=false)
     */
    private $numEvent;

    /**
     * @var float
     *
     * @ORM\Column(name="Prix_P", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixP;

    /**
     * @var string
     *
     * @ORM\Column(name="Date_Debut", type="string", length=255, nullable=false)
     */
    private $dateDebut;

    /**
     * @var string
     *
     * @ORM\Column(name="Date_Fin", type="string", length=255, nullable=false)
     */
    private $dateFin;


}
