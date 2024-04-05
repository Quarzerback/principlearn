import { useState, ChangeEvent, FormEvent } from "react";
import { addTraining } from "../utils/addTraining.ts"
import { TrainingData } from "../types/trainingData.ts";
import TrainingInputForm from "../components/TrainingInputForm.tsx";

export default function AddTraining() {
    const initialTrainingData: TrainingData = {
        date: '',
        startTime: '',
        endTime: '',
        specificCoachingPoints: '',
        neededMaterial: '',
        intensity: null,
        pitch: null
    };

    const [trainingData, setTrainingData] = useState<TrainingData>(initialTrainingData);

    const handleChange = (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const {name, value} = e.target;
        setTrainingData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        try {
            await addTraining(trainingData);
            setTrainingData(initialTrainingData);
        } catch (error) {
            console.error('Error while sending training data:', error);
        }
    };

    const headlineName = "Add Training";
    const buttonName = "Create Training";
    return (
        <TrainingInputForm trainingData={trainingData} handleChange={handleChange} handleSubmit={handleSubmit}
                           headlineName={headlineName} buttonName={buttonName}/>
    );
}
