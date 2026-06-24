import { BrowserRouter , Routes, Route} from "react-router-dom";
import Login from "../pages/Login";
import Home from "../pages/Home"

function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/home" element={<Home />} />
                {/* Adicione outras rotas aqui depois */}
            </Routes>
        </BrowserRouter>
    );
}

export default AppRoutes;