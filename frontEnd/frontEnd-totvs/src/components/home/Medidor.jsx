import React, { useEffect, useState } from 'react';

function Medidor() {
  const [dados, setDados] = useState([]);

  useEffect(() => {
        fetch("http://localhost:8080/home/medidor")
            .then((resposta) => {
                if (!resposta.ok) {
                    throw new Error("Erro ao buscar os dados");
                } 
                return resposta.json();
            })
            .then((dadosRecebidos) => {
                setDados(dadosRecebidos);
            })
            .catch((erro) => {
                console.error("Erro:", erro);
            });
    }, []);

    let notaMediaClientes = 0;

    let listaNumerica = [0,10,10];

    for(let numero in dados){
        let transforma = parseFloat(dados[numero], 10)

        listaNumerica.push(listaNumerica[numero])

        notaMediaClientes += listaNumerica[numero];
    }

    notaMediaClientes = notaMediaClientes / listaNumerica.length

    let angle = notaMediaClientes 

  return (
    <div className="">

        <h2 className="text-3xl font-semibold mb-4 ml-[-6%] mt-[-4%]">
            Sentiment Analysis
        </h2>

        <div className="h-32 flex items-center justify-center">

            <div className="relative flex flex-col items-center justify-center">

                {/* Container do medidor */}
                <div className="relative w-[280px] h-[140px] bg-gradient-to-r from-red-400 via-yellow-400 to-green-400 bg-gray-200 rounded-t-[150px] overflow-hidden shadow-inner">

                    {/* PONTEIRO PRINCIPAL */}
                    <div
                    className="absolute bottom-0 left-1/2 w-1 h-[120px] bg-gray-800 rounded-t z-10 transition-transform duration-300 ease-in-out"
                    style={{
                        transform: `translateX(-50%) rotate(${((angle * 36) - 180)/ 2}deg)`,
                        transformOrigin: 'bottom center',
                    }}
                    >
                    {/* Círculo central (eixo) */}
                    <div className="absolute -bottom-[6px] left-1/2 -translate-x-1/2 w-4 h-4 bg-gray-900 rounded-full border-2 border-white shadow-md" />
                    </div>
                </div>

            </div>

        </div>

        <p className="text-lg text-gray-400 mt-15 ml-[-6%]">
            Overall Sentiment: High Satisfaction ({parseInt(angle * 10)} %)
            -
            Source: Meeting Transcripts & Emails
        </p>
    </div>
  );
}

export default Medidor;