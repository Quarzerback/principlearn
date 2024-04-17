import { Link } from 'react-router-dom';

export default function Navigation() {
    return (
        <nav>
            <ul style={{ listStyleType: 'none', padding: 0 }}>
                <li>
                    <Link to="/">Home</Link>
                </li>
                <li>
                    <Link to="/training">Trainings</Link>
                </li>
            </ul>
        </nav>
    );
}