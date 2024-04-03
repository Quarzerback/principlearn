import { Link } from 'react-router-dom';
export default function Navigation() {
    return (
        <nav>
            <ul>
                <li>
                    <Link to="/">Home</Link>
                </li>
                <li>
                    <Link to="/training/add">Add Training</Link>
                </li>
            </ul>
        </nav>
    );
}
