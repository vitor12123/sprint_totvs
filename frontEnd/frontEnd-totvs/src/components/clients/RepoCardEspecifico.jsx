import { Link } from "react-router-dom";

export default function RepoCardEspecifico({ id_reuniao, id_cliente, nota, data_conversa, dores, produtos, riscos, recomendacao, grau_urgencia}) {
  return (
    <div className="p-6 mx-auto grid grid-cols-2 text-white shadow rounded">
            <div>
                <h2 className="text-2xl font-bold mb-4">Reunião: {id_reuniao}</h2>
                <h3 className="text-lg font-semibold text-white mt-4 mb-1">Dores</h3>
                <p className="mb-2 text-gray-400">{dores}</p>

                <h3 className="text-lg font-semibold text-white mt-4 mb-1">Recomendação</h3>
                <p className="mb-2 text-gray-400">{recomendacao}</p>
                <div className="flex items-center gap-4 mt-6">
                    <strong>Cliente:</strong> {id_cliente}
                </div>
            </div>
            <ul className="space-y-2 text-gray-400">
                <li><strong>Produtos:</strong> {produtos || "Nenhum"}</li>
                <li><strong>Data da conversa:</strong> {data_conversa ? data_conversa.split("-").reverse().join("/") : "Não informada"}</li>
                <li><strong>Riscos:</strong> {riscos || "Nenhum"}</li>
                <li><strong>Nota NPS:</strong> {nota}</li>
                <li><strong>Grau de urgência:</strong> {grau_urgencia}</li>
            </ul>
        </div>
    );
}