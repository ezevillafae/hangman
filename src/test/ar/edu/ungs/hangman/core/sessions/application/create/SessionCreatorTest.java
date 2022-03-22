package ar.edu.ungs.hangman.core.sessions.application.create;

import ar.edu.ungs.hangman.core.sessions.domain.Session;
import ar.edu.ungs.hangman.core.sessions.domain.SessionMother;
import ar.edu.ungs.hangman.core.sessions.domain.SessionRepository;
import ar.edu.ungs.hangman.core.words.domain.Difficult;
import ar.edu.ungs.hangman.core.words.domain.DomainWordRandomPicker;
import ar.edu.ungs.hangman.core.words.domain.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SessionCreatorTest {
    private SessionCreator creator;

    private SessionRepository repository;
    private DomainWordRandomPicker domainWordRandomPicker;

    @BeforeEach
    void setUp() {
        this.repository = mock(SessionRepository.class);
        this.domainWordRandomPicker = mock(DomainWordRandomPicker.class);

        this.creator = new SessionCreator(repository, domainWordRandomPicker);
    }

    @Test
    void should_create_session() {
        Session expected = SessionMother.random();
        Language language = expected.word().language();
        Difficult difficult = expected.word().difficult();

        when(domainWordRandomPicker.pick(difficult, language)).thenReturn(expected.word());

        creator.create(expected.user(), difficult, language);

        verify(repository, atLeastOnce()).save(expected);
    }
}