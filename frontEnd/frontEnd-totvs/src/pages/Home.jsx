import { useLocation } from "react-router-dom";

export default function Home() {

  const location = useLocation();
  const email = location.state.email;

    return(
        <div>
            <h1>parabens vc entrou com : {email}</h1>
        </div>
    )
}