<?php

namespace App\Form;

use App\Entity\Planning;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;

class PlanningType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom', TextType::class  , array('attr' => array('class' => 'form-control')))
            ->add('prenom', TextType::class, array('attr' => array('class' => 'form-control')))
            ->add('cin', TextType::class, array('attr' => array('class' => 'form-control')))
            ->add('telephone', TextType::class, array('attr' => array('class' => 'form-control')))
            ->add('email', TextType::class, array('attr' => array('class' => 'form-control')))
            ->add('date_p')
            ->add('temps_p')
            ->add('category')
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Planning::class,
        ]);
    }
}
