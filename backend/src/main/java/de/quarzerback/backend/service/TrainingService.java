package de.quarzerback.backend.service;

import de.quarzerback.backend.model.Training;
import de.quarzerback.backend.model.dtos.TrainingDto;
import de.quarzerback.backend.repository.TrainingRepo;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepo trainingRepository;

    public Training addTraining(TrainingDto trainingDto) {
        Training training = new Training();

        training.setDate(trainingDto.getDate());
        training.setStartTime(trainingDto.getStartTime());
        training.setEndTime(trainingDto.getEndTime());
        training.setSpecificCoachingPoints(trainingDto.getSpecificCoachingPoints());
        training.setNeededMaterial(trainingDto.getNeededMaterial());
        training.setIntensity(trainingDto.getIntensity());
        training.setPitch(trainingDto.getPitch());
        training.setParticipants(trainingDto.getParticipants());
        training.setSections(trainingDto.getSections());

        return trainingRepository.save(training);
    }
}