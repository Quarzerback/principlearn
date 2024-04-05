import {TrainingData} from "../types/trainingData";
import {Intensity, Pitch} from "../types/enums";

type TrainingFormProps = {
    trainingData: TrainingData;
    handleChange: (event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => void;
    handleSubmit: (event: React.FormEvent<HTMLFormElement>) => void;
    buttonName: string;
    headlineName: string;
};

export default function TrainingInputForm(props: Readonly<TrainingFormProps>) {
    return (
        <div>
            <h2>{props.headlineName}</h2>
            <form onSubmit={props.handleSubmit}>
                <label htmlFor="date">Date:</label>
                <input type="date" id="date" name="date" value={props.trainingData.date} onChange={props.handleChange}
                       required/><br/>

                <label htmlFor="startTime">Start Time:</label>
                <input type="time" id="startTime" name="startTime" value={props.trainingData.startTime}
                       onChange={props.handleChange} required/><br/>

                <label htmlFor="endTime">End Time:</label>
                <input type="time" id="endTime" name="endTime" value={props.trainingData.endTime}
                       onChange={props.handleChange}
                       required/><br/>

                <label htmlFor="specificCoachingPoints">Specific Coaching Points:</label>
                <input type="text" id="specificCoachingPoints" name="specificCoachingPoints"
                       value={props.trainingData.specificCoachingPoints} onChange={props.handleChange}/><br/>

                <label htmlFor="neededMaterial">Needed Material:</label>
                <input type="text" id="neededMaterial" name="neededMaterial" value={props.trainingData.neededMaterial}
                       onChange={props.handleChange}/><br/>

                <select id="intensity" name="intensity" value={props.trainingData.intensity || ''}
                        onChange={props.handleChange}
                        required>
                    <option value="">Select Intensity</option>
                    {Object.values(Intensity).map((value) => (
                        <option key={value} value={value}>{value}</option>
                    ))}
                </select><br/>

                <select id="pitch" name="pitch" value={props.trainingData.pitch || ''} onChange={props.handleChange}
                        required>
                    <option value="">Select Pitch</option>
                    {Object.values(Pitch).map((value) => (
                        <option key={value} value={value}>{value}</option>
                    ))}
                </select><br/>
                <button type="submit">{props.buttonName}</button>
            </form>
        </div>
    );
}