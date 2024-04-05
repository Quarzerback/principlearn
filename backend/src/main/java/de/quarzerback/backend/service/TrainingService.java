package de.quarzerback.backend.service;

import de.quarzerback.backend.exceptions.TrainingNotFoundException;
import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.repository.TrainingRepo;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepo trainingRepository;

    public Training addTraining(TrainingDto trainingDto) {
        Training training = new Training(trainingDto);
        return trainingRepository.save(training);
    }

    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    public Training getTrainingById(String id) {
        return trainingRepository.findById(id).orElseThrow();
    }

    public Training updateTraining(String id, TrainingDto trainingDto) {
        Optional<Training> optionalTraining = trainingRepository.findById(id);
        if (optionalTraining.isPresent()) {
            Training updatedTraining = new Training(trainingDto);
            updatedTraining.setId(id);
            return trainingRepository.save(updatedTraining);
                   } else {
            throw new TrainingNotFoundException("Training with ID " + id + " not found.");
        }
    }

    public String deleteTraining(String id) {
        trainingRepository.deleteById(id);
        return "Training with ID: " + id + " deleted.";
    }
}