# Caso de uso: Session Defaul Creator

## Responsabilidad
La clase [SessionDefaultCreator]() se encarga de crear una nueva [Session]() indicando nombre de usuario y un [Word](), 
el cual es seleccionado mediante [DomainWordRandomPicker](), finalmente la sesión es guardada en [SessionRepository]()

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant SessionDefaulCreator
    participant DomainWordPiker
    DomainWordRandomPicker ->>  SessionDefaulCreator: Word word
    SessionDefaulCreator ->> SessionRepository: Session session
````

### Dependencias
- [DomainWordRandomPicker]()
- [SessionRepository]()