<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Command
 *
 * @ORM\Table(name="command")
 * @ORM\Entity
 */
class Command
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_Com", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idCom;

    /**
     * @var int
     *
     * @ORM\Column(name="Id_Produit", type="integer", nullable=false)
     */
    private $idProduit;

    /**
     * @var int
     *
     * @ORM\Column(name="Id_User", type="integer", nullable=false)
     */
    private $idUser;

    /**
     * @var float
     *
     * @ORM\Column(name="Prix_Produit", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixProduit;

    /**
     * @var string
     *
     * @ORM\Column(name="Date_Com", type="string", length=255, nullable=false)
     */
    private $dateCom;

    /**
     * @var int
     *
     * @ORM\Column(name="quantite", type="integer", nullable=false)
     */
    private $quantite;

    /**
     * @var string
     *
     * @ORM\Column(name="Categorie_Produit", type="string", length=255, nullable=false)
     */
    private $categorieProduit;

    /**
     * @var string
     *
     * @ORM\Column(name="Marque_Produit", type="string", length=255, nullable=false)
     */
    private $marqueProduit;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_Produit", type="string", length=255, nullable=false)
     */
    private $nomProduit;


}
