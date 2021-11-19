<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20211118200241 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE category2 (id INT AUTO_INCREMENT NOT NULL, labell1 VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE exercice ADD categorie_id INT DEFAULT NULL');
        $this->addSql('CREATE INDEX IDX_E418C74DBCF5E72D ON exercice (categorie_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE exercice DROP FOREIGN KEY FK_E418C74DBCF5E72D');
        $this->addSql('DROP TABLE category2');
        $this->addSql('DROP INDEX IDX_E418C74DBCF5E72D ON exercice');
        $this->addSql('ALTER TABLE exercice DROP categorie_id');
    }
}
