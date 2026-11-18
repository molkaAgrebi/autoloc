# Autoloc

API REST de gestion d'une agence de location de véhicules, développée avec Spring Boot.

## Technologies

- Java 17
- Spring Boot (Web MVC, Data JPA, Validation)
- MySQL
- Lombok
- Swagger / OpenAPI (springdoc)

## Modèle de données

| Entité | Relations |
|---|---|
| Agence | possède des Véhicules et des Employés |
| Vehicule | appartient à une Agence, possède des Équipements, subit des Maintenances |
| Employe | appartient à une Agence |
| Equipement | installé sur des Véhicules (`@ManyToMany`) |
| Client | effectue des Réservations |
| Reservation | lie un Client à un Véhicule, génère un Contrat |
| Contrat | réglé par des Paiements |
| Maintenance | concerne un Véhicule |
| Paiement | rattaché à un Contrat |

## Lancer le projet

1. Démarrer MySQL sur `localhost:3306` (la base `autoloc_db` est créée automatiquement).
2. Lancer l'application :

   ```bash
   ./mvnw spring-boot:run
   ```

3. L'API est disponible sur `http://localhost:8089/autoloc`.

## Endpoints d'affectation

| Méthode | URL | Description |
|---|---|---|
| PUT | `/api/employe/desaffecterEmploye/{idEmploye}` | Retire l'employé de son agence |
| PUT | `/api/employe/affecterEmploye/{idEmploye}/{idAgence}` | Affecte l'employé à une agence |
| PUT | `/api/vehicule/affecterVehicule/{idVehicule}/{idAgence}` | Rattache un véhicule à une agence |
| PUT | `/api/vehicule/affecterEquipement/{idVehicule}/{idEquipement}` | Installe un équipement sur un véhicule |
| PUT | `/api/vehicule/desaffecterEquipement/{idVehicule}/{idEquipement}` | Retire un équipement d'un véhicule |

Chaque entité dispose aussi des opérations CRUD (`add`, `update`, `delete`, `getAll`, `getById`).
