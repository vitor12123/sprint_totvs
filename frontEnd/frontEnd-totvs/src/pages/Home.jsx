import { useLocation } from "react-router-dom";
import Header from "../components/home/Header";
import Medidor from "../components/home/Medidor";
import SideBar from "../components/home/SideBar";
import { useState } from "react";
import { useEffect } from "react";

export default function Home() {

    const [email, setEmail] = useState("");
    const [telefone, setTelefone] = useState("");
    const [cargo, setCargo] = useState("");
    const [nome, setNome] = useState("");


    async function getEmail() {

        const pergunta2 = await fetch(`${import.meta.env.VITE_BACKEND_URL}/pessoa`, {
            method: "GET"
        });

        const resposta2 = await pergunta2.json();
    
        setEmail(resposta2[0]);
        setTelefone(resposta2[1]);
        setCargo(resposta2[2]);
        setNome(resposta2[3]);
        
    }

    useEffect(() => {
        getEmail();
    }, []);

    return (
        <div className="min-h-screen bg-[#202B3A] text-white">

            <Header />

            <div className="flex">

                {/* SIDEBAR */}
                <div>
                    <SideBar />
                </div>

                {/* CONTEÚDO */}
                <main className="flex-1 p-3">

                    {/* Título */}
                    <div className="mb-2">

                        <h1 className="text-3xl font-bold">
                            Client Detail View
                        </h1>

                        <p className="text-md text-gray-400">
                            Nexus &gt; Clients &gt; {nome}
                        </p>

                    </div>


                    {/* CLIENTE */}
                    <section className="bg-[#496887] border border-[#6685A3] rounded-md p-9 mb-6 ml-3 mr-3 text-center">

                        <h2 className="text-4xl font-semibold">
                            {nome} ({cargo}, ABCDEFGH corp.)
                        </h2>

                        <p className="text-lg text-gray-200">
                            {email} | {telefone} | São Paulo
                        </p>

                    </section>


                    {/* GRID PRINCIPAL */}
                    <div className="grid grid-cols-2 gap-2">

                        {/* PRODUTOS CONTRATADOS */}
                        <section className="bg-[#29394A] border border-[#617487] rounded-md p-20 ml-3 mr-3 mb-4">

                            <h2 className="text-3xl font-semibold mb-2">
                                Contracted Products
                            </h2>

                            <table className="w-full text-2xl">
                                <thead>
                                    <tr className="text-gray-300 border-b border-[#536579]">
                                        <th className="text-left p-1">
                                            Client Name
                                        </th>

                                        <th>
                                            Status
                                        </th>

                                        <th>
                                            Contract Start Date
                                        </th>
                                    </tr>
                                </thead>

                                <tbody>

                                    <tr className="border-b border-[#536579]">
                                        <td className="p-1">
                                            ◉ Nexus ERP (Standard)
                                        </td>

                                        <td className="text-center">
                                            Standard
                                        </td>

                                        <td className="text-center">
                                            2023-11-13
                                        </td>
                                    </tr>

                                    <tr className="border-b border-[#536579]">
                                        <td className="p-1">
                                            ◉ NexLogistics (Pro)
                                        </td>

                                        <td className="text-center">
                                            Standard
                                        </td>

                                        <td className="text-center">
                                            2023-11-13
                                        </td>
                                    </tr>

                                    <tr>
                                        <td className="p-1">
                                            ◉ NexHR (Lite)
                                        </td>

                                        <td className="text-center">
                                            Lite
                                        </td>

                                        <td className="text-center">
                                            2023-11-13
                                        </td>
                                    </tr>

                                </tbody>
                            </table>

                        </section>


                        {/* PRODUTOS MENCIONADOS */}
                        <section className="bg-[#29394A] border border-[#617487] rounded-md p-20 ml-3 mr-3 mb-4">

                            <h2 className="text-3xl font-semibold mb-2">
                                Products Mentioned in Meeting (Last 30 Days)
                            </h2>

                            <div className="text-2xl">

                                <div className="flex justify-between p-2 border-b border-[#536579]">
                                    <span>1&nbsp;&nbsp; NexHR (3 mentions)</span>
                                </div>

                                <div className="flex justify-between p-2 border-b border-[#536579]">
                                    <span>2&nbsp;&nbsp; CRM Module (2 mentions)</span>
                                </div>

                                <div className="flex justify-between p-2">
                                    <span>3&nbsp;&nbsp; NexBI (1 mention)</span>
                                </div>

                            </div>

                        </section>


                        {/* SENTIMENT */}
                        <section className="bg-[#29394A] border border-[#617487] rounded-md p-20 ml-3 mr-3 pb-[-10%]">

                            <Medidor />

                        </section>


                        {/* COMPETITOR */}
                        <section className="bg-[#29394A] border border-[#617487] rounded-md p-20 ml-3 mr-3 ">

                            <div className="h-64 border border-red-400 rounded-md flex flex-col items-center justify-center text-red-400">

                                <span className="text-6xl">
                                    !!
                                </span>

                                <span className="text-4xl font-semibold">
                                    Competitor Mentioned: Senior !!
                                </span>

                                <span className="text-4xl text-gray-400 mt-1">
                                    Source: ID Meeting 1247082
                                </span>

                            </div>

                        </section>

                    </div>

                </main>


                {/* DIREITA */}
                <aside className="w-70 bg-[#263343] border-l border-[#3B4654] p-2">

                    <div className="flex items-center gap-2 mb-3">
                        <img
                            src="/logoTotvs.webp"
                            className="w-6 h-6"
                        />

                        <span className="font-bold">
                            TOTVS
                        </span>
                    </div>

                    <div className="bg-[#29394A] border border-[#526579] rounded-md p-2">

                        <h2 className="text-2xl font-semibold">
                            Confidence Score
                        </h2>

                        <div className="text-2xl text-green-400 text-center my-3">
                            85%
                        </div>

                        <p className="text-sm text-gray-400">
                            Prediction for 90-day
                            Renewal: <span className="text-green-400">
                                High
                            </span>
                        </p>

                    </div>

                </aside>

            </div>

        </div>
    );
}