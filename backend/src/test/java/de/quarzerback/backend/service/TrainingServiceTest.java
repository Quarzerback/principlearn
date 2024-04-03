package de.quarzerback.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.repository.TrainingRepo;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class TrainingServiceTest {

    @Test
    void testAddTraining(){
        TrainingDto trainingDto = new TrainingDto();
        TrainingRepo trainingRepo = mock(TrainingRepo.class);

        when(trainingRepo.save(any())).thenReturn(new Training());

        TrainingService trainingService = new TrainingService(trainingRepo);

        Training result = trainingService.addTraining(trainingDto);

        assertNotNull(result);
    }

    @Test
    void testGetTraining(){
        List<Training> dummyTrainings = new ArrayList<>();

        Training training1 = new Training();
        training1.setId("1");
        training1.setDate(LocalDate.of(2024, 4, 6));
        training1.setStartTime(LocalTime.of(9, 0));
        training1.setEndTime(LocalTime.of(11, 0));
        training1.setSpecificCoachingPoints("Improve passing skills");
        training1.setNeededMaterial("Cones, balls");
        dummyTrainings.add(training1);

        Training training2 = new Training();
        training2.setId("2");
        training2.setDate(LocalDate.of(2024, 4, 7));
        training2.setStartTime(LocalTime.of(14, 0));
        training2.setEndTime(LocalTime.of(16, 0));
        training2.setSpecificCoachingPoints("Work on defensive strategies");
        training2.setNeededMaterial("Bibs, cones");
        dummyTrainings.add(training2);

        TrainingRepo trainingRepo = mock(TrainingRepo.class);
        when(trainingRepo.findAll()).thenReturn(dummyTrainings);

        TrainingService trainingService = new TrainingService(trainingRepo);

        List<Training> result = trainingService.getAllTrainings();

        verify(trainingRepo).findAll();

        assertNotNull(result);
        assertEquals(dummyTrainings.size(), result.size());
    }
}
