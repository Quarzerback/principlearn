import { TrainingData } from "../types/trainingData";
import { Intensity, Pitch } from "../types/enums";
import React from "react";
import {
    TextField,
    MenuItem,
    Button,
    Grid,
    Container,
    Typography
} from "@mui/material";

type TrainingFormProps = {
    trainingData: TrainingData;
    handleChange: (event: React.ChangeEvent<HTMLInputElement>) => void;
    handleSubmit: (event: React.FormEvent<HTMLFormElement>) => void;
    buttonName: string;
    headlineName: string;
};

export default function TrainingInputForm(props: Readonly<TrainingFormProps>) {
    return (
        <Container sx={{ marginTop: 4, marginBottom: 4 }}>
            <Typography variant="h4" gutterBottom>{props.headlineName}</Typography>
            <form onSubmit={props.handleSubmit}>
                <Grid container spacing={2}>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            fullWidth
                            type="date"
                            label="Date"
                            InputLabelProps={{ shrink: true }}
                            name="date"
                            value={props.trainingData.date}
                            onChange={props.handleChange}
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            fullWidth
                            type="time"
                            label="Start Time"
                            InputLabelProps={{ shrink: true }}
                            name="startTime"
                            value={props.trainingData.startTime}
                            onChange={props.handleChange}
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            fullWidth
                            type="time"
                            label="End Time"
                            InputLabelProps={{ shrink: true }}
                            name="endTime"
                            value={props.trainingData.endTime}
                            onChange={props.handleChange}
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            fullWidth
                            label="Specific Coaching Points"
                            name="specificCoachingPoints"
                            value={props.trainingData.specificCoachingPoints}
                            onChange={props.handleChange}
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            fullWidth
                            label="Needed Material"
                            name="neededMaterial"
                            value={props.trainingData.neededMaterial}
                            onChange={props.handleChange}
                        />
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            select
                            fullWidth
                            label="Intensity"
                            name="intensity"
                            value={props.trainingData.intensity ?? ''}
                            onChange={props.handleChange}
                        >
                            {Object.values(Intensity).map(intensity => (
                                <MenuItem key={intensity} value={intensity}>
                                    {intensity}
                                </MenuItem>
                            ))}
                        </TextField>
                    </Grid>
                    <Grid item xs={12} sm={6}>
                        <TextField
                            select
                            fullWidth
                            label="Pitch"
                            name="pitch"
                            value={props.trainingData.pitch ?? ''}
                            onChange={props.handleChange}
                        >
                            {Object.values(Pitch).map(pitch => (
                                <MenuItem key={pitch} value={pitch}>
                                    {pitch}
                                </MenuItem>
                            ))}
                        </TextField>
                    </Grid>
                </Grid>
                <Button type="submit" variant="contained" color="primary" sx={{ marginTop: 2 }}>{props.buttonName}</Button>
            </form>
        </Container>
    );
}
