<?php

namespace App\Entity;

use App\Repository\ProductRepository;
use Doctrine\ORM\Mapping as ORM;
use Vich\UploaderBundle\Mapping\Annotation as Vich;
use Symfony\Component\Validator\Constraints as Assert;



/**
 * @ORM\Entity(repositoryClass=ProductRepository::class)
 * @Vich\Uploadable
 */
class Product
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotNull
     */
    private $Nom_p;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotNull
     */
    private $Marque_p;

    /**
     * @ORM\Column(type="integer")
     * @Assert\NotNull
     * @Assert\Positive
     */
    private $Prix_p;

    /**
     * @ORM\Column(type="integer")
     * @Assert\NotNull
     * @Assert\Positive
     */
    private $Quantite_p;

    /**
     * @ORM\Column(type="string", length=255)
     * @Assert\NotBlank(message="please upload image")
     * @Assert\File(mimeTypes={"image/jpeg"})
     * @Assert\NotNull
     */
    private $IMG_p;

    /**
     * @ORM\ManyToOne(targetEntity=Category::class, inversedBy="products")
     * @ORM\JoinColumn(nullable=false)
     * @Assert\NotNull
     */
    private $categorie;



    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomP(): ?string
    {
        return $this->Nom_p;
    }

    public function setNomP(string $Nom_p): self
    {
        $this->Nom_p = $Nom_p;

        return $this;
    }

    public function getMarqueP(): ?string
    {
        return $this->Marque_p;
    }

    public function setMarqueP(string $Marque_p): self
    {
        $this->Marque_p = $Marque_p;

        return $this;
    }

    public function getPrixP(): ?int
    {
        return $this->Prix_p;
    }

    public function setPrixP(int $Prix_p): self
    {
        $this->Prix_p = $Prix_p;

        return $this;
    }

    public function getQuantiteP(): ?int
    {
        return $this->Quantite_p;
    }

    public function setQuantiteP(int $Quantite_p): self
    {
        $this->Quantite_p = $Quantite_p;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getIMGP():?string
    {
        return $this->IMG_p;
    }

    /**
     * @param mixed $IMG_p
     */
    public function setIMGP($IMG_p): void
    {
        $this->IMG_p = $IMG_p;

    }


    public function getCategorie(): ?Category
    {
        return $this->categorie;
    }

    public function setCategorie(?Category $categorie): self
    {
        $this->categorie = $categorie;

        return $this;
    }

}
