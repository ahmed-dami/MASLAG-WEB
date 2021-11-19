<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20211117211944 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE planning ADD nom_r_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE planning ADD CONSTRAINT FK_D499BFF68BA26147 FOREIGN KEY (nom_r_id) REFERENCES reservation (id)');
        $this->addSql('CREATE INDEX IDX_D499BFF68BA26147 ON planning (nom_r_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE planning DROP FOREIGN KEY FK_D499BFF68BA26147');
        $this->addSql('DROP INDEX IDX_D499BFF68BA26147 ON planning');
        $this->addSql('ALTER TABLE planning DROP nom_r_id');
    }
}
