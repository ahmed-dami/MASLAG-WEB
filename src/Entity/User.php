<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * User
 *
 * @ORM\Table(name="user")
 * @ORM\Entity
 */
class User
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_User", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idUser;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_User", type="string", length=255, nullable=false)
     */
    private $nomUser;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom_User", type="string", length=255, nullable=false)
     */
    private $prenomUser;

    /**
     * @var string
     *
     * @ORM\Column(name="Email_User", type="string", length=255, nullable=false)
     */
    private $emailUser;

    /**
     * @var int
     *
     * @ORM\Column(name="Cin_User", type="integer", nullable=false)
     */
    private $cinUser;

    /**
     * @var int
     *
     * @ORM\Column(name="Num_User", type="integer", nullable=false)
     */
    private $numUser;

    /**
     * @var string
     *
     * @ORM\Column(name="Adresse_User", type="string", length=255, nullable=false)
     */
    private $adresseUser;

    /**
     * @var string
     *
     * @ORM\Column(name="Date_N_User", type="string", length=255, nullable=false)
     */
    private $dateNUser;


}
