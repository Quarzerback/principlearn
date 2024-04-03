package de.quarzerback.backend.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.repository.TrainingRepo;
import org.junit.jupiter.api.Test;

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
}
