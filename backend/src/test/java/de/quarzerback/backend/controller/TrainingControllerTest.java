package de.quarzerback.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.service.TrainingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TrainingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrainingService trainingService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddTraining() throws Exception {
        // Given
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setDate(LocalDate.now());
        trainingDto.setStartTime(LocalTime.now());
        trainingDto.setEndTime(LocalTime.now().plusHours(1));
        trainingDto.setSpecificCoachingPoints("Focus on passing drills");
        trainingDto.setNeededMaterial("Cones, balls");

        Training addedTraining = new Training();
        addedTraining.setId("1");
        when(trainingService.addTraining(any(TrainingDto.class))).thenReturn(addedTraining);

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/trainings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(trainingDto)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
}