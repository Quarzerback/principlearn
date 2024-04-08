package de.quarzerback.backend.controller;

import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService trainingService;
    @PostMapping
    public ResponseEntity<Training> addTraining(@RequestBody TrainingDto training) {
        Training addedTraining = trainingService.addTraining(training);
        return new ResponseEntity<>(addedTraining, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Training>> getAllTrainings() {
        List<Training> trainings = trainingService.getAllTrainings();
        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable String id) {
        Training training = trainingService.getTrainingById(id);
        return new ResponseEntity<>(training, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Training> updateTraining(@PathVariable String id, @RequestBody TrainingDto training) {
        Training updatedTraining = trainingService.updateTraining(id, training);
        return new ResponseEntity<>(updatedTraining, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTraining(@PathVariable String id) {
        String message = trainingService.deleteTraining(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}