import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Layout from './components/Layout.tsx';
import Home from './pages/Home.tsx';
import AddTraining from './pages/AddTraining';

export default function App() {
    return (
        <Router>
            <Layout>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/training/add" element={<AddTraining />} />
                </Routes>
            </Layout>
        </Router>
    );
}
