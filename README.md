Presentatie:
- Herhalen vorige les (@Stereotypes & Dependency Injection). Ze moeten het ons vertellen.
  (Stijn)
- Wat doet een database? Raakvlak met de vorige les? (Stefan)
  - Profielen (DEV & PROD) -> configuratie als datastore
  - Database object storage: Je komt best lang weg met een json key value
  - Database SQL: Gestructureerde data. Zoeken, transactions, schema
- Microservice architectuur: 12factor. (Elke microservice heeft eigen database)
  (Stijn)
- Aan de slag: postgres (Stijn)
  - docker-compose draaien en in PGAdmin komen
  - Simpele tabel inrichten: UUID, String, comparable. Paar entities

Presentatie 2:

- JPA wat is het (Stefan)
  - Spring boot JPA dependency
  - JPARepository
  - ORM (DAO, Entity manager)
  - Entity (waarschijnlijke annotaties)
- Aan de slag: (Stijn)
  - applicatie test opzet
  - Koppelen met Postgress

Bonus:
- Presentatie liquibase door ons
- Liquibase migrate, veranderen tabel naam



Inrichten REPO
- Docker-Compose script
- Spring boot project
- GEEN:  JPA, REPO
- WEL: Spring boot service, repo zonder JPA
- Liquibase geconfigureerd: DDL Validate, CSV dataset
- Test voor dataset validatie


Vragen?
- Ultimate licentie voor database?
- Docker-Desktop licentie?
