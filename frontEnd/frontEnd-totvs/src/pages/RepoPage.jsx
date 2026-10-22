import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import RepoCardEspecifico from "../components/clients/RepoCardEspecifico";

export default function RepoPage() {
  const { id } = useParams();
  const [details, setDetails] = useState(null);
  const [erro, setErro] = useState("");
  const API = import.meta.env.VITE_BACKEND_URL;

  useEffect(() => {
    fetch(`${API}/repo/${id}`)
      .then((res) => {
        if (!res.ok) {
          throw new Error("Erro ao buscar os dados");
        }

        return res.json();
      })
      .then((data) => {
        console.log("Dados recebidos:", data);
        console.log("Tipo dos dados:", Array.isArray(data) ? "Lista" : "Objeto");

        setDetails(data);
      })
      .catch((err) => {
        console.error(err);
        setErro("Não foi possível carregar os dados da reunião.");
        });
  }, [API, id]);

  if (!details) return <p>Carregando...</p>;

  if (erro) return <p className="text-red-500">{erro}</p>;
  if (!details) return <p className="text-white">Carregando...</p>;

  return <RepoCardEspecifico {...details} />;
}