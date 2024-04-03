import { useState, ChangeEvent, FormEvent } from "react";
import { Intensity, Pitch } from "../types/enums.ts";
import { addTraining } from "../utils/addTraining.ts"
import { TrainingData } from "../types/trainingData.ts";

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
        const { name, value } = e.target;
        setTrainingData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    console.log(trainingData);
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
                <label htmlFor="date">Date:</label>
                <input type="date" id="date" name="date" value={trainingData.date} onChange={handleChange}
                       required/><br/>

                <label htmlFor="startTime">Start Time:</label>
                <input type="time" id="startTime" name="startTime" value={trainingData.startTime}
                       onChange={handleChange} required/><br/>

                <label htmlFor="endTime">End Time:</label>
                <input type="time" id="endTime" name="endTime" value={trainingData.endTime} onChange={handleChange}
                       required/><br/>

                <label htmlFor="specificCoachingPoints">Specific Coaching Points:</label>
                <input type="text" id="specificCoachingPoints" name="specificCoachingPoints"
                       value={trainingData.specificCoachingPoints} onChange={handleChange}/><br/>

                <label htmlFor="neededMaterial">Needed Material:</label>
                <input type="text" id="neededMaterial" name="neededMaterial" value={trainingData.neededMaterial}
                       onChange={handleChange}/><br/>

                <select id="intensity" name="intensity" value={trainingData.intensity || ''} onChange={handleChange}
                        required>
                    <option value="">Select Intensity</option>
                    {Object.values(Intensity).map((value) => (
                        <option key={value} value={value}>{value}</option>
                    ))}
                </select><br/>

                <select id="pitch" name="pitch" value={trainingData.pitch || ''} onChange={handleChange} required>
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
