import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "../pages/Login";
import Home from "../pages/Home";
import Clients from "../pages/Clients";
import DashBoard from "../pages/DashBoard";
import RepoPage from "../pages/RepoPage";

function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<Home />} />
        <Route path="/cliente" element={<Clients />} />
        <Route path="/dashboard" element={<DashBoard />} />
        <Route
          path="/repo/:id"
          element={<RepoPage />}
        />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;