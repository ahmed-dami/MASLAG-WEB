<?php

namespace App\Repository;

use App\Entity\Ctegory;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Ctegory|null find($id, $lockMode = null, $lockVersion = null)
 * @method Ctegory|null findOneBy(array $criteria, array $orderBy = null)
 * @method Ctegory[]    findAll()
 * @method Ctegory[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class CtegoryRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Ctegory::class);
    }

    // /**
    //  * @return Ctegory[] Returns an array of Ctegory objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('c.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Ctegory
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
