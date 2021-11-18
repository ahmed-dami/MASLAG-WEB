<?php

namespace App\Controller;

use App\Entity\Category;
use App\Entity\Product;
use EasyCorp\Bundle\EasyAdminBundle\Config\MenuItem;
use phpDocumentor\Reflection\Types\Parent_;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class DachboardController extends AbstractController
{
    /**
     * @Route("/dachboard", name="dachboard")
     */
    public function index(): Response
    {
        return
            $this->render('dachboard/index.html.twig', [
                'controller_name' => 'DachboardController',]);
    }

    public function configurationMenuItems(): iterable
    {
        yield MenuItem::linkToDashboard('Dashboard', 'fa fa-home');
        yield MenuItem::linkToCrud('Category','fa fa-home',Category::class);
        yield MenuItem::linkToCrud('Product','fa fa-home',Product::class);
    }

}
