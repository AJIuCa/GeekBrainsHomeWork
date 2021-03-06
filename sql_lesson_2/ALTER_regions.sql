ALTER TABLE `geodata`.`_regions` 
DROP COLUMN `title_cz`,
DROP COLUMN `title_lv`,
DROP COLUMN `title_lt`,
DROP COLUMN `title_ja`,
DROP COLUMN `title_pl`,
DROP COLUMN `title_it`,
DROP COLUMN `title_fr`,
DROP COLUMN `title_de`,
DROP COLUMN `title_pt`,
DROP COLUMN `title_es`,
DROP COLUMN `title_be`,
DROP COLUMN `title_ua`,
DROP COLUMN `title_ru`,
CHANGE COLUMN `region_id` `id` INT NOT NULL AUTO_INCREMENT ,
CHANGE COLUMN `title_en` `title` VARCHAR(150) NOT NULL ,
ADD PRIMARY KEY (`id`),
ADD INDEX `fk_regions_country_id_idx` (`country_id` ASC) INVISIBLE,
ADD INDEX `index3` (`title` ASC) VISIBLE;
;
ALTER TABLE `geodata`.`_regions` 
ADD CONSTRAINT `fk_regions_country_id`
  FOREIGN KEY (`country_id`)
  REFERENCES `geodata`.`_countries` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;