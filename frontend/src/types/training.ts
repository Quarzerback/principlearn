import { Intensity, Pitch } from "./enums.ts";

export type TrainingFormData = {
    date: string;
    startTime: string;
    endTime: string;
    specificCoachingPoints?: string;
    neededMaterial?: string;
    intensity: Intensity | null;
    pitch: Pitch | null;
};