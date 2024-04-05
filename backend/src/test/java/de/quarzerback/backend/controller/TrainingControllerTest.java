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

    @Test
    void testGetAllTrainings() throws Exception {
        // Given
        Training training1 = new Training();
        training1.setId("1");
        training1.setDate(LocalDate.now());
        training1.setStartTime(LocalTime.now());
        training1.setEndTime(LocalTime.now().plusHours(1));
        training1.setSpecificCoachingPoints("Focus on passing drills");
        training1.setNeededMaterial("Cones, balls");

        Training training2 = new Training();
        training2.setId("2");
        training2.setDate(LocalDate.now().plusDays(1));
        training2.setStartTime(LocalTime.now().plusHours(2));
        training2.setEndTime(LocalTime.now().plusHours(3));
        training2.setSpecificCoachingPoints("Focus on defensive drills");
        training2.setNeededMaterial("Bibs, cones");

        when(trainingService.getAllTrainings()).thenReturn(java.util.List.of(training1, training2));

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/trainings"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value("2"));
    }

    @Test
    void testGetTrainingById() throws Exception {
        // Given
        Training training = new Training();
        training.setId("1");
        training.setDate(LocalDate.now());
        training.setStartTime(LocalTime.now());
        training.setEndTime(LocalTime.now().plusHours(1));
        training.setSpecificCoachingPoints("Focus on passing drills");
        training.setNeededMaterial("Cones, balls");

        when(trainingService.getTrainingById("1")).thenReturn(training);

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/trainings/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }

    @Test
    void testUpdateTraining() throws Exception {
        // Given
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setDate(LocalDate.now());
        trainingDto.setStartTime(LocalTime.now());
        trainingDto.setEndTime(LocalTime.now().plusHours(1));
        trainingDto.setSpecificCoachingPoints("Focus on passing drills");
        trainingDto.setNeededMaterial("Cones, balls");

        Training updatedTraining = new Training();
        updatedTraining.setId("1");
        updatedTraining.setDate(LocalDate.now());
        updatedTraining.setStartTime(LocalTime.now());
        updatedTraining.setEndTime(LocalTime.now().plusHours(1));
        updatedTraining.setSpecificCoachingPoints("Focus on passing drills");
        updatedTraining.setNeededMaterial("Cones, balls");

        when(trainingService.updateTraining("1", trainingDto)).thenReturn(updatedTraining);

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.put("/api/trainings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(trainingDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }

    @Test
    void testDeleteTraining() throws Exception {
        // Given
        when(trainingService.deleteTraining("1")).thenReturn("Training with ID: 1 deleted.");

        // When/Then
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/trainings/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Training with ID: 1 deleted."));
    }
}