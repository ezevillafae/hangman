# Caso de uso: Session Default Creator

## Responsabilidad
La clase [SessionDefaultCreator]() se encarga de crear una nueva [Session]() indicando nombre de usuario y un [Word](), 
el cual es seleccionado mediante [DomainWordRandomPicker](), finalmente la sesión es guardada en [SessionRepository]()

## Solución técnica

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant SessionDefaulCreator
    participant DomainWordPicker
    SessionDefaulCreator ->> DomainWordPicker: pick(difficult, language)
    DomainWordPicker -->> SessionDefaulCreator: Word
    SessionDefaulCreator ->> SessionRepository: save(session)
````

### Dependencias
- [DomainWordRandomPicker]()
- [SessionRepository]()