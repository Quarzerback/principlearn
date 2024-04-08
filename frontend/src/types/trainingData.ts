import { Intensity, Pitch } from "./enums.ts";

export type TrainingData = {
    id?: string;
    date: string;
    startTime: string;
    endTime: string;
    specificCoachingPoints?: string;
    neededMaterial?: string;
    intensity: Intensity | null;
    pitch: Pitch | null;
};