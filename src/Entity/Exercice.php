<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

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
     * @var int
     *
     * @ORM\Column(name="Num_Ser", type="integer", nullable=false)
     * @Assert\Positive
     */
    private $numSer;

    /**
     * @var int
     *
     * @ORM\Column(name="Num_Rep", type="integer", nullable=false)
     * @Assert\Positive
     */
    private $numRep;

    /**
     * @ORM\ManyToOne(targetEntity=Category2::class, inversedBy="exercices")
     */
    private $categorie;



    /**
     * @return int
     */
    public function getIdEx(): ?int
    {
        return $this->idEx;
    }

    /**
     * @param int $idEx
     */
    public function setIdEx(int $idEx): void
    {
        $this->idEx = $idEx;
    }

    /**
     * @return string
     */
    public function getNomEx(): ?string
    {
        return $this->nomEx;
    }

    /**
     * @param string $nomEx
     */
    public function setNomEx(string $nomEx): void
    {
        $this->nomEx = $nomEx;
    }



    /**
     * @return int
     */
    public function getNumSer(): ?int
    {
        return $this->numSer;
    }

    /**
     * @param int $numSer
     */
    public function setNumSer(int $numSer): void
    {
        $this->numSer = $numSer;
    }

    /**
     * @return int
     */
    public function getNumRep(): ?int
    {
        return $this->numRep;
    }

    /**
     * @param int $numRep
     */
    public function setNumRep(int $numRep): void
    {
        $this->numRep = $numRep;
    }

    public function getCategorie(): ?Category2
    {
        return $this->categorie;
    }

    public function setCategorie(?Category2 $categorie): self
    {
        $this->categorie = $categorie;

        return $this;
    }






}
