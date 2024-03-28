import {useState} from "react";

export default function AddTraining() {
    const [trainingData, setTrainingData] = useState({
        date: '',
        startTime: '',
        endTime: '',
        specificCoachingPoints: '',
        neededMaterial: ''
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setTrainingData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        // Here you can add code to handle the form submission, such as sending the data to the server
        console.log('Form submitted:', trainingData);
        // Reset the form after submission
        setTrainingData({
            date: '',
            startTime: '',
            endTime: '',
            specificCoachingPoints: '',
            neededMaterial: ''
        });
    };

    return (
        <div>
            <h2>Add Training</h2>
            <form onSubmit={handleSubmit}>
                <label>Date:</label>
                <input type="date" name="date" value={trainingData.date} onChange={handleChange} required /><br />

                <label>Start Time:</label>
                <input type="time" name="startTime" value={trainingData.startTime} onChange={handleChange} required /><br />

                <label>End Time:</label>
                <input type="time" name="endTime" value={trainingData.endTime} onChange={handleChange} required /><br />

                <label>Specific Coaching Points:</label>
                <input type="text" name="specificCoachingPoints" value={trainingData.specificCoachingPoints} onChange={handleChange} required /><br />

                <label>Needed Material:</label>
                <input type="text" name="neededMaterial" value={trainingData.neededMaterial} onChange={handleChange} required /><br />

                <button type="submit">Submit</button>
            </form>
        </div>
    );
}