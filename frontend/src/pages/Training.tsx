import {TrainingData} from "../types/trainingData.ts";
import TableTraining from "../components/TableTraining.tsx";

type TrainingProps={
    fetchData:()=>void;
    trainings: TrainingData[]
}
export default function Training(props: Readonly<TrainingProps>) {
    return (
        <div>
            <h1>Trainings</h1>
            <TableTraining trainings={props.trainings}/>
        </div>
    );
}