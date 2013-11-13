CREATE DATABASE `cancer_survey` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
CREATE TABLE `survey_responses` (
  `survey_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `response_number` int(11) NOT NULL,
  PRIMARY KEY (`survey_id`,`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
