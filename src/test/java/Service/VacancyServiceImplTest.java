package Service;

import org.example.Exceptions.models.BasicException;
import org.example.adapter.VacancyToDtoAdapter;
import org.example.filter.VacancyFilter;
import org.example.handlers.CompanyHandler;
import org.example.handlers.Impl.VacancyFactoryHandler;
import org.example.model.Dto.VacancyDto;
import org.example.model.Vacancy;
import org.example.repository.VacancyRepository;
import org.example.service.VacancyService;
import org.example.service.impl.VacancyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class VacancyServiceImplTest {

    @Mock
    private VacancyFactoryHandler vacancyFactoryHandler;
    @Mock
    private VacancyRepository vacancyRepository;
    @Mock
    private VacancyToDtoAdapter vacancyToDtoAdapter;
    @Mock
    private CompanyHandler companyHandler;
    @Mock
    private Vacancy vacancy;

    @InjectMocks
    private VacancyServiceImpl vacancyServiceImpl;

    @Test
    public void testCreateVacancy() {
        when(vacancyFactoryHandler.getInstance(vacancy)).thenReturn(companyHandler);
        when(vacancy.getOffers()).thenReturn("some offers");
        when(companyHandler.checkSalary(any())).thenReturn(false);
        when(companyHandler.checkSpeciality(any())).thenReturn(false);
        when(vacancyRepository.save(vacancy)).thenReturn(vacancy);
        when(vacancyToDtoAdapter.convert(vacancy)).thenReturn(new VacancyDto());

        assertNotNull(vacancyServiceImpl.create(vacancy));
    }

    @Test
    public void testGetVacancy() {
        when(vacancyRepository.findById(anyLong())).thenReturn(Optional.of(vacancy));
        when(vacancyToDtoAdapter.convert(vacancy)).thenReturn(new VacancyDto());

        assertNotNull(vacancyServiceImpl.getVacancy(1L));
    }

    @Test
    public void testGetVacancyThrowsException() {
        when(vacancyRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(BasicException.class, () -> vacancyServiceImpl.getVacancy(1L));
    }

    @Test
    public void testTakeVacancyThrowsException() {
        when(vacancyRepository.findById(anyLong())).thenReturn(Optional.of(vacancy));
        when(vacancy.getInternIds()).thenReturn(Arrays.asList("1", "2"));

        assertThrows(BasicException.class, () -> vacancyServiceImpl.takeVacancy(1L, 2L));
    }

    // Repeat similar pattern for the rest of the methods...
}
