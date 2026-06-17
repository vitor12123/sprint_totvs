import {Outlet} from "react-router-dom"
import AppRoutes from "./routes/AppRoutes";

export default function App() {
    return (
        <div className="">
          <AppRoutes />
          <main className="p-6">
          <Outlet />
          </main>
        </div>
      );
}