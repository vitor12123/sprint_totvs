import { BrowserRouter , Routes, Route} from "react-router-dom";
import Login from "../pages/Login";

function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                {/* Adicione outras rotas aqui depois */}
            </Routes>
        </BrowserRouter>
    );
}

export default AppRoutes;