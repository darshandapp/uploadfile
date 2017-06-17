DROP TABLE IF EXISTS file;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE file(
  ID SERIAL PRIMARY KEY,
  file_name VARCHAR(100) NOT NULL,
  file_path varchar(200) NOT NULL,
  size bigint DEFAULT NULL,
  uploaded_time DATE DEFAULT NULL
);