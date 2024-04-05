import {TrainingData} from "../types/trainingData.ts";
import TableTraining from "../components/TableTraining.tsx";
import {useNavigate} from "react-router-dom";

type TrainingProps={
    fetchData:()=>void;
    trainings: TrainingData[]
}
export default function Training(props: Readonly<TrainingProps>) {
    const navigate = useNavigate();

    function handleNewTraining(){
        navigate("/training/add");
    }

    return (
        <div>
            <h1>Trainings</h1>
            <TableTraining trainings={props.trainings}/>
            <button onClick={handleNewTraining}>New Training</button>
        </div>
    );
}