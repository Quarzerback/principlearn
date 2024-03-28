package de.quarzerback.backend.service;

import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.repository.TrainingRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepo trainingRepository;

    public Training addTraining(TrainingDto trainingDto) {
        Training training = new Training();
        BeanUtils.copyProperties(trainingDto, training);

        return trainingRepository.save(training);
    }
}