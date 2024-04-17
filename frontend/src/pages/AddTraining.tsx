import { useState, ChangeEvent, FormEvent } from "react";
import { addTraining } from "../utils/addTraining";
import { TrainingData } from "../types/trainingData";
import TrainingInputForm from "../components/TrainingInputForm";

type AddTrainingProps = {
    fetchData: () => void;
};

export default function AddTraining(props: Readonly<AddTrainingProps>) {
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

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
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
            props.fetchData();
        } catch (error) {
            console.error('Error while sending training data:', error);
            alert('Failed to create training. Please try again.');
        }
    };

    const headlineName = "Add Training";
    const buttonName = "Create Training";

    return (
        <TrainingInputForm
            trainingData={trainingData}
            handleChange={handleChange}
            handleSubmit={handleSubmit}
            headlineName={headlineName}
            buttonName={buttonName}
        />
    );
}
