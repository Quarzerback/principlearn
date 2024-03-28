import { useState, ChangeEvent, FormEvent } from "react";
import { Intensity, Pitch } from "../types/enums.ts";
import { addTraining } from "../utils/addTraining.ts"
import { TrainingFormData } from "../types/training.ts";

export default function AddTraining() {
    const initialTrainingData: TrainingFormData = {
        date: '',
        startTime: '',
        endTime: '',
        specificCoachingPoints: '',
        neededMaterial: '',
        intensity: null,
        pitch: null
    };

    const [trainingData, setTrainingData] = useState<TrainingFormData>(initialTrainingData);

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
            await addTraining(trainingData);
            setTrainingData(initialTrainingData);
        } catch (error) {
            console.error('Error while sending training data:', error);
            }
    };

    return (
        <div>
            <h2>Add Training</h2>
            <form onSubmit={handleSubmit}>
                <label>Date:</label>
                <input type="date" name="date" value={trainingData.date} onChange={handleChange} required/><br/>

                <label>Start Time:</label>
                <input type="time" name="startTime" value={trainingData.startTime} onChange={handleChange}
                       required/><br/>

                <label>End Time:</label>
                <input type="time" name="endTime" value={trainingData.endTime} onChange={handleChange} required/><br/>

                <label>Specific Coaching Points:</label>
                <input type="text" name="specificCoachingPoints" value={trainingData.specificCoachingPoints}
                       onChange={handleChange}/><br/>

                <label>Needed Material:</label>
                <input type="text" name="neededMaterial" value={trainingData.neededMaterial}
                       onChange={handleChange}/><br/>

                <select name="intensity" value={trainingData.intensity || ''} onChange={handleChange} required>
                    <option value="">Select Intensity</option>
                    {Object.values(Intensity)
                        .filter(value => typeof value === 'number')
                        .map((value) => (
                            <option key={value} value={value}>{value}</option>
                        ))}
                </select><br/>
                <select name="pitch" value={trainingData.pitch || ''} onChange={handleChange} required>
                    <option value="">Select Pitch</option>
                    {Object.values(Pitch).map((value) => (
                        <option key={value} value={value}>{value}</option>
                    ))}
                </select><br/>


                <button type="submit">Submit</button>
            </form>
        </div>
    );
}
