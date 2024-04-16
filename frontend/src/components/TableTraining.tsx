import {TrainingData} from "../types/trainingData.ts";
import {Link} from "react-router-dom";
import "./TableTraining.css";
import {TableContainer, Table, TableHead, TableBody, TableRow, TableCell, Paper} from "@mui/material";

export type TableTrainingProps = {
    trainings: TrainingData[];
}
export default function TableTraining(props: Readonly<TableTrainingProps>) {

        return(
        <TableContainer component={Paper}>
            <Table className={"training-table"}>
                <TableHead>
                    <TableRow>
                        <TableCell>Date</TableCell>
                        <TableCell>Start Time</TableCell>
                        <TableCell>End Time</TableCell>
                        <TableCell>Specific Coaching Points</TableCell>
                        <TableCell>Needed Material</TableCell>
                        <TableCell>Intensity</TableCell>
                        <TableCell>Pitch</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {props.trainings.map((training) => (
                        <TableRow key={training.id}>
                            <TableCell>{training.date}</TableCell>
                            <TableCell>{training.startTime}</TableCell>
                            <TableCell>{training.endTime}</TableCell>
                            <TableCell>{training.specificCoachingPoints}</TableCell>
                            <TableCell>{training.neededMaterial}</TableCell>
                            <TableCell>{training.intensity}</TableCell>
                            <TableCell>{training.pitch}</TableCell>
                            <TableCell>
                                <Link to={`/training/${training.id}`}>Details</Link>
                            </TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
        )
    }