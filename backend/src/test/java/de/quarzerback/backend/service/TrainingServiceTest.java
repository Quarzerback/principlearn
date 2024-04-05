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

    private final TrainingRepo trainingRepo = mock(TrainingRepo.class);
    TrainingService trainingService = new TrainingService(trainingRepo);
    @Test
    void testAddTraining(){
        TrainingDto trainingDto = new TrainingDto();

        when(trainingRepo.save(any())).thenReturn(new Training());

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

        when(trainingRepo.findAll()).thenReturn(dummyTrainings);

        List<Training> result = trainingService.getAllTrainings();

        verify(trainingRepo).findAll();

        assertNotNull(result);
        assertEquals(dummyTrainings.size(), result.size());
    }

    @Test
    void testGetTrainingById(){
        Training training = new Training();
        training.setId("1");
        training.setDate(LocalDate.of(2024, 4, 6));
        training.setStartTime(LocalTime.of(9, 0));
        training.setEndTime(LocalTime.of(11, 0));
        training.setSpecificCoachingPoints("Improve passing skills");
        training.setNeededMaterial("Cones, balls");

        when(trainingRepo.findById("1")).thenReturn(java.util.Optional.of(training));

        Training result = trainingService.getTrainingById("1");

        verify(trainingRepo).findById("1");

        assertNotNull(result);
        assertEquals(training.getId(), result.getId());
    }

    @Test
    void testUpdateTraining() {
        String id = "1";
        Training training = new Training(id, LocalDate.of(2024, 4, 6), LocalTime.of(9, 0),
                LocalTime.of(11, 0), "Improve passing skills", "Cones, balls",
                null, null, null,  null);

        TrainingDto trainingDto = new TrainingDto(LocalDate.of(2024, 4, 6), LocalTime.of(10, 0),
                LocalTime.of(12, 0), "Improve passing skills", "Cones, balls, pylons",
                null, null, null,  null);

        Training expectedTraining = new Training(id, LocalDate.of(2024, 4, 6), LocalTime.of(10, 0),
                LocalTime.of(12, 0), "Improve passing skills", "Cones, balls, pylons",
                null, null, null,  null);

        when(trainingRepo.findById(id)).thenReturn(java.util.Optional.of(training));
        when(trainingRepo.save(any())).thenReturn(expectedTraining);

        Training result = trainingService.updateTraining(id, trainingDto);

        verify(trainingRepo).findById(id);
        verify(trainingRepo).save(any(Training.class));

        assertNotNull(result);
        assertEquals(expectedTraining, result);
    }

    @Test
    void testDeleteTraining(){
        Training training = new Training();
        training.setId("1");
        training.setDate(LocalDate.of(2024, 4, 6));
        training.setStartTime(LocalTime.of(9, 0));
        training.setEndTime(LocalTime.of(11, 0));
        training.setSpecificCoachingPoints("Improve passing skills");
        training.setNeededMaterial("Cones, balls");

        when(trainingRepo.findById("1")).thenReturn(java.util.Optional.of(training));

        String result = trainingService.deleteTraining("1");

        verify(trainingRepo).deleteById("1");

        assertNotNull(result);
    }
}
