# Caso de uso: Domain word random picker

## Responsabilidad
La responsabilidad de la clase [DomainWordRandomPicker]() es elegir una [Word]() aleatoria alojada en un [WordRepository](). 


## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant DomainWordRandomPicker
    participant WordRepository
    
    DomainWordRandomPicker ->> WordRepository: busca por dificultad y lenguaje
    WordRepository -->> DomainWordRandomPicker: Conjunto de Word 
    Note left of DomainWordRandomPicker: Luego se elije una <br/> Word aleatoria 
````

### Dependencias
- [WordRepository]()