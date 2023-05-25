package Service;

import org.example.Exceptions.models.BasicException;
import org.example.adapter.VacancyToDtoAdapter;
import org.example.model.Company;
import org.example.model.Dto.VacancyDto;
import org.example.model.Intern;
import org.example.model.Vacancy;
import org.example.repository.CompanyRepository;
import org.example.repository.InternRepository;
import org.example.repository.VacancyRepository;
import org.example.service.CompanyService;
import org.example.service.impl.CompanyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private VacancyRepository vacancyRepository;
    @Mock
    private VacancyToDtoAdapter vacancyToDtoAdapter;
    @Mock
    private InternRepository internRepository;

    @Mock
    private Company company;
    @Mock
    private Vacancy vacancy;

    @InjectMocks
    private CompanyServiceImpl companyServiceImpl;

    @Test
    public void testGetVacancies() {
        when(companyRepository.findById(anyLong())).thenReturn(Optional.of(company));
        when(vacancyRepository.findByCompanyId(anyLong())).thenReturn(Arrays.asList(vacancy));
        when(vacancyToDtoAdapter.convert(vacancy)).thenReturn(new VacancyDto());

        assertNotNull(companyServiceImpl.getVacancies(1L));
    }

    @Test
    public void testGetVacanciesThrowsException() {
        when(companyRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(BasicException.class, () -> companyServiceImpl.getVacancies(1L));
    }

    @Test
    public void testGetInternsByVacancy() {
        when(companyRepository.findById(anyLong())).thenReturn(Optional.of(company));
        when(vacancyRepository.findById(anyLong())).thenReturn(Optional.of(vacancy));
        when(vacancy.getInternIds()).thenReturn(Arrays.asList("1"));
        when(internRepository.findAllById(any())).thenReturn(Arrays.asList(new Intern()));

        assertNotNull(companyServiceImpl.getInternsByVacancy(1L, 1L));
    }

    @Test
    public void testGetInternsByVacancyThrowsException() {
        when(companyRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(BasicException.class, () -> companyServiceImpl.getInternsByVacancy(1L, 1L));
    }
}

