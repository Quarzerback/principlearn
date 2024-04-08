import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Layout from './components/Layout.tsx';
import Home from './pages/Home.tsx';
import AddTraining from './pages/AddTraining';
import Training from './pages/Training';
import axios from "axios";
import {useEffect, useState} from "react";
import {TrainingData} from "./types/trainingData.ts";
import TrainingDetails from "./pages/TrainingDetails.tsx";
import EditTraining from "./pages/EditTraining.tsx";

export default function App() {
    const [trainings, setTrainings] = useState<TrainingData[]>([]);

    function fetchData(){
        axios.get("/api/trainings")
            .then(response=> setTrainings(response.data))
            .catch(error => {
                console.error("Error fetching trainings", error)
            })
    }

    useEffect(fetchData, []);
    if (!trainings) {
        return "Loading..."
    }

    return (
        <Router>
            <Layout>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/training" element={<Training trainings={trainings} fetchData={fetchData}/>} />
                    <Route path="/training/add" element={<AddTraining />} />
                    <Route path="/training/:id" element={<TrainingDetails trainings={trainings} fetchData={fetchData}/>} />
                    <Route path="/training/:id/edit" element={<EditTraining trainings={trainings} fetchData={fetchData}/>} />
                </Routes>
            </Layout>
        </Router>
    );
}
