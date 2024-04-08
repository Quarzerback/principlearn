import axios from 'axios';
import { TrainingData } from '../types/trainingData.ts';

export const addTraining = async (trainingData: TrainingData): Promise<void> => {
    try {
        await axios.post('/api/trainings', trainingData);
        alert('Training data sent successfully!');
    } catch (error) {
        if (error instanceof Error) {
            alert('Error while sending training data: ' + error.message);
            throw new Error('Failed to add training');
        } else {
            alert('Unknown error occurred while sending training data');
            throw error;
        }
    }
};