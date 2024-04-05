import {TrainingData} from "../types/trainingData.ts";
import {useNavigate, useParams} from "react-router-dom";
import {ChangeEvent, FormEvent, useState} from "react";
import axios from "axios";
import TrainingInputForm from "../components/TrainingInputForm.tsx";

export type Props = {
    trainings: TrainingData[];
    fetchData: () => void;
}
export default function EditTraining(props : Props) {
    const params = useParams();
    const navigate = useNavigate();
    const training = props.trainings.find(training => training.id === params.id);
    const initialTrainingData: TrainingData = {
        date: training?.date ?? "",
        startTime: training?.startTime ?? "",
        endTime: training?.endTime ?? "",
        specificCoachingPoints: training?.specificCoachingPoints ?? "",
        neededMaterial: training?.neededMaterial ?? "",
        intensity: training?.intensity ?? null,
        pitch: training?.pitch ?? null
    };

    const [trainingData, setTrainingData] = useState<TrainingData>(initialTrainingData);

    const handleChange = (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        const { name, value } = e.target;
        setTrainingData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };
    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        try {
            await axios.put('/api/trainings/' + training?.id, trainingData)
            .then(props.fetchData);
            alert('Training edited successfully!');
            navigate('/training/' + training?.id);
        } catch (error) {
            if (error instanceof Error) {
                alert('Error while sending training data: ' + error.message);
                throw new Error('Failed to edit training.');
            } else {
                alert('Unknown error occurred while sending training data.');
                throw error;
            }
        }


    };

    const headlineName = "Edit Training";
    const buttonName = "Edit";
    return (
        <TrainingInputForm trainingData={trainingData} handleChange={handleChange} handleSubmit={handleSubmit}
                           headlineName={headlineName} buttonName={buttonName}/>
    );
}