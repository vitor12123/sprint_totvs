import { Link } from "react-router-dom";

export default function RepoCard({ id_reuniao, id_cliente, nota, data_conversa}) {
  return (
    <div className={`flex items-center justify-between border rounded-lg p-4 border-red-700 shadow hover:scale-102 transition transform duration-200`}>
      <div className="p-1.5">
        <h3 className="font-bold text-lg text-white">ID da reunião: {id_reuniao}</h3>
        <h3 className="font-bold text-lg text-white">ID do cliente: {id_cliente}</h3>
        <p className="text-white mt-2">Data da reunião: {data_conversa}</p>
        <p className="text-sm text-white mt-1 font-bold">⭐ Nota: {nota === "" ? "Sem dados fornecidos" : nota}</p>
       </div>
       <div>
            <Link
                to={`/repo/${id_reuniao}`}
                >
                <div className="text-center mt-4 p-2 bg-white rounded text-red-700 font-medium ">
                    Ver detalhes
                </div>
            </Link>
        </div>
    </div>
  );
}