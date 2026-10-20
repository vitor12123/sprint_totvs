import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function Clients() {
    const [dados, setDados] = useState([]);
  const API = import.meta.env.VITE_BACKEND_URL;

  useEffect(() => {
    fetch(`${API}/cliente`)
      .then((res) => {
        if (!res.ok) {
          throw new Error("Erro ao buscar os dados");
        }

        return res.json();
      })
      .then((data) => {
        setDados(data);
      })
      .catch((err) => console.error(err));
  }, [API]);

  return (
    <div>
      <h1>Análise de Conversas</h1>

      <section>
        <h2>Dores do cliente</h2>
        <p>{dados[0]}</p>
      </section>

      <section>
        <h2>Produto mencionado</h2>
        <p>{dados[1]}</p>
      </section>

      <section>
        <h2>Risco identificado</h2>
        <p>{dados[2]}</p>
      </section>

      <section>
        <h2>Solução recomendada</h2>
        <p>{dados[3]}</p>
      </section>

      <section>
        <h2>Grau de urgência</h2>
        <p>{dados[4]}</p>
      </section>
    </div>
  );
}