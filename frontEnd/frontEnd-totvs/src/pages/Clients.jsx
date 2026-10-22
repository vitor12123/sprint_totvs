import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import RepoCard from "../components/clients/RepoCardBasico";
import SectionContainer from "../components/clients/SectionContainer";

export default function Clients() {
  const [dados, setDados] = useState([]);
  const API = import.meta.env.VITE_BACKEND_URL;

  useEffect(() => {
    fetch(`${API}/client`)
      .then((res) => {
        if (!res.ok) {
          throw new Error("Erro ao buscar os dados");
        }

        return res.json();
      })
      .then((data) => {
        setDados(data);
      })
      .then((data) => {
      console.log(data);
      console.log(data.map(repo => repo.id_reuniao));
      setDados(data);
    })
      .catch((err) => console.error(err));
  }, [API]);

  return (
    <div>
      <h1>Análise de Conversas</h1>

      <SectionContainer>
        {dados.map((repo) => {
          const [id_reuniao, id_cliente, nota, data_conversa] = repo;

          return (
            <RepoCard
              key={id_reuniao}
              id_reuniao={id_reuniao}
              id_cliente={id_cliente}
              nota={nota}
              data_conversa={data_conversa}
            />
          );
        })}
      </SectionContainer>
    </div>
  );
}