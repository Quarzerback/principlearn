import {TrainingData} from "../types/trainingData.ts";
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";


type TrainingDetailsProps={
    trainings: TrainingData[],
    fetchData: ()=>void
}

export default function TrainingDetails(props: Readonly<TrainingDetailsProps>) {
    const params = useParams();
    const training = props.trainings.find(training => training.id === params.id);
    const navigate = useNavigate();
    console.log("Params ID:", params.id);
    function handleDelete() {
        if (training !== undefined) {
            const confirmDelete = window.confirm("Do you want to delete this training?");
            if (confirmDelete) {
                axios.delete("/api/trainings/" + training.id)
                    .then(props.fetchData)
                    .catch(error => {
                        console.error("Error deleting training:", error);
                    });
                navigate("/training");
            }
        }
    }
    function handleEdit() {
        if (training !== undefined) {
            navigate("/training/" + training.id + "/edit");
        }
    }

    return (
        <div>
            <h1>Training Details</h1>
            {training ?
                <>
                    <div>
                        <div>
                            <p>Date: {training.date}</p>
                            <p>From: {training.startTime}</p>
                            <p>To: {training.endTime}</p>
                            <p>Specific Coaching Points: {training.specificCoachingPoints}</p>
                            <p>Needed Material: {training.neededMaterial}</p>
                            <p>Intensity: {training.intensity}</p>
                            <p>Pitch: {training.pitch}</p>
                        </div>
                    </div>
                    <div>
                        <button onClick={handleEdit}>Edit</button>
                        <button onClick={handleDelete}>Delete</button>
                    </div>
                </> :
                <>No Training found</>
            }
        </div>
    )
}