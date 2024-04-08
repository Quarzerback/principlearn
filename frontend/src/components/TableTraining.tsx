import {TrainingData} from "../types/trainingData.ts";
import {Link} from "react-router-dom";

export type TableTrainingProps = {
    trainings: TrainingData[];
}
export default function TableTraining(props: Readonly<TableTrainingProps>) {
    return (
        <table>
            <thead>
            <tr>
                <th>Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Specific Coaching Points</th>
                <th>Needed Material</th>
                <th>Intensity</th>
                <th>Pitch</th>
            </tr>
            </thead>
            <tbody>
            {props.trainings.map((training) => (
                <tr key={training.id}>
                    <td>{training.date}</td>
                    <td>{training.startTime}</td>
                    <td>{training.endTime}</td>
                    <td>{training.specificCoachingPoints}</td>
                    <td>{training.neededMaterial}</td>
                    <td>{training.intensity}</td>
                    <td>{training.pitch}</td>
                    <td>
                        <Link to={`/training/${training.id}`}>Details</Link>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}