package de.quarzerback.backend.controller;

import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}