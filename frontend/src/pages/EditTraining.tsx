import { TrainingData } from "../types/trainingData.ts";
import { useNavigate, useParams } from "react-router-dom";
import { ChangeEvent, FormEvent, useState } from "react";
import axios from "axios";
import TrainingInputForm from "../components/TrainingInputForm.tsx";

type EditTrainingProps = {
    trainings: TrainingData[];
    fetchData: () => void;
};

export default function EditTraining(props: EditTrainingProps) {
    const { id } = useParams();
    const navigate = useNavigate();
    const training = props.trainings.find(training => training.id === id);

    const [trainingData, setTrainingData] = useState<TrainingData>({
        date: training?.date ?? "",
        startTime: training?.startTime ?? "",
        endTime: training?.endTime ?? "",
        specificCoachingPoints: training?.specificCoachingPoints ?? "",
        neededMaterial: training?.neededMaterial ?? "",
        intensity: training?.intensity ?? null,
        pitch: training?.pitch ?? null
    });

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
            await axios.put(`/api/trainings/${id}`, trainingData);
            props.fetchData();
            alert('Training edited successfully!');
            navigate(`/training/${id}`);
        } catch (error) {
            console.error("Error editing training:", error);
            alert('Failed to edit training. Please try again.');
        }
    };

    const headlineName = "Edit Training";
    const buttonName = "Edit";

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