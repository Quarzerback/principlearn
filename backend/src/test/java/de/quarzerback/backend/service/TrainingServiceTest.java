package de.quarzerback.backend.service;
import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.repository.TrainingRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RequiredArgsConstructor
public class TrainingServiceTest {

    private final TrainingService trainingService;
    private final TrainingRepo trainingRepo;

    @Test
    public void testAddTraining() {
        // Given
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setDate(LocalDate.now());
        trainingDto.setStartTime(LocalTime.now());
        trainingDto.setEndTime(LocalTime.now().plusHours(1));
        trainingDto.setSpecificCoachingPoints("Focus on passing drills");
        trainingDto.setNeededMaterial("Cones, balls");

        // When
        Training addedTraining = trainingService.addTraining(trainingDto);

        // Then
        assertNotNull(addedTraining.getId());
        assertEquals(trainingDto.getDate(), addedTraining.getDate());
        assertEquals(trainingDto.getStartTime(), addedTraining.getStartTime());
        assertEquals(trainingDto.getEndTime(), addedTraining.getEndTime());
        assertEquals(trainingDto.getSpecificCoachingPoints(), addedTraining.getSpecificCoachingPoints());
        assertEquals(trainingDto.getNeededMaterial(), addedTraining.getNeededMaterial());
    }
}
