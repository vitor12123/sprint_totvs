import { useLocation } from "react-router-dom";
import Header from "../components/Header"

export default function Home() {

  const location = useLocation();
  const email = location.state.email;

    return(
        <div id="home">
            <div>
                <Header />
            </div>
        </div>
    )
}