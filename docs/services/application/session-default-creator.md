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
    SessionDefaulCreator ->> DomainWordPicker: Dificult dificult, Language language
    DomainWordPicker ->> SessionDefaulCreator: Word word
    SessionDefaulCreator ->> Session: User name, Word word
    SessionDefaulCreator ->> SessionRepository: Session session
````

### Dependencias
- [DomainWordRandomPicker]()
- [SessionRepository]()